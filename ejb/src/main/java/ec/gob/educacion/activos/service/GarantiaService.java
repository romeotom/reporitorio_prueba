package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.model.ActDetalleGarantia;


/**
*
* @author Vimeworks Cia. Ltda.
*/

@Local
public interface GarantiaService {
	
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
	
	/**
	 * Matodo para guardar
	 * @param recibe como parametro un objeto de tipo detalle garatia y lo almacena en la base.
	 */
	public void guardar(ActDetalleGarantia detalle) throws DetalleActivoException;
	
	/**
	 * Metodo para actualizar
	 * @param recibe como parametro un objeto de tipo detalle garatia y lo actualiza en la base.
	 */
	public void actualizar(ActDetalleGarantia detalle) throws DetalleActivoException;
	
}
