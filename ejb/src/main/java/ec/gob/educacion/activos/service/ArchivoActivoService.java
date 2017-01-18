package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.model.ActArchivoActivo;


/**
*
* @author Vimeworks Cia. Ltda.
*/

@Local
public interface ArchivoActivoService {
	
	/**
	 * Metodo para  listar archivos de un activo
	 * @param codigo activo
	 * @return lista de archivos
	 */
	public List<ActArchivoActivo> listarArchivosActivo(long codigoActivo);
	
	/**
	 * Metodo para buscar archivo por codigo
	 * @param codigo
	 * @return archivo de activo
	 */
	public ActArchivoActivo buscarPorCodigo(long codigo);
	
	/**
	 * Matodo para guardar
	 * @param recibe como parametro un objeto de tipo detalle activo y lo almacena en la base.
	 */
	public void guardar(ActArchivoActivo archivo) throws DetalleActivoException;
	
	/**
	 * Metodo para buscar el codigo maximo de la tabla
	 * @param codigo
	 * @return archivo de activo
	 */
	public long buscarMaxCodigo();
	
	/**
	 * Metodo para actualizar
	 * @param recibe como parametro un objeto de tipo detalle activo y lo actualiza en la base.
	 */
	public void actualizar(ActArchivoActivo archivo) throws DetalleActivoException;
	
	public String buscarNombreArchivo(String nombre) throws DetalleActivoException;
	
}
