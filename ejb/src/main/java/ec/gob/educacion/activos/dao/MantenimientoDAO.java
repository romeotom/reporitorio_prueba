package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.ActDetalleMantenimiento;

/**
*
* @author Vimeworks Cia. Ltda.
*/
@Local
public interface MantenimientoDAO extends GenericDAO<ActDetalleMantenimiento, Long>{
	
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

}
