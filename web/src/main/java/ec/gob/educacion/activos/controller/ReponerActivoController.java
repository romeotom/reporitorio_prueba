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
import ec.gob.educacion.activos.enumerator.EstadoEnum;
import ec.gob.educacion.activos.enumerator.LaboratorioSalaEnum;
import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.model.ActDetalleActivo;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.activos.service.DetalleActivoService;
import ec.gob.educacion.activos.service.GarantiaService;
import ec.gob.educacion.activos.service.ItemCatalogoService;
import ec.gob.educacion.activos.service.MantenimientoService;
import ec.gob.educacion.activos.service.SalaLaboratorioService;

@Named
@ViewScoped
public class ReponerActivoController extends BaseController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DetalleActivoService detalleActivoService;
	
	@EJB
	private GarantiaService garantiaService;
	
	@EJB
	private MantenimientoService mantenimientoService;
	
	@EJB
	private ItemCatalogoService itemCatalogoService;
	
	@EJB
	private SalaLaboratorioService salaLaboratorioService;
	
	@Inject
	private SessionController sessionController;

	private ActDetalleActivo detalleActivo;
	private List<ActDetalleActivo> listaDetalleActivo;
	private List<ActItemCatalogo> listaMotivosBaja;
	private List<ActItemCatalogo> tiposActivos;
	private ActItemCatalogo motivoBaja;
	private ActDetalleActivo nuevoActivo;
	private String serial;
	private boolean existeSerial;

	@PostConstruct
	public void init() {
		verificacionAcceso(sessionController.getUserSecurity().getUsername(), "reponerActivo.xhtml");
		serial = "";
		detalleActivo = new ActDetalleActivo();
		nuevoActivo = new ActDetalleActivo();
		listaMotivosBaja = new ArrayList<ActItemCatalogo>();
		motivoBaja = new ActItemCatalogo();
		listaMotivosBaja = itemCatalogoService.listarPorNemonicoCatalogo(Constantes.TIPO_ACTIVO);
		tiposActivos = itemCatalogoService.listarPorNemonicoCatalogo(Constantes.TIPO_ACTIVO);
	}
	
	/**
	 * Método que permite obtener un listado de activos según los parámetros
	 * enviados
	 */
	public void buscarActivo() {
		listaDetalleActivo = detalleActivoService.listarPorSerial(serial, 
				sessionController.getUserSecurity().getUsername(), EstadoEnum.ACTIVO.getCodigo(), null, EstadoEnum.INACTIVO.getCodigo());
		for (ActDetalleActivo item : listaDetalleActivo) {
			item.setDescripcionTipoActivo(itemCatalogoService.buscarPorCodigo(item.getCodigoTipo()).getDescripcion());
		}
		if (listaDetalleActivo == null || listaDetalleActivo.isEmpty()) {
			agregarMensajeError(
					"El activo no se encuentra ingresado o está ya activado.",
					"El activo no se encuentra ingresado o está ya activado.");
		}
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
	
	/**
	 * Método que selecciona un activo del listado
	 * 
	 * @param detalle
	 */
	public void tomarActivo(ActDetalleActivo detalle) {
		detalleActivo = detalle;
	}
	
	/**
	 * Método que verifica si el serial nuevo ya se encuentra ingresado
	 */
	public void buscarSerialActivo() {
		if (detalleActivoService.buscarPorSerial(nuevoActivo.getSerial()) != null) {
			agregarMensajeError("El serial ya se encuentra asignado a un activo.", "");
		}
	}
	
	/**
	 * Método que realiza la reposición del activo seleccionado previamente
	 */
	public void reponerActivo() {
		try {
			nuevoActivo.setActDetalleActivo(detalleActivo);
			nuevoActivo.setCodigoTipo(detalleActivo.getCodigoTipo());
			nuevoActivo.setActLaboratorioSala(salaLaboratorioService.buscarSalaPorId(detalleActivo.getCodigo()));
			nuevoActivo.setFechaCreacion(new Date());
			nuevoActivo.setEstado(EstadoEnum.ACTIVO.getCodigo());
			detalleActivoService.guardar(nuevoActivo);
			detalleActivo.setEstado(EstadoEnum.REPUESTO.getCodigo());
			detalleActivoService.actualizar(detalleActivo);
			detalleActivo = new ActDetalleActivo();
			nuevoActivo = new ActDetalleActivo();
		} catch (DetalleActivoException e) {
			e.printStackTrace();
		}
		
		listaDetalleActivo = null;
		agregarMensajeInformacion("Operación realizada exitosamente.", "Operación realizada exitosamente.");
	}
	
	/**
	 * Método que incializa los valores del formulario
	 */
	public void limpiarValores() {
		detalleActivo = new ActDetalleActivo();
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

	public ActItemCatalogo getMotivoBaja() {
		return motivoBaja;
	}

	public void setMotivoBaja(ActItemCatalogo motivoBaja) {
		this.motivoBaja = motivoBaja;
	}

	public List<ActItemCatalogo> getListaMotivosBaja() {
		return listaMotivosBaja;
	}

	public void setListaMotivosBaja(List<ActItemCatalogo> listaMotivosBaja) {
		this.listaMotivosBaja = listaMotivosBaja;
	}

	public ActDetalleActivo getNuevoActivo() {
		return nuevoActivo;
	}

	public void setNuevoActivo(ActDetalleActivo nuevoActivo) {
		this.nuevoActivo = nuevoActivo;
	}

	public List<ActItemCatalogo> getTiposActivos() {
		return tiposActivos;
	}

	public void setTiposActivos(List<ActItemCatalogo> tiposActivos) {
		this.tiposActivos = tiposActivos;
	}
}