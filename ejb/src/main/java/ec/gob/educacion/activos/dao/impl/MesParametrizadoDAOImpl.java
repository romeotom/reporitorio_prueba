package ec.gob.educacion.activos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.MesParametrizadoDAO;
import ec.gob.educacion.activos.model.ActMes;
import ec.gob.educacion.activos.model.ActMesParametrizado;

@Stateless
public class MesParametrizadoDAOImpl extends GenericDAOImpl<ActMesParametrizado, Long> implements MesParametrizadoDAO {
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.MesParametrizadoDAO#buscarPorMesYAnio(ec.gob.educacion.activos.model.ActMes, int)
	 */
	public ActMesParametrizado buscarPorMesYAnio(ActMes mes, int anio){
		ActMesParametrizado mesParametrizado = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActMesParametrizado o ");
			sentencia.append("where o.mes = :mes and o.anio = :anio");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("mes", mes)
					.setParameter("anio", anio);
			
			mesParametrizado = (ActMesParametrizado) query.getSingleResult();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mesParametrizado;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.MesParametrizadoDAO#ListadoPorAnio(int)
	 */
	@SuppressWarnings("unchecked")
	public List<ActMesParametrizado> ListadoPorAnio(int anio){
		List<ActMesParametrizado> mesesParametrizados = new ArrayList<ActMesParametrizado>();
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActMesParametrizado o ");
			sentencia.append("where o.anio = :anio order by o.mes asc");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("anio", anio);
			
			mesesParametrizados = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mesesParametrizados;
	}
	
}
