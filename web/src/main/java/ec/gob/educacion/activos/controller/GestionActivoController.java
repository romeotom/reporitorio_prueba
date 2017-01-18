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

import ec.gob.educacion.acceso.scope.ViewScoped;
import ec.gob.educacion.activos.enumerator.DetalleActivoEnum;
import ec.gob.educacion.activos.enumerator.EstadoEnum;
import ec.gob.educacion.activos.enumerator.LaboratorioSalaEnum;
import ec.gob.educacion.activos.enumerator.OrigenActivoEnum;
import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.exception.SalaLaboratorioException;
import ec.gob.educacion.activos.model.ActDetalleActivo;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.ActLaboratorioSala;
import ec.gob.educacion.activos.model.asignacion.InsInstitucion;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.activos.service.DetalleActivoService;
import ec.gob.educacion.activos.service.FormularioService;
import ec.gob.educacion.activos.service.InstitucionService;
import ec.gob.educacion.activos.service.ItemCatalogoService;
import ec.gob.educacion.activos.service.SalaLaboratorioService;

@Named
@ViewScoped
public class GestionActivoController extends BaseController implements Serializable {

	private static final long serialVersionUID = -7067833779093082280L;
	
	@EJB
	private InstitucionService institucionService;
	@EJB
	private FormularioService formularioService;
	@EJB
	private SalaLaboratorioService salaLaboratorioService;
	@EJB
	private DetalleActivoService detalleActivoService;
	@EJB
	private ItemCatalogoService itemCatalogoService;
	
	@Inject
	private SessionController sessionController;
	
	private InsInstitucion insInstitucion;
	private ActFormulario actFormulario;
	private ActDetalleActivo actDetalleActivo;
	private List<ActItemCatalogo> tipoActivos;
	private List<ActLaboratorioSala> laboratorioSalas;
	private ActLaboratorioSala laboratorioSala;
	private ActLaboratorioSala otherLaboratorioSala;
	private List<ActItemCatalogo> tipoLaboratorios;

	private String username;
	private boolean verFormulario;
	private String mensajeInstitucionError;
	private int anio;
	private long labSalaSeleccionado;
	private long tipoActivoSeleccionado;
	private long tipoLaboratorioSeleccionado;
	private List<String> nombres;
	private String nombreSeleccionado;

	@PostConstruct
	public void init() {
		verificacionAcceso(sessionController.getUserSecurity().getUsername(), "gestionActivo.xhtml");
		username = sessionController.getUserSecurity().getUsername();
		//insInstitucion = institucionService.obtenerPorAmie(username);
		insInstitucion = new InsInstitucion();
		insInstitucion.setAmie("18H00137");
		insInstitucion.setCodigo(53687);
		
		verFormulario = Boolean.TRUE;
		mensajeInstitucionError = "";
		if (insInstitucion == null) {
			verFormulario = Boolean.FALSE;
			mensajeInstitucionError = "El usuario que ha iniciado sesión no es una Institución Educativa.";
		} else {
			anio = Calendar.getInstance().get(Calendar.YEAR);
			actFormulario = formularioService
					.obtenerPorInstitucionAnioTipoEstado(username, anio, null, EstadoEnum.ACTIVO.getCodigo());
			if (actFormulario == null) {
				verFormulario = Boolean.FALSE;
				mensajeInstitucionError = "No existe formulario cargado para la Institución Educativa que permita la gestión de activos.";
			} else {
				crearActivo();
			}
		}
	}
	
	/**
	 * Método que permite inicializar la creación de un activo
	 */
	public void crearActivo() {
		cargarLaboratorioSalas();
		actDetalleActivo = new ActDetalleActivo();
		actDetalleActivo.setEstado(EstadoEnum.ACTIVO.getCodigo());
		labSalaSeleccionado = -1;
		tipoActivoSeleccionado = 0;
		tipoActivos = null;
	}
	
