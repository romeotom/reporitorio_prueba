package ec.gob.educacion.activos.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ec.gob.educacion.acceso.scope.ViewScoped;
import ec.gob.educacion.activos.enumerator.DetalleActivoEnum;
import ec.gob.educacion.activos.enumerator.EstadoEnum;
import ec.gob.educacion.activos.enumerator.LaboratorioSalaEnum;
import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.model.ActDetalleActivo;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.ActLaboratorioSala;
import ec.gob.educacion.activos.resources.Constantes;
import ec.gob.educacion.activos.service.DetalleActivoService;
import ec.gob.educacion.activos.service.ItemCatalogoService;
import ec.gob.educacion.activos.service.SalaLaboratorioService;
import ec.gob.educacion.activos.controller.BaseController;

/**
 * Controller para activos
 * 
 * @author Vimeworks
 */
@Named
@ViewScoped
public class ActivosController extends BaseController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private SalaLaboratorioService salaLaboratorioService;
	
	@EJB
	private DetalleActivoService detalleActivoService;
	
	@EJB
	private ItemCatalogoService itemCatalogoService;
	
	@Inject
	private SessionController sessionController;
	
	private ActLaboratorioSala laboratorioSala;
	private List<ActLaboratorioSala> listaLaboratorioSala;
	private ActDetalleActivo detalleActivo;
	private List<ActDetalleActivo> listaDetalleActivo;
	private List<ActItemCatalogo> listaItemCatalagos;
	private List<ActItemCatalogo> tiposActivos;
	private ActItemCatalogo itemCatalogo;
	private ActItemCatalogo tipoActivo;
	private boolean serialRepetido;
	private String serialRepetidoMensaje;
	
	@PostConstruct
	public void init() {
		verificacionAcceso(sessionController.getUserSecurity().getUsername(), "activos.xhtml");
		laboratorioSala = new ActLaboratorioSala();
		detalleActivo = new ActDetalleActivo();
		listaLaboratorioSala = new ArrayList<ActLaboratorioSala>();
		listaDetalleActivo = new ArrayList<ActDetalleActivo>();
		itemCatalogo = new ActItemCatalogo();
		tipoActivo = new ActItemCatalogo();
		tiposActivos = null;
	}
	
	/**
	 * Método que carga un listado de laboratorios/sals según los parámetros
	 * enviados
	 * 
	 * @param opcion
	 */
	public void listarSalasLaboratorios(int opcion){
		laboratorioSala = new ActLaboratorioSala();
		tipoActivo = new ActItemCatalogo();
		listaDetalleActivo = new ArrayList<ActDetalleActivo>();
		int anio = Calendar.getInstance().get(Calendar.YEAR);
		List<Long> codigos = new ArrayList<Long>();
		codigos.add(LaboratorioSalaEnum.LABORATORIO_TI.getCodigo());
		codigos.add(LaboratorioSalaEnum.LABORATORIO_INGLES.getCodigo());
		codigos.add(LaboratorioSalaEnum.LABORATORIO_CIENCIAS.getCodigo());
		codigos.add(LaboratorioSalaEnum.LABORATORIO_FISICA.getCodigo());
		codigos.add(LaboratorioSalaEnum.LABORATORIO_QUIMICA.getCodigo());
		
		switch (opcion) {
			case 1:
				listaLaboratorioSala = salaLaboratorioService
						.listarSalasLabFormularioIn(sessionController.getUserSecurity().getUsername(), anio, EstadoEnum.ACTIVO.getCodigo(), codigos);
				break;
			case 2:
				codigos.add(LaboratorioSalaEnum.BIBLIOTECA.getCodigo());
				codigos.add(LaboratorioSalaEnum.AREA_ADMINISTRATIVA.getCodigo());
				listaLaboratorioSala = salaLaboratorioService
						.listarSalasLabFormularioNotIn(sessionController.getUserSecurity().getUsername(), anio, EstadoEnum.ACTIVO.getCodigo(), codigos);
				break;
			case 3:
				codigos = new ArrayList<Long>();
				codigos.add(LaboratorioSalaEnum.BIBLIOTECA.getCodigo());
				listaLaboratorioSala = salaLaboratorioService
						.listarSalasLabFormularioIn(sessionController.getUserSecurity().getUsername(), anio, EstadoEnum.ACTIVO.getCodigo(), codigos);
				break;
			case 4:
				codigos = new ArrayList<Long>();
				codigos.add(LaboratorioSalaEnum.AREA_ADMINISTRATIVA.getCodigo());
				listaLaboratorioSala = salaLaboratorioService
						.listarSalasLabFormularioIn(sessionController.getUserSecurity().getUsername(), anio, EstadoEnum.ACTIVO.getCodigo(), codigos);
				break;
			default:
				break;
		}
		serialRepetidoMensaje = "";
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
	 * Método que inicializa los tipos de activos cuando se ha seleccionado un
	 * laboratorio/sala
	 */
	public void limpiarBusqueda() {
		tipoActivo = new ActItemCatalogo();
		listaDetalleActivo = new ArrayList<ActDetalleActivo>();
		cargarTipoActivo();
	}
	
	/**
	 * Método que obtiene un listado de activos según los parámetros enviados
	 */
	public void listarDetallesActivos() {
		listaDetalleActivo = detalleActivoService.listarDetalleActivoLaboratorio(laboratorioSala.getCodigo(), tipoActivo.getCodigo(), 
				sessionController.getUserSecurity().getUsername(), EstadoEnum.ACTIVO.getCodigo(), Calendar.getInstance().get(Calendar.YEAR));
	}
	
	/**
	 * Método que guarda el serial de un activo existente
	 */
	public void guardarSeriales(){
		serialRepetidoMensaje = "";
		List<String> serialesRepetidoMensaje = new ArrayList<String>();
		List<String> serialesErrorMensaje = new ArrayList<String>();
		int contador = 0;
		for (ActDetalleActivo item: listaDetalleActivo) {
			validarSerialesRepetidos(item.getSerial(), item.getSerialActualizado());
			if (serialRepetido) {
				serialesRepetidoMensaje.add(item.getSerialActualizado());
			} else {
				try {
					if (item.getSerialActualizado() != null && !"".equals(item.getSerialActualizado())) {
						String otherItem = "-";
						try {
							otherItem = item.getSerialActualizado().replace(" ", "");
						} catch (Exception e) {
							e.printStackTrace();
						}
						if ("".equals(otherItem)) {
							contador++;
						} else {
							item.setSerial(item.getSerialActualizado());
							detalleActivoService.actualizar(item);
						}
					}
				} catch (DetalleActivoException e) {
					serialesErrorMensaje.add(item.getSerialActualizado());
					e.printStackTrace();
				}
			}
		}
		
		if (serialesRepetidoMensaje.isEmpty()) {
			StringBuilder blancosMensaje = new StringBuilder().append("Operación realizada exitosamente. ");
			if (contador > 0) {
				blancosMensaje.append("Existe(n) ").append(contador)
						.append(" registro(s) que al tener espacios en blanco en el valor para reemplazo no ha(n) sido actualizado(s), se sugiere su revisión. ");
			}
			agregarMensajeInformacion(blancosMensaje.toString(), blancosMensaje.toString());
		} else {
			StringBuilder mensaje = new StringBuilder().append("Los seriales no deben repetirse: ");
			for (String serialRepetidoMsg : serialesRepetidoMensaje) {
				mensaje.append(serialRepetidoMsg).append(" ");
			}
			serialRepetidoMensaje = mensaje.toString();
		}
		if (!serialesErrorMensaje.isEmpty()) {
			StringBuilder mensaje = new StringBuilder().append("Existen problemas al guardar los activos con seriales: ");
			for (String serialErrorMsg : serialesErrorMensaje) {
				mensaje.append(serialErrorMsg).append(" ");
			}
			serialRepetidoMensaje = mensaje.toString();
		}
	}
	
	/**
	 * Método que valida si el serial para actualizar ya existe
	 * 
	 * @param serial
	 * @param serialNuevo
	 */
	public void validarSerialesRepetidos(String serial, String serialNuevo) {
		serialRepetido = Boolean.FALSE;
		if (serialNuevo != null && !"".equals(serialNuevo) && (serial == null || !serial.equals(serialNuevo))) {
			ActDetalleActivo otherActDetalleActivo = detalleActivoService.buscarPorSerial(serialNuevo);
			serialRepetido = otherActDetalleActivo != null;
		}
	}
	
	/**
	 * Método que corta la cadena a un máximo de 20 caracteres en caso de que
	 * sobrepase dicha longitud
	 * 
	 * @param serial
	 * @param limite
	 * @return Objeto de tipo String
	 */
	public String obtenerSerialCortado(String serial, int limite) {
		String cadenaCortada = "";
		if (serial.trim().contains(" ")) {
			cadenaCortada = serial;
		} else {
			cadenaCortada = cortarCadena(serial, limite);
		}
		return cadenaCortada;
	}
	
	/**
	 * Método que carga los tipos de activos según el laboratorio/sala
	 * seleccionado
	 */
	private void cargarTipoActivo() {
		tiposActivos = new ArrayList<ActItemCatalogo>();
		if (laboratorioSala.getCodigo() > 0) {
			ActLaboratorioSala otherActLaboratorioSala = salaLaboratorioService.obtenerPorId(laboratorioSala.getCodigo());
			if (LaboratorioSalaEnum.BIBLIOTECA.getCodigo() == otherActLaboratorioSala.getCodigoTipo()
					|| LaboratorioSalaEnum.AREA_ADMINISTRATIVA.getCodigo() == otherActLaboratorioSala.getCodigoTipo()) {
				tiposActivos.add(itemCatalogoService.buscarPorCodigo(DetalleActivoEnum.COMPUTADORA.getCodigo()));
			} else {
				tiposActivos = itemCatalogoService.listarPorNemonicoCatalogo(Constantes.TIPO_ACTIVO);
			}
		}
	}
	
	public ActLaboratorioSala getLaboratorioSala() {
		return laboratorioSala;
	}

	public void setLaboratorioSala(ActLaboratorioSala laboratorioSala) {
		this.laboratorioSala = laboratorioSala;
	}

	public List<ActLaboratorioSala> getListaLaboratorioSala() {
		return listaLaboratorioSala;
	}

	public void setListaLaboratorioSala(List<ActLaboratorioSala> listaLaboratorioSala) {
		this.listaLaboratorioSala = listaLaboratorioSala;
	}

	public ActDetalleActivo getDetalleActivo() {
		return detalleActivo;
	}

	public void setDetalleActivo(ActDetalleActivo detalleActivo) {
		this.detalleActivo = detalleActivo;
	}

	public List<ActDetalleActivo> getListaDetalleActivo() {
		return listaDetalleActivo;
	}

	public void setListaDetalleActivo(List<ActDetalleActivo> listaDetalleActivo) {
		this.listaDetalleActivo = listaDetalleActivo;
	}

	public List<ActItemCatalogo> getListaItemCatalagos() {
		return listaItemCatalagos;
	}

	public void setListaItemCatalagos(List<ActItemCatalogo> listaItemCatalagos) {
		this.listaItemCatalagos = listaItemCatalagos;
	}

	public ActItemCatalogo getItemCatalogo() {
		return itemCatalogo;
	}

	public void setItemCatalogo(ActItemCatalogo itemCatalogo) {
		this.itemCatalogo = itemCatalogo;
	}

	public List<ActItemCatalogo> getTiposActivos() {
		return tiposActivos;
	}

	public void setTiposActivos(List<ActItemCatalogo> tiposActivos) {
		this.tiposActivos = tiposActivos;
	}

	public ActItemCatalogo getTipoActivo() {
		return tipoActivo;
	}

	public void setTipoActivo(ActItemCatalogo tipoActivo) {
		this.tipoActivo = tipoActivo;
	}

	public boolean isSerialRepetido() {
		return serialRepetido;
	}

	public void setSerialRepetido(boolean serialRepetido) {
		this.serialRepetido = serialRepetido;
	}

	public String getSerialRepetidoMensaje() {
		return serialRepetidoMensaje;
	}

	public void setSerialRepetidoMensaje(String serialRepetidoMensaje) {
		this.serialRepetidoMensaje = serialRepetidoMensaje;
	}
}