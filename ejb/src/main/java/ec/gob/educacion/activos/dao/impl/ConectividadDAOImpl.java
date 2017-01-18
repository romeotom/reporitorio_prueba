package ec.gob.educacion.activos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.ConectividadDAO;
import ec.gob.educacion.activos.model.ActConectividad;
import ec.gob.educacion.activos.model.ActFormulario;

@Stateless
public class ConectividadDAOImpl extends GenericDAOImpl<ActConectividad, Long> implements ConectividadDAO {

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ConectividadDAO#listaConectividadPorFormulario(ec.gob.educacion.activos.model.ActFormulario)
	 */
	@SuppressWarnings("unchecked")
	public List<ActConectividad> listaConectividadPorFormulario(ActFormulario formulario){
		List<ActConectividad> conectividad = new ArrayList<ActConectividad>();
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActConectividad o ");
			sentencia.append("where o.actFormulario = :formulario order by o.codigoItem asc");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("formulario", formulario);
			
			conectividad = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conectividad;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ConectividadDAO#listaConectividadPorFormularioYDisponibilidad(ec.gob.educacion.activos.model.ActFormulario, int)
	 */
	@SuppressWarnings("unchecked")
	public List<ActConectividad> listaConectividadPorFormularioYDisponibilidad(ActFormulario formulario, int disponibilidad){
		List<ActConectividad> conectividad = new ArrayList<ActConectividad>();
		try {
			StringBuilder sentencia = new StringBuilder().append("select distinct o from ActConectividad o ");
			sentencia.append("where o.actFormulario = :formulario and o.disponibilidad = :disponibilidad order by o.codigoItem asc");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("formulario", formulario)
					.setParameter("disponibilidad", disponibilidad);
			
			conectividad = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conectividad;
	}
}
