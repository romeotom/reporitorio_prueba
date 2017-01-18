package ec.gob.educacion.activos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.TalentoHumanoDAO;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.model.ActTalentoHumano;

@Stateless
public class TalentoHumanoDAOImpl extends GenericDAOImpl<ActTalentoHumano, Long> implements TalentoHumanoDAO {

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.TalentoHumanoDAO#listaTalentoHumanoPorFormulario(ec.gob.educacion.activos.model.ActFormulario)
	 */
	@SuppressWarnings("unchecked")
	public List<ActTalentoHumano> listaTalentoHumanoPorFormulario(ActFormulario formulario) {
		List<ActTalentoHumano> talentoHumano = new ArrayList<ActTalentoHumano>();
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActTalentoHumano o ");
			sentencia.append("where o.actFormulario = :formulario order by o.codigoCargo asc");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("formulario", formulario);
			
			talentoHumano = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return talentoHumano;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.TalentoHumanoDAO#listaTalentoHumanoPorCodigoFormulario(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	public List<ActTalentoHumano> listaTalentoHumanoPorCodigoFormulario(Long codigoFormulario) {
		List<ActTalentoHumano> talentoHumano = new ArrayList<ActTalentoHumano>();
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActTalentoHumano o ");
			sentencia.append("where o.actFormulario.codigo = :codigoFormulario order by o.codigoCargo asc");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("codigoFormulario", codigoFormulario);
			
			talentoHumano = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return talentoHumano;
	}
}
