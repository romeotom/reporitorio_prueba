package ec.gob.educacion.activos.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.GarantiaDAO;
import ec.gob.educacion.activos.model.ActDetalleGarantia;

@Stateless
public class GarantiaDAOImpl extends GenericDAOImpl<ActDetalleGarantia, Long> implements GarantiaDAO {

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.GarantiaDAO#listarGarantiasActivo(long) 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActDetalleGarantia> listarGarantiasActivo(long codigoActivo) {	
		Query query =em.createQuery("select c from ActDetalleGarantia c "
				+ " where c.actDetalleActivo.codigo=:codigoActivo order by c.codigo")
				.setParameter("codigoActivo", codigoActivo);		
		return query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.GarantiaDAO#buscarPorCodigo(long) 
	 */
	@Override
	public ActDetalleGarantia buscarPorCodigo(long codigo) {
		try{
		Query query =em.createQuery("select c from ActDetalleGarantia c "
				+ " where c.codigo=:codigo")
				.setParameter("codigo", codigo);		
		return (ActDetalleGarantia) query.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.GarantiaDAO#buscarMaxCodigo() 
	 */
	@Override
	public long buscarMaxCodigo(){
		Query query =em.createQuery("select max(c.codigo) from ActDetalleGarantia c");
		return (Long) query.getSingleResult();
	}

}
