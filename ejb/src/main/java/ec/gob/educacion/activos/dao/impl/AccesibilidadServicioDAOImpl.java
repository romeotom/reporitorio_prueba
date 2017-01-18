package ec.gob.educacion.activos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.AccesibilidadServicioDAO;
import ec.gob.educacion.activos.model.ActAccesibilidadServicio;
import ec.gob.educacion.activos.model.ActFormulario;

@Stateless
public class AccesibilidadServicioDAOImpl extends GenericDAOImpl<ActAccesibilidadServicio, Long> implements AccesibilidadServicioDAO {

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.AccesibilidadServicioDAO#listaAccesibilidadPorFormulario(ec.gob.educacion.activos.model.ActFormulario)
	 */
	@SuppressWarnings("unchecked")
	public List<ActAccesibilidadServicio> listaAccesibilidadPorFormulario(ActFormulario formulario){
		List<ActAccesibilidadServicio> accesibilidad = new ArrayList<ActAccesibilidadServicio>();
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActAccesibilidadServicio o ");
			sentencia.append("where o.actFormulario = :formulario order by o.codigoItem asc");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("formulario", formulario);
			
			accesibilidad = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return accesibilidad;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.AccesibilidadServicioDAO#listaAccesibilidadPorFormularioYDisponibilidad(ec.gob.educacion.activos.model.ActFormulario, int)
	 */
	@SuppressWarnings("unchecked")
	public List<ActAccesibilidadServicio> listaAccesibilidadPorFormularioYDisponibilidad(ActFormulario formulario, int disponibilidad){
		List<ActAccesibilidadServicio> accesibilidad = new ArrayList<ActAccesibilidadServicio>();
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActAccesibilidadServicio o ");
			sentencia.append("where o.actFormulario = :formulario and o.disponibilidad = :disponibilidad order by o.codigoItem asc");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("formulario", formulario)
					.setParameter("disponibilidad", disponibilidad);
			
			accesibilidad = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return accesibilidad;
	}
}
