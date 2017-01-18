package ec.gob.educacion.activos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import ec.gob.educacion.acceso.dto.EstadoDTO;
import ec.gob.educacion.acceso.dto.TipoBusquedaDTO;
import ec.gob.educacion.acceso.scope.ViewScoped;
import ec.gob.educacion.activos.enumerator.EstadoEnum;
import ec.gob.educacion.activos.enumerator.TipoBusquedaEnum;
import ec.gob.educacion.activos.exception.ResponsableException;
import ec.gob.educacion.activos.model.ActResponsable;
import ec.gob.educacion.activos.model.asignacion.InsDistrito;
import ec.gob.educacion.activos.model.asignacion.InsInstitucion;
import ec.gob.educacion.activos.service.DetalleActivoService;
import ec.gob.educacion.activos.service.DistritoService;
import ec.gob.educacion.activos.service.InstitucionService;
import ec.gob.educacion.activos.service.ResponsableService;

@Named
@ViewScoped
public class ResponsableController extends BaseController implements Serializable {

	private static final long serialVersionUID = -7067833779093082280L;
	
	@EJB
	private ResponsableService responsableService;
	@EJB
	private InstitucionService institucionService;
	@EJB
	private DetalleActivoService detalleActivoService;
	@EJB
	private DistritoService distritoService;
	
	@Inject
	private SessionController sessionController;
	@Inject
	private SessionResponsableController sessionResponsableController;
	
	private List<TipoBusquedaDTO> tiposBusqueda;
	private List<ActResponsable> responsables;
	private ActResponsable responsable;
	private InsInstitucion institucion;
	private InsDistrito distrito;

	private String username;
	private int busquedaSeleccionada;
	private String descripcionBusqueda;
	private boolean deshabilitarEstados;
	private String mensajeResponsables;
	private String amie;
	private String identificacion;
	private boolean esDistrito;
	private String mensajeDistritoError;

	@PostConstruct
	public void init() {
		verificacionAcceso(sessionController.getUserSecurity().getUsername(), "responsable.xhtml");
		username = sessionController.getUserSecurity().getUsername();
		distrito = distritoService.obtenerPorCodigoSenplades(username);
		mensajeDistritoError = "";
		if (distrito == null) {
			esDistrito = Boolean.FALSE;
			mensajeDistritoError = "El usuario que ha iniciado sesión no es un distrito.";
		} else {
			esDistrito = Boolean.TRUE;
			cargarTiposBusqueda();
			busquedaSeleccionada = TipoBusquedaEnum.IDENTIFICACION.getCodigo();
		}
	}
	
	/**
	 * Método que permite inicializar la búsqueda según el parámetro seleccionado
	 */
	public void configurarTipoBusqueda() {
		descripcionBusqueda = "";
	}
	
	/**
	 * Método que busca los registros de responsable según los parámetros de búsqueda
	 */
	public void buscar() {
		responsables = new ArrayList<ActResponsable>();
		if (TipoBusquedaEnum.IDENTIFICACION.getCodigo() == busquedaSeleccionada) {
			responsables = responsableService.obtenerPorIdentificacion(descripcionBusqueda, username);
		} else if (TipoBusquedaEnum.RESPONSABLE_NOMBRE.getCodigo() == busquedaSeleccionada) {
			responsables = responsableService.obtenerPorNombre(descripcionBusqueda, username);
		} else if (TipoBusquedaEnum.SERIAL_ACTIVO.getCodigo() == busquedaSeleccionada) {
			responsables = responsableService.obtenerPorSerial(descripcionBusqueda, username);
		}
		
		if (responsables == null || responsables.isEmpty()) {
			if(TipoBusquedaEnum.SERIAL_ACTIVO.getCodigo() == busquedaSeleccionada){
				agregarMensajeError(" El activo ingresado no existe o no está asignado a un responsable. Si desea asignar el activo, busque al responsable al cual le asignará el mismo y realice una Nueva Asignación.",
						" El activo ingresado no existe o no está asignado a un responsable. Si desea asignar el activo, busque al responsable al cual le asignará el mismo y realice una Nueva Asignación.");
			}else{
			agregarMensajeError(
					"No existen resultados con la descripción ingresada, o, los registros encontrados pertenecen a instituciones educativas que no se encuentran en el distrito.",
					"No existen resultados con la descripción ingresada, o, los registros encontrados pertenecen a instituciones educativas que no se encuentran en el distrito.");
		}
		}
	}
	
