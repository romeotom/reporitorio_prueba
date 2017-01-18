package ec.gob.educacion.activos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import ec.gob.educacion.acceso.dto.ReporteGeneralDTO;
import ec.gob.educacion.acceso.scope.ViewScoped;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.ActMesParametrizado;
import ec.gob.educacion.activos.model.asignacion.InsCanton;
import ec.gob.educacion.activos.model.asignacion.InsDistrito;
import ec.gob.educacion.activos.model.asignacion.InsInstitucion;
import ec.gob.educacion.activos.model.asignacion.InsProvincia;
import ec.gob.educacion.activos.model.asignacion.InsZona;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.activos.resources.JavaPoiUtils;
import ec.gob.educacion.activos.resources.Utils;
import ec.gob.educacion.activos.service.CantonService;
import ec.gob.educacion.activos.service.DistritoService;
import ec.gob.educacion.activos.service.InstitucionService;
import ec.gob.educacion.activos.service.ItemCatalogoService;
import ec.gob.educacion.activos.service.MesParametrizadoService;
import ec.gob.educacion.activos.service.ProvinciaService;
import ec.gob.educacion.activos.service.ReporteGeneralService;
import ec.gob.educacion.activos.service.ZonaService;

@Named
@ViewScoped
public class ReporteActivosController extends BaseController implements Serializable {

	private static final long serialVersionUID = -7067833779093082280L;
	
	@EJB
	private InstitucionService institucionService;
	@EJB
	private ItemCatalogoService itemCatalogoService;
	@EJB
	private ReporteGeneralService reporteGeneralService;
	@EJB
	private ZonaService zonaService;
	@EJB
	private ProvinciaService provinciaService;
	@EJB
	private CantonService cantonService;
	@EJB
	private DistritoService distritoService;
	@EJB
	private MesParametrizadoService mesParametrizadoService;
	
	@Inject
	private SessionController sessionController;
	
	private InsInstitucion insInstitucion;
	private List<ActItemCatalogo> itemsCatalogo;
	private List<ActItemCatalogo> tiposLaboratorios = new ArrayList<ActItemCatalogo>();
	private List<ReporteGeneralDTO> reporte = new ArrayList<ReporteGeneralDTO>();
	private JavaPoiUtils poi = new JavaPoiUtils();
	
	private Integer activarTotales;
	private boolean emptyReport;
	private boolean verReporteria;
	private boolean esAdministrador;
	private boolean esZona;
	private boolean esDistrito;
	private String mensajeAcceso;
	private String usuarioLogueado;
	
	private String codigoZonaSenplades;
	private String codigoDistrito;
	private String codigoProvincia;
	private String codigoCanton;
	private String amie;
	private Integer estadoIE;
	private Integer estadoFormulario;
	private Date fechaCargaFormulario;
	private Long codigoTipoLaboratorio;
	private Integer tieneInternetLab;
	private Integer laboratorioEnUso;
	private Integer estadoActivoCompImp;
	private Boolean consultaPolitica;
	private String comparacionFechaCarga;
	private Integer urbanoRural;
	private List<InsZona> zonas;
	private List<InsProvincia> provincias;
	private List<InsDistrito> distritos;
	private List<InsCanton> cantones;
	private Integer opcionConsultaCargaFormulario;
	private List<ActMesParametrizado> mesesParametrizados;
	private Integer mesConsultar;
	
	

	@PostConstruct
	public void init() {
		verificacionAcceso(sessionController.getUserSecurity().getUsername(), "reporteGeneral.xhtml");
		usuarioLogueado = sessionController.getUserSecurity().getUsername();
		validarAcceso();
		itemsCatalogo = itemCatalogoService.listarTodos();
		cargarTiposLaboratorios();
		int anioActual = Calendar.getInstance().get(Calendar.YEAR);
		mesesParametrizados = mesParametrizadoService.ListadoPorAnio(anioActual);
	}
	
