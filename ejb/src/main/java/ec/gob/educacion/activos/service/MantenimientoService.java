package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.model.ActDetalleMantenimiento;


/**
*
* @author Vimeworks Cia. Ltda.
*/

@Local
public interface MantenimientoService {
	
	/**
	 * Metodo para  listar mantenimientos de un activo
	 * @param codigo activo
	 * @return lista de detalle mantenimiento
	 */
	public List<ActDetalleMantenimiento> listarMantenimientosActivo(long codigoActivo);
	
	/**
	 * Metodo para buscar mantenimiento por codigo
	 * @param codigo
	 * @return detalle mantenimiento
	 */
	public ActDetalleMantenimiento buscarPorCodigo(long codigo);
	
	/**
	 * Metodo para buscar el codigo maximo de la tabla
	 * @param codigo
	 * @return codigo maximo
	 */
	public long buscarMaxCodigo();
	
	/**
	 * Matodo para guardar
	 * @param recibe como parametro un objeto de tipo detalle activo y lo almacena en la base.
	 */
	public void guardar(ActDetalleMantenimiento detalle) throws DetalleActivoException;
	
	/**
	 * Metodo para actualizar
	 * @param recibe como parametro un objeto de tipo detalle activo y lo actualiza en la base.
	 */
	public void actualizar(ActDetalleMantenimiento detalle) throws DetalleActivoException;
	
}
