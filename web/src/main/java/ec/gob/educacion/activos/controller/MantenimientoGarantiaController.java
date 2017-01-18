package ec.gob.educacion.activos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import ec.gob.educacion.acceso.scope.ViewScoped;
import ec.gob.educacion.activos.enumerator.EstadoEnum;
import ec.gob.educacion.activos.enumerator.LaboratorioSalaEnum;
import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.model.ActDetalleActivo;
import ec.gob.educacion.activos.model.ActDetalleGarantia;
import ec.gob.educacion.activos.model.ActDetalleMantenimiento;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.asignacion.InsInstitucion;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.activos.service.DetalleActivoService;
import ec.gob.educacion.activos.service.GarantiaService;
import ec.gob.educacion.activos.service.InstitucionService;
import ec.gob.educacion.activos.service.ItemCatalogoService;
import ec.gob.educacion.activos.service.MantenimientoService;

@Named
@ViewScoped
public class MantenimientoGarantiaController extends BaseController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private InstitucionService institucionService;
	
	@EJB
	private DetalleActivoService detalleActivoService;
	
	@EJB
	private GarantiaService garantiaService;
	
	@EJB
	private MantenimientoService mantenimientoService;
	
	@EJB
	private ItemCatalogoService itemCatalogoService;
	
	@Inject
	private SessionController sessionController;

	private ActDetalleActivo detalleActivo;
	private List<ActDetalleActivo> listaDetalleActivo;
	private ActDetalleGarantia garantia;
	private List<ActDetalleGarantia> listaGarantia;
	private ActDetalleMantenimiento mantenimiento;
	private List<ActDetalleMantenimiento> listaMantenimiento;
	private List<ActItemCatalogo> listaTipoDuracion;
	private String serial;
	private boolean existeSerial;
	private boolean nuevoMantenimiento;
	private boolean nuevaGarantia;
	
	private InsInstitucion insInstitucion;
	private boolean esUsuarioInstitucion;

	@PostConstruct
	public void init() {
		verificacionAcceso(sessionController.getUserSecurity().getUsername(), "mantenimientoGarantia.xhtml");
		insInstitucion = institucionService.obtenerPorAmie(sessionController.getUserSecurity().getUsername());
		if(insInstitucion != null){
			esUsuarioInstitucion = true;
			serial="";
			detalleActivo=new ActDetalleActivo();
			garantia=new ActDetalleGarantia();
			mantenimiento=new ActDetalleMantenimiento();
			listaGarantia=new ArrayList<ActDetalleGarantia>();
			listaMantenimiento=new ArrayList<ActDetalleMantenimiento>();
			listaTipoDuracion=itemCatalogoService.listarPorNemonicoCatalogo(Constantes.TIPO_DURACION);
		}else {
			esUsuarioInstitucion = false;
		}
	}
	
	public void buscarActivo(){
		listaDetalleActivo=detalleActivoService.listarPorSerial(serial,sessionController.getUserSecurity().getUsername(),EstadoEnum.ACTIVO.getCodigo(),Calendar.getInstance().get(Calendar.YEAR),EstadoEnum.ACTIVO.getCodigo());
		for (ActDetalleActivo item : listaDetalleActivo) {
			item.setDescripcionTipoActivo(itemCatalogoService.buscarPorCodigo(item.getCodigoTipo()).getDescripcion());			
		}
		if (listaDetalleActivo == null || listaDetalleActivo.isEmpty()) {
			agregarMensajeError("El activo no se encuentra ingresado o está dado de baja.", "El activo no se encuentra ingresado o está dado de baja.");
		}
	}
	
	public void tomarActivo(ActDetalleActivo detalle){
		detalleActivo=detalle;
		detalleActivo.setDescripcionTipoActivo(itemCatalogoService.buscarPorCodigo(detalleActivo.getCodigoTipo()).getDescripcion());
		listaGarantia=garantiaService.listarGarantiasActivo(detalleActivo.getCodigo());		
		listaMantenimiento=mantenimientoService.listarMantenimientosActivo(detalleActivo.getCodigo());
	}
	
	public void nuevoMantenimiento(){
		nuevoMantenimiento=true;
		mantenimiento=new ActDetalleMantenimiento();
	}
	
	public void nuevaGarantia(){
		nuevaGarantia=true;
		garantia=new ActDetalleGarantia(); 
	}
	
	
	public void guardarMantenimiento(){
		if(nuevoMantenimiento){
			mantenimiento.setActDetalleActivo(detalleActivo);
			try {
				mantenimientoService.guardar(mantenimiento);
			} catch (DetalleActivoException e) {
				e.printStackTrace();
			}
		}else{
			try {
				mantenimientoService.actualizar(mantenimiento);
			} catch (DetalleActivoException e) {
				e.printStackTrace();
			}
		}
		listaMantenimiento=mantenimientoService.listarMantenimientosActivo(detalleActivo.getCodigo());
		mantenimiento=new ActDetalleMantenimiento();
	}
	
	public void guardarGarantia(){
		if(nuevaGarantia){
			garantia.setActDetalleActivo(detalleActivo);
			try {
				garantiaService.guardar(garantia);
			} catch (DetalleActivoException e) {
				e.printStackTrace();
			}
		}else{
			try {
				garantiaService.actualizar(garantia);
			} catch (DetalleActivoException e) {
				e.printStackTrace();
			}
		}
		listaGarantia=garantiaService.listarGarantiasActivo(detalleActivo.getCodigo());
		garantia=new ActDetalleGarantia();
	}
	
	public void tomarMantenimiento(ActDetalleMantenimiento mantenimiento){
		this.mantenimiento=new ActDetalleMantenimiento();
		this.mantenimiento=mantenimiento;
		nuevoMantenimiento=false;
	}
	
	public void tomarGarantia(ActDetalleGarantia garantia){
		this.garantia=new ActDetalleGarantia();
		this.garantia=garantia;
		nuevaGarantia=false;
	}
	
	public void limpiarValores(){
		mantenimiento=new ActDetalleMantenimiento();
		garantia=new ActDetalleGarantia();
	}
	
	public String buscarDescripcionDuracion(long codigoDuracion) {
		ActItemCatalogo obtenerCodigoGarantia = itemCatalogoService.buscarPorCodigo(codigoDuracion);		
		return obtenerCodigoGarantia == null ? "" : obtenerCodigoGarantia.getDescripcion();
	}
	
	/**
	 * Método que corta la cadena a un máximo de 20 caracteres en caso de que
	 * sobrepase dicha longitud
	 * 
	 * @param cadena
	 * @param limite
	 * @return Objeto de tipo String
	 */
	public String obtenerCadenaCortada(String cadena, int limite) {
		String cadenaCortada = "";
		if (cadena.trim().contains(" ")) {
			cadenaCortada = cadena;
		} else {
			cadenaCortada = cortarCadena(cadena, limite);
		}
		return cadenaCortada;
	}
	
	/**
	 * Metodo que obtiene la descripción del laboratorio el id de sala por descripcion
	 */
	public String obtenerDescripcion(long codigoTipo) {
		String nombreTipo = "";
		if ((codigoTipo >= LaboratorioSalaEnum.LABORATORIO_INGLES.getCodigo()
				&& codigoTipo <= LaboratorioSalaEnum.LABORATORIO_QUIMICA.getCodigo())) {
			nombreTipo = "Laboratorio ";
		} else if (codigoTipo >= LaboratorioSalaEnum.SALA_INICIAL.getCodigo()
				&& codigoTipo <= LaboratorioSalaEnum.SALA_TERCERO_BCH.getCodigo()) {
			nombreTipo = "Sala de clase ";
		} else if (LaboratorioSalaEnum.LABORATORIO_TI.getCodigo() == codigoTipo) {
			nombreTipo = "Laboratorio TI ";
		}
		return nombreTipo;
	}
	
	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public ActDetalleActivo getDetalleActivo() {
		return detalleActivo;
	}

	public void setDetalleActivo(ActDetalleActivo detalleActivo) {
		this.detalleActivo = detalleActivo;
	}

	public boolean isExisteSerial() {
		return existeSerial;
	}

	public void setExisteSerial(boolean existeSerial) {
		this.existeSerial = existeSerial;
	}

	public List<ActDetalleActivo> getListaDetalleActivo() {
		return listaDetalleActivo;
	}

	public void setListaDetalleActivo(List<ActDetalleActivo> listaDetalleActivo) {
		this.listaDetalleActivo = listaDetalleActivo;
	}

	public ActDetalleGarantia getGarantia() {
		return garantia;
	}

	public void setGarantia(ActDetalleGarantia garantia) {
		this.garantia = garantia;
	}

	public List<ActDetalleGarantia> getListaGarantia() {
		return listaGarantia;
	}

	public void setListaGarantia(List<ActDetalleGarantia> listaGarantia) {
		this.listaGarantia = listaGarantia;
	}

	public ActDetalleMantenimiento getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(ActDetalleMantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public List<ActDetalleMantenimiento> getListaMantenimiento() {
		return listaMantenimiento;
	}

	public void setListaMantenimiento(List<ActDetalleMantenimiento> listaMantenimiento) {
		this.listaMantenimiento = listaMantenimiento;
	}

	public List<ActItemCatalogo> getListaTipoDuracion() {
		return listaTipoDuracion;
	}

	public void setListaTipoDuracion(List<ActItemCatalogo> listaTipoDuracion) {
		this.listaTipoDuracion = listaTipoDuracion;
	}

	public boolean getEsUsuarioInstitucion() {
		return esUsuarioInstitucion;
	}

	public void setEsUsuarioInstitucion(boolean esUsuarioInstitucion) {
		this.esUsuarioInstitucion = esUsuarioInstitucion;
	}
}