	/**
	 * Método que inicializa la creación un objeto ActResponsable
	 */
	public void crearResponsable() {
		responsable = new ActResponsable();
		responsable.setEstado(EstadoEnum.ACTIVO.getCodigo());
		amie = "";
		identificacion = "";
		deshabilitarEstados = Boolean.TRUE;
		mensajeResponsables = "";
	}
	
	/**
	 * Método que inicializa la edición un objeto ActResponsable
	 * 
	 * @param otherActResponsable
	 */
	public void editarResponsable(ActResponsable otherActResponsable) {
		responsable = otherActResponsable;
		institucion = institucionService.obtenerPorCodigo(otherActResponsable.getCodigoInstitucion());
		amie = institucion.getAmie();
		identificacion = otherActResponsable.getIdentificacion();
		deshabilitarEstados = detalleActivoService.contarPorResponsableEstado(otherActResponsable, EstadoEnum.ACTIVO.getCodigo()) > 0;
		mensajeResponsables = "";
	}
	
	/**
	 * Método que guarda un objeto de tipo ActResponsable
	 */
	public void guardarResponsable() {
		mensajeResponsables = "";
		institucion = institucionService.obtenerPorAmieConDistrito(amie);
		if (institucion == null) {
			mensajeResponsables = "No existe Institución Educativa con el código AMIE especificado.";
		} else {
			if (institucion.getInsCirPar().getInsCircuito().getInsDistrito().getCodigoSenplades().equals(username)) {
				responsable.setCodigoInstitucion(institucion.getCodigo());
				try {
					StringBuilder mensaje = new StringBuilder().append("Operación realizada exitosamente. ");
					if (responsable.getCodigo() == 0) {
						if (verificarIdentificacion(identificacion)) {
							mensajeResponsables = "La identificación ingresada ya existe.";
						} else {
							responsable.setIdentificacion(identificacion);
							responsableService.guardar(responsable);
							mensaje.append("Para visualizar el registro ingresado debe realizar una búsqueda.");
						}
					} else {
						if (!responsable.getIdentificacion().equalsIgnoreCase(identificacion) & verificarIdentificacion(identificacion)) {
							mensajeResponsables = "La identificación ingresada ya existe.";
						} else {
							responsable.setIdentificacion(identificacion);
							responsableService.actualizar(responsable);
						}
					}
					agregarMensajeInformacion(mensaje.toString(), mensaje.toString());
				} catch (ResponsableException e) {
					agregarMensajeError(
							"Fallo en la operación, comuníquese con el administrador para una posible solución.",
							"Fallo en la operación, comuníquese con el administrador para una posible solución.");
				}
			} else {
				mensajeResponsables = "La Institución Educativa correspondiente al código AMIE no pertenece al distrito.";
			}
		}
	}
	
	/**
	 * Método que redirecciona a la página para asignación/desasignación de
	 * responsables con respecto a un activo
	 * 
	 * @param otherActResponsable
	 */
	public void ingresarAsignacion(ActResponsable otherActResponsable) {
		institucion = institucionService.obtenerPorCodigo(otherActResponsable.getCodigoInstitucion());
		sessionResponsableController.setUsername(username);
		sessionResponsableController.setResponsable(otherActResponsable);
		sessionResponsableController.setInstitucion(institucion);
		redireccionarPagina("/faces/paginas/asignacionResponsable.xhtml");
	}
	
	/**
	 * Método que obtiene el nombre de la institución educativa a la que
	 * pertenece el responsable
	 * 
	 * @param codigoInstitucion
	 * @return Objeto de tipo String
	 */
	public String buscarNombreInstitucion(long codigoInstitucion) {
		InsInstitucion otherInsInstitucion = institucionService.obtenerPorCodigo(codigoInstitucion);
		return otherInsInstitucion == null ? "" : otherInsInstitucion.getDescripcion();
	}
	