	/**
	 * Método que guarda un activo
	 */
	public void guardarActivo() {
		try {
			if (validarSerial(actDetalleActivo.getSerial())) {
				actDetalleActivo.setFechaCreacion(new Date());
				actDetalleActivo.setTipoCreacion(OrigenActivoEnum.ONLINE.getCodigo());
				actDetalleActivo.setCodigoTipo(tipoActivoSeleccionado);
				actDetalleActivo.setActLaboratorioSala(otherLaboratorioSala);
				detalleActivoService.guardar(actDetalleActivo);
				crearActivo();
				agregarMensajeInformacion("Operación realizada exitosamente.", "Operación realizada exitosamente.");
			} else {
				agregarMensajeError(
						"El serial ya se encuentra asignado a un activo.",
						"El serial ya se encuentra asignado a un activo.");
			}
		} catch (DetalleActivoException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que permite cargar el listado de tipos de activos para su creación
	 */
	public void cargarTipoActivos() {
		tipoActivos = new ArrayList<ActItemCatalogo>();
		otherLaboratorioSala = salaLaboratorioService.obtenerPorId(labSalaSeleccionado);
		if (LaboratorioSalaEnum.BIBLIOTECA.getCodigo() == otherLaboratorioSala.getCodigoTipo()
				|| LaboratorioSalaEnum.AREA_ADMINISTRATIVA.getCodigo() == otherLaboratorioSala.getCodigoTipo()) {
			tipoActivos.add(itemCatalogoService.buscarPorCodigo(DetalleActivoEnum.COMPUTADORA.getCodigo()));
		} else {
			tipoActivos = itemCatalogoService.listarPorNemonicoCatalogo(Constantes.TIPO_ACTIVO);
		}
	}
	
	/**
	 * Método que obtiene el nombre de laboratorio/sala
	 * 
	 * @param codigoTipo
	 * @return Objeto de tipo String
	 */
	public String obtenerNombreLaboratorioSala(long codigoTipo) {
		String nombre = "";
		if (codigoTipo >= LaboratorioSalaEnum.LABORATORIO_INGLES.getCodigo()
				&& codigoTipo <= LaboratorioSalaEnum.LABORATORIO_QUIMICA.getCodigo()) {
			nombre = "Laboratorio ";
		} else if (codigoTipo >= LaboratorioSalaEnum.SALA_INICIAL.getCodigo()
				&& codigoTipo <= LaboratorioSalaEnum.SALA_TERCERO_BCH.getCodigo()) {
			nombre = "Sala de clase ";
		} else if (LaboratorioSalaEnum.LABORATORIO_TI.getCodigo() == codigoTipo) {
			nombre = "Laboratorio TI ";
		}
		return nombre;
	}
	
	/**
	 * Método que permite inicializar la creación de un laboratorio/sala
	 */
	public void crearActLaboratorioSala() {
		laboratorioSala = new ActLaboratorioSala();
		laboratorioSala.setComputadoras(0);
		laboratorioSala.setImplLaboratorios(null);
		laboratorioSala.setImpresoras(0);
		laboratorioSala.setPizarraInteractiva(0);
		laboratorioSala.setProyectores(0);
		laboratorioSala.setSistemaAudio(0);
		laboratorioSala.setActFormulario(actFormulario);
		tipoLaboratorioSeleccionado = -1;
		nombreSeleccionado = "";
		nombres = null;
		cargarCatalogoLaboratorioSalas();
	}
	
	/**
	 * Método que permite crear las cabeceras de detalles de activos
	 */
	public void guardarActLaboratorioSala() {
		try {
			ActItemCatalogo tipoLaboratorioSala = itemCatalogoService.buscarPorCodigo(tipoLaboratorioSeleccionado);
			laboratorioSala.setCodigoTipo(tipoLaboratorioSala.getCodigo());
			String nombreTipo = LaboratorioSalaEnum.LABORATORIO_TI.getCodigo() == tipoLaboratorioSeleccionado ? nombreSeleccionado : tipoLaboratorioSala.getDescripcion();
			laboratorioSala.setNombreTipo(nombreTipo);
			laboratorioSala.setFechaCreacion(new Date());
			laboratorioSala.setTipoCreacion(OrigenActivoEnum.ONLINE.getCodigo());
			salaLaboratorioService.guardar(laboratorioSala);
			crearActivo();
			agregarMensajeInformacion("Operación realizada exitosamente.", "Operación realizada exitosamente.");
		} catch (SalaLaboratorioException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Mëtodo que seleccione el nombre del tipo requerido para laboratorios de TI
	 */
	public void seleccionarTipoLabSalas() {
		nombres = new ArrayList<String>();
		if (LaboratorioSalaEnum.LABORATORIO_TI.getCodigo() == tipoLaboratorioSeleccionado) {
			String nombre = salaLaboratorioService.obtenerUltimoPorFormularioTipo(actFormulario, tipoLaboratorioSeleccionado);
			if (nombre == null) {
				nombre = "0";
			} else {
				nombre = String.valueOf(Integer.valueOf(nombre) + 1);
			}
			nombres.add(nombre);
		}
	}
	
	/**
	 * Método que permite crear el listado de tipos de laboratorios y salas que tiene el formulario
	 */
	private void cargarLaboratorioSalas() {
		laboratorioSalas = salaLaboratorioService.obtenerPorFormulario(actFormulario);
	}
	
	/**
	 * Método que permite crear el listado de tipos de laboratorios y salas
	 */
	private void cargarCatalogoLaboratorioSalas() {
		tipoLaboratorios = salaLaboratorioService.obtenerPorLaboratorioSala(actFormulario, Boolean.FALSE);
		boolean tieneTi = Boolean.FALSE;
		for (ActItemCatalogo tipoLaboratorio : tipoLaboratorios) {
			if (LaboratorioSalaEnum.LABORATORIO_TI.getCodigo() == tipoLaboratorio.getCodigo()) {
				tieneTi = Boolean.TRUE;
				break;
			}
		}
		if (!tieneTi) {
			tipoLaboratorios.add(itemCatalogoService.buscarPorCodigo(LaboratorioSalaEnum.LABORATORIO_TI.getCodigo()));
		}
	}
	
	/**
	 * Método que verifica si el serial ya existe
	 * 
	 * @param serial
	 * @return Verdadero o falso según la condición
	 */
	private boolean validarSerial(String serial) {
		ActDetalleActivo otherActDetalleActivo = detalleActivoService.buscarPorSerial(serial);
		return otherActDetalleActivo == null;
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

	public List<ActItemCatalogo> getTipoActivos() {
		return tipoActivos;
	}

	public void setTipoActivos(List<ActItemCatalogo> tipoActivos) {
		this.tipoActivos = tipoActivos;
	}

	public long getLabSalaSeleccionado() {
		return labSalaSeleccionado;
	}

	public void setLabSalaSeleccionado(long labSalaSeleccionado) {
		this.labSalaSeleccionado = labSalaSeleccionado;
	}

	public long getTipoActivoSeleccionado() {
		return tipoActivoSeleccionado;
	}

	public void setTipoActivoSeleccionado(long tipoActivoSeleccionado) {
		this.tipoActivoSeleccionado = tipoActivoSeleccionado;
	}

	public ActDetalleActivo getActDetalleActivo() {
		return actDetalleActivo;
	}

	public void setActDetalleActivo(ActDetalleActivo actDetalleActivo) {
		this.actDetalleActivo = actDetalleActivo;
	}

	public List<ActLaboratorioSala> getLaboratorioSalas() {
		return laboratorioSalas;
	}

	public void setLaboratorioSalas(List<ActLaboratorioSala> laboratorioSalas) {
		this.laboratorioSalas = laboratorioSalas;
	}

	public ActLaboratorioSala getLaboratorioSala() {
		return laboratorioSala;
	}

	public void setLaboratorioSala(ActLaboratorioSala laboratorioSala) {
		this.laboratorioSala = laboratorioSala;
	}

	public List<ActItemCatalogo> getTipoLaboratorios() {
		return tipoLaboratorios;
	}

	public void setTipoLaboratorios(List<ActItemCatalogo> tipoLaboratorios) {
		this.tipoLaboratorios = tipoLaboratorios;
	}

	public long getTipoLaboratorioSeleccionado() {
		return tipoLaboratorioSeleccionado;
	}

	public void setTipoLaboratorioSeleccionado(long tipoLaboratorioSeleccionado) {
		this.tipoLaboratorioSeleccionado = tipoLaboratorioSeleccionado;
	}

	public List<String> getNombres() {
		return nombres;
	}

	public void setNombres(List<String> nombres) {
		this.nombres = nombres;
	}

	public String getNombreSeleccionado() {
		return nombreSeleccionado;
	}

	public void setNombreSeleccionado(String nombreSeleccionado) {
		this.nombreSeleccionado = nombreSeleccionado;
	}
	
}
