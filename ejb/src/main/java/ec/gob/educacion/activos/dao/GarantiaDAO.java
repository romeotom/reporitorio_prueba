package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.ActDetalleGarantia;

/**
*
* @author Vimeworks Cia. Ltda.
*/
@Local
public interface GarantiaDAO extends GenericDAO<ActDetalleGarantia, Long>{
	
	/**
	 * Metodo para  listar garantias  de un activo
	 * @param codigo activo
	 * @return lista de detalles de garantias
	 */
	public List<ActDetalleGarantia> listarGarantiasActivo(long codigoActivo);
	
	/**
	 * Metodo para buscar garantia por codigo
	 * @param codigo
	 * @return detalle de garantia
	 */
	public ActDetalleGarantia buscarPorCodigo(long codigo);
	
	/**
	 * Metodo para buscar el codigo maximo de la tabla
	 * @param codigo
	 * @return codigo maximo
	 */
	public long buscarMaxCodigo();

}