	public void generarReporte(){
		if(codigoTipoLaboratorio!= null && codigoTipoLaboratorio.intValue() == -1){
			codigoTipoLaboratorio = null;
		}
		
		emptyReport = false;
		reiniciarListado();
		
		if(activarTotales!= null){
			switch (activarTotales.intValue()) {
			case 1:
				reporte.addAll(reporteGeneralService.listaInformacionReporte(validationString(amie), validationString(codigoZonaSenplades), validationString(codigoDistrito), 
						validationString(codigoProvincia), validationString(codigoCanton), validationInteger(estadoIE), validationInteger(estadoFormulario), 
						validationInteger(laboratorioEnUso), validationInteger(tieneInternetLab), Utils.dateToString(fechaCargaFormulario, "dd-MM-yyyy"), comparacionFechaCarga, validationInteger(urbanoRural), 
						codigoTipoLaboratorio, validationInteger(estadoActivoCompImp), itemsCatalogo));
				break;

			case 2:
				reporte.addAll(reporteGeneralService.listaInformacionTotalesReporte(validationString(amie), validationString(codigoZonaSenplades), validationString(codigoDistrito), 
						validationString(codigoProvincia), validationString(codigoCanton), validationInteger(estadoIE), validationInteger(estadoFormulario), 
						validationInteger(laboratorioEnUso), validationInteger(tieneInternetLab), Utils.dateToString(fechaCargaFormulario, "dd-MM-yyyy"), comparacionFechaCarga, validationInteger(urbanoRural), 
						codigoTipoLaboratorio, validationInteger(estadoActivoCompImp), itemsCatalogo));
				break;
				
			case 3:
				reporte.addAll(reporteGeneralService.listaInformacionInstitucionesCarga(validationString(codigoZonaSenplades), validationString(codigoDistrito), validationString(codigoProvincia), 
						validationString(codigoCanton), validationInteger(estadoIE), mesConsultar, validationInteger(urbanoRural), opcionConsultaCargaFormulario));
				break;
			}
		}
		
		emptyReport = reporte.isEmpty();
	}
	
	public void generarReporteTotal(){
		if(activarTotales!= null){
			switch (activarTotales.intValue()) {
			case 1:
				poi.generarExcelConsolidado(reporte);
				break;

			case 2:
				poi.generarExcelTotales(reporte);
				break;
				
			case 3:
				String tipoConsulta = "";
				if(opcionConsultaCargaFormulario!=null && opcionConsultaCargaFormulario.intValue()==Constantes.INSTITUCIONES_HAN_CARGADO_FORMULARIO){
					tipoConsulta = "IE-con-carga-formulario";
				}
				if(opcionConsultaCargaFormulario!=null && opcionConsultaCargaFormulario.intValue()==Constantes.INSTITUCIONES_NO_HAN_CARGADO_FORMULARIO){
					tipoConsulta = "IE-sin-carga-formulario";
				}
				if(opcionConsultaCargaFormulario!=null && opcionConsultaCargaFormulario.intValue()==Constantes.INSTITUCIONES_SIN_INICIO_DE_CARGA_FORMULARIO){
					tipoConsulta = "IE-sin-inicio-carga";
				}
				poi.generarExcelCargaInstituciones(reporte, tipoConsulta);
				break;
			}
		}

	}
	
	public void cargarListadoZonasProvincias(){
		reiniciarListado();
		if(consultaPolitica){
			provincias = provinciaService.listarProvincias();
		}else {
			zonas = zonaService.listarZonas();
		}
	}

	public void cargarListadoDistritosCantones(){
		if(consultaPolitica){
			cantones = cantonService.listarCantonesPorCodigoProvincia(codigoProvincia);
		}else {
			distritos = distritoService.listarDistritosPorCodigoZona(codigoZonaSenplades);
		}
	}
	
	public void cargarTiposLaboratorios(){
		tiposLaboratorios.clear();
		for ( ActItemCatalogo item : itemsCatalogo) {
			if(item.getActCatalogo().getNemonico().equals(Constantes.TIPO_SALA_LAB)){
				ActItemCatalogo newItem = new ActItemCatalogo();
				newItem = item;
				newItem.setDescripcion(Utils.acronimoLaboratorioSala(item.getCodigo()) + item.getDescripcion());
				tiposLaboratorios.add(newItem);
			}
		}
	}
	
	private String validationString(String variable){
		String validada = variable;
		if(validada != null && validada.isEmpty()){
			validada = null;
		}
		return validada;
	}
	
