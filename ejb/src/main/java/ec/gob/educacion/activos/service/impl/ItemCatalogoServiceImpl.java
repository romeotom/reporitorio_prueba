package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.gob.educacion.activos.dao.ItemCatalogoDAO;
import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.service.ItemCatalogoService;

@Stateless
public class ItemCatalogoServiceImpl implements ItemCatalogoService {

	
	@Inject
	private ItemCatalogoDAO itemCatalogoDAO;
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ItemCatalogoService#listarPorNemonicoCatalogo(String)
	 */
	public List<ActItemCatalogo> listarPorNemonicoCatalogo(String nemonico){
		return itemCatalogoDAO.listarPorNemonicoCatalogo(nemonico);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ItemCatalogoService#buscarPorCodigo(long)
	 */
	public ActItemCatalogo buscarPorCodigo(long codigo){
		return itemCatalogoDAO.buscarPorCodigo(codigo);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ItemCatalogoService#listarPorNemonicoCatalogoIn(String,long)
	 */
	public List<ActItemCatalogo> listarPorNemonicoCatalogoIn(String nemonico,List<Long> codigos){
		return itemCatalogoDAO.listarPorNemonicoCatalogoIn(nemonico, codigos);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ItemCatalogoService#listarPorNemonicoCatalogoNotIn(String,long)
	 */
	public List<ActItemCatalogo> listarPorNemonicoCatalogoNotIn(String nemonico,List<Long> codigos){
		return itemCatalogoDAO.listarPorNemonicoCatalogoNotIn(nemonico, codigos);
	}
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ItemCatalogoService#guardar(ActItemCatalogo)
	 */
	public void guardar(ActItemCatalogo item)  throws DetalleActivoException {
	    try {
	    	itemCatalogoDAO.persist(item);
		} catch (EducacionPersistException e) {
			throw new DetalleActivoException(e);
		} 
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ItemCatalogoService#actualizar(ActItemCatalogo)
	 */
	public void actualizar(ActItemCatalogo item)  throws DetalleActivoException {
        try { 	
        	itemCatalogoDAO.update(item);
		} catch (EducacionUpdateException e) {
			throw new DetalleActivoException(e);
		}
    }

	public List<ActItemCatalogo> listarPorLabSalaCatalogo(){
		return itemCatalogoDAO.listarPorLabSalaCatalogo();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ItemCatalogoService#listarTodos()
	 */
	public List<ActItemCatalogo> listarTodos(){
		return itemCatalogoDAO.findAll();
	}
}
