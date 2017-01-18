package ec.gob.educacion.activos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import ec.gob.educacion.acceso.scope.ViewScoped;
import ec.gob.educacion.activos.model.ActAccesibilidadServicio;
import ec.gob.educacion.activos.model.ActConectividad;
import ec.gob.educacion.activos.model.ActCuartoServidore;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.ActLaboratorioSala;
import ec.gob.educacion.activos.model.ActTalentoHumano;
import ec.gob.educacion.activos.model.asignacion.InsInstitucion;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.activos.resources.FormReportGenerator;
import ec.gob.educacion.activos.resources.PdfGeneratorUtils;
import ec.gob.educacion.activos.resources.Utils;
import ec.gob.educacion.activos.service.AccesibilidadServicioService;
import ec.gob.educacion.activos.service.ConectividadService;
import ec.gob.educacion.activos.service.CuartoServidoreService;
import ec.gob.educacion.activos.service.FormularioService;
import ec.gob.educacion.activos.service.InstitucionService;
import ec.gob.educacion.activos.service.ItemCatalogoService;
import ec.gob.educacion.activos.service.SalaLaboratorioService;
import ec.gob.educacion.activos.service.TalentoHumanoService;

@Named
@ViewScoped
public class ImpresionFormularioController extends BaseController implements Serializable {

	private static final long serialVersionUID = -7067833779093082280L;
	
	@EJB
	private InstitucionService institucionService;
	@EJB
	private FormularioService formularioService;
	@EJB
	private TalentoHumanoService talentoHumanoService;
	@EJB
	private CuartoServidoreService cuartoServidoreService;
	@EJB
	private ItemCatalogoService itemCatalogoService;
	@EJB
	private SalaLaboratorioService salaLaboratorioService;
	@EJB
	private ConectividadService conectividadService;
	@EJB
	private AccesibilidadServicioService accesibilidadServicioService;
	
	@Inject
	private SessionController sessionController;
	
	private InsInstitucion insInstitucion;

	private String username;
	private Integer anioSeleccionado;
	private boolean verFormulario;
	private boolean errorImpresion;
	private String mensajeInstitucionError;
	private List<Integer> anios;
	private String parametros;
	private List<ActFormulario> formulariosInstitucion = new ArrayList<ActFormulario>();
	private PdfGeneratorUtils generadorPdf = new PdfGeneratorUtils();
	private List<ActItemCatalogo> itemsCatalogo;
	
	private List<ActTalentoHumano> talentoHumano = new ArrayList<ActTalentoHumano>();
	private List<ActCuartoServidore> cuartoServidores = new ArrayList<ActCuartoServidore>();
	private List<ActLaboratorioSala> laboratoriosSala = new ArrayList<ActLaboratorioSala>();
	private List<ActLaboratorioSala> laboratoriosTI = new ArrayList<ActLaboratorioSala>();
	private List<ActLaboratorioSala> laboratoriosEspeciales = new ArrayList<ActLaboratorioSala>();
	private List<ActLaboratorioSala> salasClases = new ArrayList<ActLaboratorioSala>();
	private List<ActLaboratorioSala> areaAdministrativa = new ArrayList<ActLaboratorioSala>();
	private List<ActLaboratorioSala> biblioteca = new ArrayList<ActLaboratorioSala>();
	private List<ActAccesibilidadServicio> accesibilidad = new ArrayList<ActAccesibilidadServicio>();
	private List<ActConectividad> conectividad = new ArrayList<ActConectividad>();
	

	@PostConstruct
	public void init() {
		verificacionAcceso(sessionController.getUserSecurity().getUsername(), "impresionFormulario.xhtml");
		username = sessionController.getUserSecurity().getUsername();
		insInstitucion = institucionService.obtenerPorAmie(username);
		verFormulario = Boolean.TRUE;
		mensajeInstitucionError = "";
		if (insInstitucion == null) {
			verFormulario = Boolean.FALSE;
			mensajeInstitucionError = "El usuario que ha iniciado sesión no es una institución educativa.";
		} else {
			formulariosInstitucion = formularioService.listadoPorAmie(insInstitucion.getAmie());
			itemsCatalogo = itemCatalogoService.listarTodos();
			anioSeleccionado = null;
			cargarAnios();
			parametros = "";
			anioSeleccionado = (anios == null || anios.isEmpty()) ? 0 : anios.get(0);
			cargarParametros();
		}
	}
	
	/**
	 * Método que crea una cadena que envía los parámetros para el reporte
	 */
	public void cargarParametros() {
		parametros = "&anio=" + anioSeleccionado + "&amie=" + username;
	}
	
	/**
	 * Método que obtiene los años de formularios cargados que pueden
	 * visualizarse en el reporte
	 */
	private void cargarAnios() {
		anios = formularioService.obtenerAniosFormularioPorAmie(username);
	}
	
