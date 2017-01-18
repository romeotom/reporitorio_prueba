package ec.gob.educacion.activos.controller;

import java.io.Serializable;
import java.util.ArrayList;
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
import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.model.ActDetalleActivo;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.ActResponsable;
import ec.gob.educacion.activos.model.asignacion.InsInstitucion;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.activos.service.DetalleActivoService;
import ec.gob.educacion.activos.service.FormularioService;
import ec.gob.educacion.activos.service.InstitucionService;
import ec.gob.educacion.activos.service.ItemCatalogoService;
import ec.gob.educacion.activos.service.SalaLaboratorioService;

@Named
@ViewScoped
public class AsignacionResponsableController extends BaseController implements Serializable {

	private static final long serialVersionUID = 1025361443382689044L;
	
	@EJB
	private DetalleActivoService detalleActivoService;
	@EJB
	private ItemCatalogoService itemCatalogoService;
	@EJB
	private SalaLaboratorioService salaLaboratorioService;
	@EJB
	private FormularioService formularioService;
	@EJB
	private InstitucionService institucionService;
	
	@Inject
	private SessionResponsableController sessionResponsableController;
	
	private ActResponsable responsable;
	private List<ActDetalleActivo> detalleActivos;
	private List<ActDetalleActivo> otherDetalleActivos;
	private ActDetalleActivo detalleActivo;
	private List<ActItemCatalogo> tipoLaboratorios;
	private List<ActItemCatalogo> tiposActivos;
	private InsInstitucion institucion;

	private String username;
	private long labSalaSeleccionado;
	private long tipoSeleccionado;
	private boolean deshabilitarTipos;
	private long activoSeleccionado;
	private String amie;
	

	@PostConstruct
	public void init() {
		username = sessionResponsableController.getUsername();
		responsable = sessionResponsableController.getResponsable();
		institucion = sessionResponsableController.getInstitucion();
		cargarDetallesActivosPorResponsable();
		amie = institucion.getAmie();
	}
	
	/**
	 * Método que permite inicializar la asignación de un activo
	 */
	public void iniciarAsignacion() {
		labSalaSeleccionado = -1;
		tipoLaboratorios = null;
		tipoSeleccionado = 0;
		tiposActivos = null;
		activoSeleccionado = 0;
		otherDetalleActivos = null;
		detalleActivo = null;
		cargarLaboratorioSalas();
	}
	
	/**
	 * Método que permite crear el listado de tipos de laboratorios y salas que tiene el formulario
	 */
	public void cargarLaboratorioSalas() {
		labSalaSeleccionado = -1;
		tipoSeleccionado = 0;
		tiposActivos = null;
		activoSeleccionado = 0;
		otherDetalleActivos = null;
		detalleActivo = null;
		
		List<ActFormulario> actFormularios = formularioService
				.obtenerPorInstitucionTipoEstado(amie, null, EstadoEnum.ACTIVO.getCodigo());
		List<Long> tipoLaboratorioSalas = salaLaboratorioService.obtenerPorFormularios(actFormularios);
		tipoLaboratorios = itemCatalogoService.listarPorNemonicoCatalogoIn(Constantes.TIPO_SALA_LAB, tipoLaboratorioSalas);
	}
	
	/**
	 * Método que carga selecciona un laboratorio/sala y carga los tipos de
	 * activos correspondientes
	 */
	public void seleccionarLabSala(){
		tipoSeleccionado = 0;
		activoSeleccionado = 0;
		otherDetalleActivos = null;
		detalleActivo = null;
		
		tiposActivos = new ArrayList<ActItemCatalogo>();
		if (LaboratorioSalaEnum.BIBLIOTECA.getCodigo() == labSalaSeleccionado
				|| LaboratorioSalaEnum.AREA_ADMINISTRATIVA.getCodigo() == labSalaSeleccionado) {
			tiposActivos.add(itemCatalogoService.buscarPorCodigo(DetalleActivoEnum.COMPUTADORA.getCodigo()));
		} else {
			tiposActivos = itemCatalogoService.listarPorNemonicoCatalogo(Constantes.TIPO_ACTIVO);
		}
	}
	
	/**
	 * Método que obtiene el tipo de activo en base a las selecciones previas
	 */
	public void seleccionarTipoActivo() {
		detalleActivo = null;
		
		otherDetalleActivos = detalleActivoService.obtenerPorResponsableEstado(
				null, EstadoEnum.ACTIVO.getCodigo(), tipoSeleccionado, Boolean.TRUE, institucion.getCodigo(), labSalaSeleccionado);
	}
	
	/**
	 * Método que asigna el activo al responsable
	 */
	public void asignar() {
		detalleActivo = detalleActivoService.obtenerPorCodigo(activoSeleccionado);
		guardarAsignacion(responsable, new Date());
		cargarDetallesActivosPorResponsable();
		agregarMensajeInformacion("Asignación realizada exitosamente.", "Asignación realizada exitosamente.");
	}
	
	/**
	 * Método que selecciona el activo de la lista de los mismos
	 * 
	 * @param otherActDetalleActivo
	 */
	public void seleccionarActivo(ActDetalleActivo otherActDetalleActivo) {
		detalleActivo = otherActDetalleActivo;
	}
	
