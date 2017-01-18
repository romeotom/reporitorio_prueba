package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.model.ActDetalleActivo;
import ec.gob.educacion.activos.model.ActResponsable;


/**
*
* @author Vimeworks Cia. Ltda.
*/

@Local
public interface DetalleActivoService {
	
	/**
	 * Metodo para  listar detalle de activos de sala
	 * @param codigoSalaLaboratorio
	 * @return lista de detalles
	 */
	public List<ActDetalleActivo> listarDetalleActivoLaboratorio(long codigoSalaLaboratorio,long codigoTipo,String amie, int estado,int anio);
	
	/**
	 * 
	 * @param serial
	 * @return
	 */
	public ActDetalleActivo buscarPorSerial(String serial);
	
	/**
	 * Metodo para buscar el detalle de un activo por serial
	 * @param serial
	 * @return objeto con el detalle de activo
	 */
	public ActDetalleActivo buscarPorSerial(String serial,String amie, int estado,int anio);
	
	/**
	 * Metodo para listar el detalle de un activo por serial
	 * @param serial
	 * @return lista detalle de activo
	 */
	public List<ActDetalleActivo> listarPorSerial(String serial,String amie, int estado,Integer anio,int estadoActivo);
	
	/**
	 * Matodo para guardar
	 * @param recibe como parametro un objeto de tipo régimen y lo almacena en la base.
	 */
	public void guardar(ActDetalleActivo detalle) throws DetalleActivoException;
	
	/**
	 * Metodo para actualizar
	 * @param recibe como parametro un objeto de tipo régimen y lo actualiza en la base.
	 */
	public void actualizar(ActDetalleActivo detalle) throws DetalleActivoException;
	
	/**
	 * Método que obtiene los activos asignados a un responsable tomando en
	 * cuenta su estado y su tipo
	 * 
	 * @param responsable
	 * @param estado
	 * @param tipoActivo
	 * @param sinResponsable
	 * @param codigoInstitucion
	 * @param tipoLabSala
	 * @return Lista de objetos de tipo ActDetalleActivo
	 */
	public List<ActDetalleActivo> obtenerPorResponsableEstado(ActResponsable responsable, Integer estado, Long tipoActivo, boolean sinResponsable, Long codigoInstitucion, Long tipoLabSala);
	
	/**
	 * Método que cuenta los activos asignados a un responsable tomando en
	 * cuenta su estado
	 * 
	 * @param responsable
	 * @param estado
	 * @return long
	 */
	public long contarPorResponsableEstado(ActResponsable responsable, Integer estado);
	
	/**
	 * Método que obtiene el detalle de un activo por su clave primaria
	 * 
	 * @param codigo
	 * @return Objeto de tipo ActDetalleActivo
	 */
	public ActDetalleActivo obtenerPorCodigo(long codigo);

	public List<ActDetalleActivo> obtenerInstitucionesPorDistrito(String codigo, long tsSeleccionada, long tipoSeleccionado);
	
}