	/**
	 * Método que carga un listado de estados
	 * 
	 * @return Lista de objetos de tipo EstadoDTO
	 */
	public List<EstadoDTO> obtenerEstados() {
		List<EstadoDTO> estados = new ArrayList<EstadoDTO>();
		estados.add(new EstadoDTO(EstadoEnum.ACTIVO.getCodigo(), EstadoEnum.ACTIVO.getDescripcion()));
		estados.add(new EstadoDTO(EstadoEnum.INACTIVO.getCodigo(), EstadoEnum.INACTIVO.getDescripcion()));
		return estados;
	}
	
	/**
	 * Método que verifica si existe un responsable con la identificación
	 * ingresada en su creación/edición
	 * 
	 * @param identificacion
	 * @return Verdadero o falso según determinada condición
	 */
	private boolean verificarIdentificacion(String identificacion) {
		return responsableService.verificarExistenciaResponsable(identificacion);
	}
	
	/**
	 * Método que carga los tipos de búsqueda requeridos para manejo de responsables
	 */
	private void cargarTiposBusqueda() {
		tiposBusqueda = new ArrayList<TipoBusquedaDTO>();
		tiposBusqueda.add(new TipoBusquedaDTO(TipoBusquedaEnum.IDENTIFICACION.getCodigo(), TipoBusquedaEnum.IDENTIFICACION.getDescripcion()));
		tiposBusqueda.add(new TipoBusquedaDTO(TipoBusquedaEnum.RESPONSABLE_NOMBRE.getCodigo(), TipoBusquedaEnum.RESPONSABLE_NOMBRE.getDescripcion()));
		tiposBusqueda.add(new TipoBusquedaDTO(TipoBusquedaEnum.SERIAL_ACTIVO.getCodigo(), TipoBusquedaEnum.SERIAL_ACTIVO.getDescripcion()));
	}

	public List<TipoBusquedaDTO> getTiposBusqueda() {
		return tiposBusqueda;
	}

	public void setTiposBusqueda(List<TipoBusquedaDTO> tiposBusqueda) {
		this.tiposBusqueda = tiposBusqueda;
	}

	public int getBusquedaSeleccionada() {
		return busquedaSeleccionada;
	}

	public void setBusquedaSeleccionada(int busquedaSeleccionada) {
		this.busquedaSeleccionada = busquedaSeleccionada;
	}

	public String getDescripcionBusqueda() {
		return descripcionBusqueda;
	}

	public void setDescripcionBusqueda(String descripcionBusqueda) {
		this.descripcionBusqueda = descripcionBusqueda;
	}

	public List<ActResponsable> getResponsables() {
		return responsables;
	}

	public void setResponsables(List<ActResponsable> responsables) {
		this.responsables = responsables;
	}

	public ActResponsable getResponsable() {
		return responsable;
	}

	public void setResponsable(ActResponsable responsable) {
		this.responsable = responsable;
	}

	public InsInstitucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InsInstitucion institucion) {
		this.institucion = institucion;
	}

	public boolean isDeshabilitarEstados() {
		return deshabilitarEstados;
	}

	public void setDeshabilitarEstados(boolean deshabilitarEstados) {
		this.deshabilitarEstados = deshabilitarEstados;
	}

	public String getMensajeResponsables() {
		return mensajeResponsables;
	}

	public void setMensajeResponsables(String mensajeResponsables) {
		this.mensajeResponsables = mensajeResponsables;
	}

	public String getAmie() {
		return amie;
	}

	public void setAmie(String amie) {
		this.amie = amie;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public boolean isEsDistrito() {
		return esDistrito;
	}

	public void setEsDistrito(boolean esDistrito) {
		this.esDistrito = esDistrito;
	}

	public String getMensajeDistritoError() {
		return mensajeDistritoError;
	}

	public void setMensajeDistritoError(String mensajeDistritoError) {
		this.mensajeDistritoError = mensajeDistritoError;
	}
	
}