	/**
	 * Método que elimina la asignación de un activo a un responsable
	 */
	public void eliminarAsignacion() {
		guardarAsignacion(null, null);
		cargarDetallesActivosPorResponsable();
		agregarMensajeInformacion("Eliminación realizada exitosamente.", "Eliminación realizada exitosamente.");
	}

	/**
	 * Método que redirecciona a la página de responsable.xhtml
	 */
	public void volver() {
		sessionResponsableController.setUsername("");
		sessionResponsableController.setResponsable(null);
		sessionResponsableController.setInstitucion(null);
		redireccionarPagina("/faces/paginas/responsable.xhtml");
	}
	
	/**
	 * Método que obtiene la descripción del tipo de activo según su código
	 * 
	 * @param codigoTipo
	 * @return Objeto de tipo String
	 */
	public String buscarDescripcionTipo(long codigoTipo) {
		ActItemCatalogo tipoActivo = itemCatalogoService.buscarPorCodigo(codigoTipo);
		return tipoActivo == null ? "" : tipoActivo.getDescripcion();
	}
	
	/**
	 * Método que obtiene el nombre de laboratorio/sala
	 * 
	 * @param codigoTipo
	 * @return Objeto de tipo String
	 */
	public String obtenerNombreLaboratorioSala(long codigoTipo) {
		String nombre = "";
		if ((codigoTipo >= LaboratorioSalaEnum.LABORATORIO_INGLES.getCodigo()
				&& codigoTipo <= LaboratorioSalaEnum.LABORATORIO_QUIMICA.getCodigo()) 
				|| LaboratorioSalaEnum.LABORATORIO_TI.getCodigo() == codigoTipo) {
			nombre = "Laboratorio ";
		} else if (codigoTipo >= LaboratorioSalaEnum.SALA_INICIAL.getCodigo()
				&& codigoTipo <= LaboratorioSalaEnum.SALA_TERCERO_BCH.getCodigo()) {
			nombre = "Sala de clase ";
		}
		return nombre;
	}
	
	/**
	 * Método que permite actualizar la asignación de un activo
	 * 
	 * @param otherActResponsable
	 */
	private void guardarAsignacion(ActResponsable otherActResponsable, Date fechaAsignacion) {
		try {
			detalleActivo.setFechaResponsable(fechaAsignacion);
			detalleActivo.setActResponsable(otherActResponsable);
			detalleActivoService.actualizar(detalleActivo);
		} catch (DetalleActivoException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que permite obtener los registros de activos según el responsable
	 */
	private void cargarDetallesActivosPorResponsable() {
		detalleActivos = detalleActivoService.obtenerPorResponsableEstado(
				responsable, EstadoEnum.ACTIVO.getCodigo(), null, Boolean.FALSE, institucion.getCodigo(), null);
	}

	public ActResponsable getResponsable() {
		return responsable;
	}

	public void setResponsable(ActResponsable responsable) {
		this.responsable = responsable;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<ActDetalleActivo> getDetalleActivos() {
		return detalleActivos;
	}

	public void setDetalleActivos(List<ActDetalleActivo> detalleActivos) {
		this.detalleActivos = detalleActivos;
	}

	public List<ActItemCatalogo> getTipoLaboratorios() {
		return tipoLaboratorios;
	}

	public void setTipoLaboratorios(List<ActItemCatalogo> tipoLaboratorios) {
		this.tipoLaboratorios = tipoLaboratorios;
	}

	public List<ActItemCatalogo> getTiposActivos() {
		return tiposActivos;
	}

	public void setTiposActivos(List<ActItemCatalogo> tiposActivos) {
		this.tiposActivos = tiposActivos;
	}

	public ActDetalleActivo getDetalleActivo() {
		return detalleActivo;
	}

	public void setDetalleActivo(ActDetalleActivo detalleActivo) {
		this.detalleActivo = detalleActivo;
	}

	public long getLabSalaSeleccionado() {
		return labSalaSeleccionado;
	}

	public void setLabSalaSeleccionado(long labSalaSeleccionado) {
		this.labSalaSeleccionado = labSalaSeleccionado;
	}

	public long getTipoSeleccionado() {
		return tipoSeleccionado;
	}

	public void setTipoSeleccionado(long tipoSeleccionado) {
		this.tipoSeleccionado = tipoSeleccionado;
	}

	public List<ActDetalleActivo> getOtherDetalleActivos() {
		return otherDetalleActivos;
	}

	public void setOtherDetalleActivos(List<ActDetalleActivo> otherDetalleActivos) {
		this.otherDetalleActivos = otherDetalleActivos;
	}

	public boolean isDeshabilitarTipos() {
		return deshabilitarTipos;
	}

	public void setDeshabilitarTipos(boolean deshabilitarTipos) {
		this.deshabilitarTipos = deshabilitarTipos;
	}

	public long getActivoSeleccionado() {
		return activoSeleccionado;
	}

	public void setActivoSeleccionado(long activoSeleccionado) {
		this.activoSeleccionado = activoSeleccionado;
	}

	public String getAmie() {
		return amie;
	}

	public void setAmie(String amie) {
		this.amie = amie;
	}
	
}
