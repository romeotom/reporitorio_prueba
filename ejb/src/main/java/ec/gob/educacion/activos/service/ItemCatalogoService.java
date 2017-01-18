package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.model.ActItemCatalogo;


/**
*
* @author Vimeworks Cia. Ltda.
*/

@Local
public interface ItemCatalogoService {
	
	/**
	 * Metodo para  listar item catalogos por nemonico de catalogo
	 * @param nemonico catalogo
	 * @return lista de items
	 */
	public List<ActItemCatalogo> listarPorNemonicoCatalogo(String nemonico);
	
	/**
	 * Metodo para buscar archivo por codigo
	 * @param codigo
	 * @return item
	 */
	public ActItemCatalogo buscarPorCodigo(long codigo);
	
	/**
	 * Metodo para  listar item catalogos por nemonico de catalogo y lista de codigos de item catalogo
	 * @param nemonico catalogo
	 * @return lista de items
	 */
	public List<ActItemCatalogo> listarPorNemonicoCatalogoIn(String nemonico,List<Long> codigos);
	
	/**
	 * Metodo para  listar item catalogos por nemonico de catalogo y lista de codigos de item catalogo
	 * @param nemonico catalogo
	 * @return lista de items
	 */
	public List<ActItemCatalogo> listarPorNemonicoCatalogoNotIn(String nemonico,List<Long> codigos);
	
	/**
	 * Matodo para guardar
	 * @param recibe como parametro un objeto de tipo item catalogo y lo almacena en la base.
	 */
	public void guardar(ActItemCatalogo item) throws DetalleActivoException;
	
	/**
	 * Metodo para actualizar
	 * @param recibe como parametro un objeto de tipo item catalogo y lo actualiza en la base.
	 */
	public void actualizar(ActItemCatalogo item) throws DetalleActivoException;
	
	public List<ActItemCatalogo> listarPorLabSalaCatalogo();
	
	/**
	 * Método para listar todos los items de los catálogos
	 * @return lista de items
	 */
	public List<ActItemCatalogo> listarTodos();
	
}