	public void generarReporte(ActFormulario formulario){
		errorImpresion = false;
		try {
			cargarInformacion(formulario);
			String texto = FormReportGenerator.generarReporte(formulario, itemsCatalogo, talentoHumano, cuartoServidores, laboratoriosTI, laboratoriosEspeciales, salasClases, biblioteca, areaAdministrativa, accesibilidad, conectividad, insInstitucion);
			generadorPdf.generateDocumentItextBrowser(texto, formulario.getAmie());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			errorImpresion = true;
		}
	}
	
	private void cargarInformacion(ActFormulario formulario){
		int disponibilidad = 1;
		talentoHumano = talentoHumanoService.listaTalentoHumanoPorFormulario(formulario);
		cuartoServidores = cuartoServidoreService.listaCuartoServidoresPorFormularioYDisponibilidad(formulario, disponibilidad);
		laboratoriosSala = salaLaboratorioService.obtenerPorFormulario(formulario);
		clasificarLaboratoriosSalas();
		accesibilidad = accesibilidadServicioService.listaAccesibilidadPorFormularioYDisponibilidad(formulario, disponibilidad);
		conectividad = conectividadService.listaConectividadPorFormularioYDisponibilidad(formulario, disponibilidad);
	}

	private void clasificarLaboratoriosSalas(){
		laboratoriosTI= new ArrayList<ActLaboratorioSala>(); 
		laboratoriosEspeciales= new ArrayList<ActLaboratorioSala>(); 
		biblioteca= new ArrayList<ActLaboratorioSala>(); 
		areaAdministrativa = new ArrayList<ActLaboratorioSala>();
		salasClases = new ArrayList<ActLaboratorioSala>();
		
		for (ActLaboratorioSala laboratorio : laboratoriosSala) {
			if(laboratorio.getCodigoTipo() == Constantes.CODIGO_ITEM_CATALOGO_LABORATORIOS_TI && !Utils.esLaboratorioVacio(laboratorio)){
				laboratoriosTI.add(laboratorio);
			}else if (laboratorio.getCodigoTipo() == Constantes.CODIGO_ITEM_CATALOGO_BIBLIOTECA && !Utils.esLaboratorioVacio(laboratorio)) {
				biblioteca.add(laboratorio);
			}else if (laboratorio.getCodigoTipo() == Constantes.CODIGO_ITEM_CATALOGO_AREA_ADMINISTRATIVA && !Utils.esLaboratorioVacio(laboratorio)) {
				areaAdministrativa.add(laboratorio);
			}else if (laboratorio.getCodigoTipo() >= Constantes.CODIGO_LIMITES_ITEM_CATALOGO_LABORATORIOS_ESPECIALES[0] && laboratorio.getCodigoTipo() <= Constantes.CODIGO_LIMITES_ITEM_CATALOGO_LABORATORIOS_ESPECIALES[1] && !Utils.esLaboratorioVacio(laboratorio)) {
				laboratoriosTI.add(laboratorio);
			}else if (laboratorio.getCodigoTipo() >= Constantes.CODIGO_LIMITES_ITEM_CATALOGO_SALAS_CLASES[0] && laboratorio.getCodigoTipo() <= Constantes.CODIGO_LIMITES_ITEM_CATALOGO_SALAS_CLASES[1] && !Utils.esLaboratorioVacio(laboratorio)) {
				salasClases.add(laboratorio);
			}
		}
	}
	
	
	
	public boolean isVerFormulario() {
		return verFormulario;
	}

	public void setVerFormulario(boolean verFormulario) {
		this.verFormulario = verFormulario;
	}

	public String getMensajeInstitucionError() {
		return mensajeInstitucionError;
	}

	public void setMensajeInstitucionError(String mensajeInstitucionError) {
		this.mensajeInstitucionError = mensajeInstitucionError;
	}

	public Integer getAnioSeleccionado() {
		return anioSeleccionado;
	}

	public void setAnioSeleccionado(Integer anioSeleccionado) {
		this.anioSeleccionado = anioSeleccionado;
	}

	public List<Integer> getAnios() {
		return anios;
	}

	public void setAnios(List<Integer> anios) {
		this.anios = anios;
	}

	public String getParametros() {
		return parametros;
	}

	public void setParametros(String parametros) {
		this.parametros = parametros;
	}

	public List<ActFormulario> getFormulariosInstitucion() {
		return formulariosInstitucion;
	}

	public void setFormulariosInstitucion(List<ActFormulario> formulariosInstitucion) {
		this.formulariosInstitucion = formulariosInstitucion;
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

	public boolean isErrorImpresion() {
		return errorImpresion;
	}

	public void setErrorImpresion(boolean errorImpresion) {
		this.errorImpresion = errorImpresion;
	}
	
}
