package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.ActArchivoActivo;

/**
*
* @author Vimeworks Cia. Ltda.
*/
@Local
public interface ArchivoActivoDAO extends GenericDAO<ActArchivoActivo, Long>{
	
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
	 * Metodo para buscar el codigo maximo de la tabla
	 * @param codigo
	 * @return archivo de activo
	 */
	public long buscarMaxCodigo();
	
	public String buscarNombreArchivo(String nombre);

}
