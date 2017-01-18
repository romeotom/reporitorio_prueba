package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.ActItemCatalogo;

/**
*
* @author Vimeworks Cia. Ltda.
*/
@Local
public interface ItemCatalogoDAO extends GenericDAO<ActItemCatalogo, Long>{
	
	/**
	 * Metodo para  listar item catalogos por nemonico de catalogo
	 * @param nemonico catalogo
	 * @return lista de items
	 */
	public List<ActItemCatalogo> listarPorNemonicoCatalogo(String nemonico);
	
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
	 * Metodo para buscar archivo por codigo
	 * @param codigo
	 * @return item
	 */
	public ActItemCatalogo buscarPorCodigo(long codigo);

	public List<ActItemCatalogo> listarPorLabSalaCatalogo();

}
