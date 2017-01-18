package ec.gob.educacion.activos.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.ItemCatalogoDAO;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.resources.Constantes;

@Stateless
public class ItemCatalogoDAOImpl extends GenericDAOImpl<ActItemCatalogo, Long> implements ItemCatalogoDAO {

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ItemCatalogoDAO#listarPorNemonicoCatalogo(String) 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActItemCatalogo> listarPorNemonicoCatalogo(String nemonico) {	
		Query query =em.createQuery("select i from ActItemCatalogo i,ActCatalogo c "
				+ " where i.actCatalogo.codigo=c.codigo and c.nemonico=:nemonico order by i.descripcion")
				.setParameter("nemonico", nemonico);		
		return query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ItemCatalogoDAO#listarPorNemonicoCatalogoIn(String) 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActItemCatalogo> listarPorNemonicoCatalogoIn(String nemonico,List<Long> codigos) {	
		Query query =em.createQuery("select i from ActItemCatalogo i,ActCatalogo c "
				+ " where i.actCatalogo.codigo=c.codigo and c.nemonico=:nemonico and i.codigo in (:codigos) order by i.codigo")
				.setParameter("nemonico", nemonico).setParameter("codigos", codigos);		
		return query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ItemCatalogoDAO#listarPorNemonicoCatalogoNotIn(String) 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActItemCatalogo> listarPorNemonicoCatalogoNotIn(String nemonico,List<Long> codigos) {	
		Query query =em.createQuery("select i from ActItemCatalogo i,ActCatalogo c "
				+ " where i.actCatalogo.codigo=c.codigo and c.nemonico=:nemonico and i.codigo not in (:codigos) order by i.codigo")
				.setParameter("nemonico", nemonico).setParameter("codigos", codigos);		
		return query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ItemCatalogoDAO#buscarPorCodigo(long) 
	 */
	@Override
	public ActItemCatalogo buscarPorCodigo(long codigo) {
		try{
		Query query =em.createQuery("select c from ActItemCatalogo c "
				+ " where c.codigo=:codigo")
				.setParameter("codigo", codigo);		
		return (ActItemCatalogo) query.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActItemCatalogo> listarPorLabSalaCatalogo() {	
		Query query =em.createQuery("select i from ActItemCatalogo i"
				+ " where i.actCatalogo = " + Constantes.VALOR_DOS + " order by i.descripcion ASC");
		return query.getResultList();
	}
}