	private Integer validationInteger(Integer variable){
		Integer validada = variable;
		if(validada != null && validada.intValue() == -1){
			validada = null;
		}
		return validada;
	}
	
	public void reiniciarValores(){		
		codigoZonaSenplades = null;
		codigoDistrito = null;
		codigoProvincia = null;
		codigoCanton = null;
		amie = null;
		estadoIE = null;
		estadoFormulario = null;
		fechaCargaFormulario = null;
		codigoTipoLaboratorio = null;
		tieneInternetLab = null;
		laboratorioEnUso = null;
		estadoActivoCompImp = null;
		comparacionFechaCarga = null;
		urbanoRural = null;
		opcionConsultaCargaFormulario = null;
		mesConsultar = null;
		reiniciarListado();
		validarAcceso();
	}
	
	private void validarAcceso(){
		esAdministrador = false;
		esZona = false;
		esDistrito = false;
		if(usuarioLogueado != null && !usuarioLogueado.isEmpty()){
			InsDistrito distrito = distritoService.obtenerPorCodigoSenplades(usuarioLogueado);
			if(distrito != null){
				esAdministrador = false;
				esZona = false;
				esDistrito = true;
				consultaPolitica = false;
				codigoZonaSenplades = distrito.getInsZona().getCodigoSenplades();
				codigoDistrito = distrito.getCodigoSenplades();
			}else {
				String numberOnly= usuarioLogueado.replaceAll("[^0-9]", "");
				Long codigo = (numberOnly != null && !numberOnly.isEmpty())?Long.valueOf(numberOnly):-1L;
				InsZona zona = zonaService.zonaPorCodigo(codigo);
				if(zona != null){
					esZona = true;
					esDistrito = false;
					esAdministrador = false;
					consultaPolitica = false;
					codigoZonaSenplades = zona.getCodigoSenplades();
					distritos = distritoService.listarDistritosPorCodigoZona(zona.getCodigoSenplades());
				}else {
					esAdministrador = true;
					esZona = false;
					esDistrito = false;
				}
			}
		}
	}
	
	
	public void reiniciarListado(){
		reporte.clear();
	}

	public InsInstitucion getInsInstitucion() {
		return insInstitucion;
	}

	public void setInsInstitucion(InsInstitucion insInstitucion) {
		this.insInstitucion = insInstitucion;
	}

	public List<ActItemCatalogo> getItemsCatalogo() {
		return itemsCatalogo;
	}

	public void setItemsCatalogo(List<ActItemCatalogo> itemsCatalogo) {
		this.itemsCatalogo = itemsCatalogo;
	}

	public List<ReporteGeneralDTO> getReporte() {
		return reporte;
	}

	public void setReporte(List<ReporteGeneralDTO> reporte) {
		this.reporte = reporte;
	}

	public Integer getActivarTotales() {
		return activarTotales;
	}

	public void setActivarTotales(Integer activarTotales) {
		this.activarTotales = activarTotales;
	}

	public boolean isEmptyReport() {
		return emptyReport;
	}

	public void setEmptyReport(boolean emptyReport) {
		this.emptyReport = emptyReport;
	}

	public String getCodigoZonaSenplades() {
		return codigoZonaSenplades;
	}

	public void setCodigoZonaSenplades(String codigoZonaSenplades) {
		this.codigoZonaSenplades = codigoZonaSenplades;
	}

	public String getCodigoDistrito() {
		return codigoDistrito;
	}

	public void setCodigoDistrito(String codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}

	public String getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public String getCodigoCanton() {
		return codigoCanton;
	}

	public void setCodigoCanton(String codigoCanton) {
		this.codigoCanton = codigoCanton;
	}

	public String getAmie() {
		return amie;
	}

	public void setAmie(String amie) {
		this.amie = amie;
	}

	public Integer getEstadoIE() {
		return estadoIE;
	}

	public void setEstadoIE(Integer estadoIE) {
		this.estadoIE = estadoIE;
	}

	public Integer getEstadoFormulario() {
		return estadoFormulario;
	}

	public void setEstadoFormulario(Integer estadoFormulario) {
		this.estadoFormulario = estadoFormulario;
	}

	public Date getFechaCargaFormulario() {
		return fechaCargaFormulario;
	}

