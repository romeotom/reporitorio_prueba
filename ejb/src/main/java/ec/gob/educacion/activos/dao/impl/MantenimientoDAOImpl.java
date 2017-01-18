package ec.gob.educacion.activos.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.MantenimientoDAO;
import ec.gob.educacion.activos.model.ActDetalleMantenimiento;

@Stateless
public class MantenimientoDAOImpl extends GenericDAOImpl<ActDetalleMantenimiento, Long> implements MantenimientoDAO {

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.MantenimientoDAO#listarMantenimientosActivo(long) 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActDetalleMantenimiento> listarMantenimientosActivo(long codigoActivo) {	
		Query query =em.createQuery("select c from ActDetalleMantenimiento c "
				+ " where c.actDetalleActivo.codigo=:codigoActivo order by c.codigo")
				.setParameter("codigoActivo", codigoActivo);		
		return query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.MantenimientoDAO#buscarPorCodigo(long) 
	 */
	@Override
	public ActDetalleMantenimiento buscarPorCodigo(long codigo) {
		try{
		Query query =em.createQuery("select c from ActDetalleMantenimiento c "
				+ " where c.codigo=:codigo")
				.setParameter("codigo", codigo);		
		return (ActDetalleMantenimiento) query.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.MantenimientoDAO#buscarMaxCodigo() 
	 */
	@Override
	public long buscarMaxCodigo(){
		Query query =em.createQuery("select max(c.codigo) from ActDetalleMantenimiento c");
		return (Long) query.getSingleResult();
	}

}