	public void setFechaCargaFormulario(Date fechaCargaFormulario) {
		this.fechaCargaFormulario = fechaCargaFormulario;
	}

	public Long getCodigoTipoLaboratorio() {
		return codigoTipoLaboratorio;
	}

	public void setCodigoTipoLaboratorio(Long codigoTipoLaboratorio) {
		this.codigoTipoLaboratorio = codigoTipoLaboratorio;
	}

	public Integer getTieneInternetLab() {
		return tieneInternetLab;
	}

	public void setTieneInternetLab(Integer tieneInternetLab) {
		this.tieneInternetLab = tieneInternetLab;
	}

	public Integer getLaboratorioEnUso() {
		return laboratorioEnUso;
	}

	public void setLaboratorioEnUso(Integer laboratorioEnUso) {
		this.laboratorioEnUso = laboratorioEnUso;
	}

	public Integer getEstadoActivoCompImp() {
		return estadoActivoCompImp;
	}

	public void setEstadoActivoCompImp(Integer estadoActivoCompImp) {
		this.estadoActivoCompImp = estadoActivoCompImp;
	}

	public Boolean getConsultaPolitica() {
		return consultaPolitica;
	}

	public void setConsultaPolitica(Boolean consultaPolitica) {
		this.consultaPolitica = consultaPolitica;
	}

	public List<InsZona> getZonas() {
		return zonas;
	}

	public void setZonas(List<InsZona> zonas) {
		this.zonas = zonas;
	}

	public List<InsProvincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<InsProvincia> provincias) {
		this.provincias = provincias;
	}

	public List<InsDistrito> getDistritos() {
		return distritos;
	}

	public void setDistritos(List<InsDistrito> distritos) {
		this.distritos = distritos;
	}

	public List<InsCanton> getCantones() {
		return cantones;
	}

	public void setCantones(List<InsCanton> cantones) {
		this.cantones = cantones;
	}

	public List<ActItemCatalogo> getTiposLaboratorios() {
		return tiposLaboratorios;
	}

	public void setTiposLaboratorios(List<ActItemCatalogo> tiposLaboratorios) {
		this.tiposLaboratorios = tiposLaboratorios;
	}

	public String getComparacionFechaCarga() {
		return comparacionFechaCarga;
	}

	public void setComparacionFechaCarga(String comparacionFechaCarga) {
		this.comparacionFechaCarga = comparacionFechaCarga;
	}

	public Integer getUrbanoRural() {
		return urbanoRural;
	}

	public void setUrbanoRural(Integer urbanoRural) {
		this.urbanoRural = urbanoRural;
	}

	public String getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(String usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}

	public boolean isVerReporteria() {
		return verReporteria;
	}

	public void setVerReporteria(boolean verReporteria) {
		this.verReporteria = verReporteria;
	}

	public String getMensajeAcceso() {
		return mensajeAcceso;
	}

	public void setMensajeAcceso(String mensajeAcceso) {
		this.mensajeAcceso = mensajeAcceso;
	}

	public boolean isEsAdministrador() {
		return esAdministrador;
	}

	public void setEsAdministrador(boolean esAdministrador) {
		this.esAdministrador = esAdministrador;
	}

	public boolean isEsZona() {
		return esZona;
	}

	public void setEsZona(boolean esZona) {
		this.esZona = esZona;
	}

	public boolean isEsDistrito() {
		return esDistrito;
	}

	public void setEsDistrito(boolean esDistrito) {
		this.esDistrito = esDistrito;
	}

	public Integer getOpcionConsultaCargaFormulario() {
		return opcionConsultaCargaFormulario;
	}

	public void setOpcionConsultaCargaFormulario(
			Integer opcionConsultaCargaFormulario) {
		this.opcionConsultaCargaFormulario = opcionConsultaCargaFormulario;
	}

	public List<ActMesParametrizado> getMesesParametrizados() {
		return mesesParametrizados;
	}

	public void setMesesParametrizados(List<ActMesParametrizado> mesesParametrizados) {
		this.mesesParametrizados = mesesParametrizados;
	}

	public Integer getMesConsultar() {
		return mesConsultar;
	}

	public void setMesConsultar(Integer mesConsultar) {
		this.mesConsultar = mesConsultar;
	}

}
