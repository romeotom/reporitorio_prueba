package ec.gob.educacion.activos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.CuartoServidoreDAO;
import ec.gob.educacion.activos.model.ActCuartoServidore;
import ec.gob.educacion.activos.model.ActFormulario;

@Stateless
public class CuartoServidoreDAOImpl extends GenericDAOImpl<ActCuartoServidore, Long> implements CuartoServidoreDAO {

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.CuartoServidoreDAO#listaCuartoServidoresPorFormulario(ec.gob.educacion.activos.model.ActFormulario)
	 */
	@SuppressWarnings("unchecked")
	public List<ActCuartoServidore> listaCuartoServidoresPorFormulario(ActFormulario formulario){
		List<ActCuartoServidore> cuartoServidores = new ArrayList<ActCuartoServidore>();
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActCuartoServidore o ");
			sentencia.append("where o.actFormulario = :formulario order by o.codigoItem asc");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("formulario", formulario);
			
			cuartoServidores = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cuartoServidores;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.CuartoServidoreDAO#listaCuartoServidoresPorFormularioYDisponibilidad(ec.gob.educacion.activos.model.ActFormulario, int)
	 */
	@SuppressWarnings("unchecked")
	public List<ActCuartoServidore> listaCuartoServidoresPorFormularioYDisponibilidad(ActFormulario formulario, int disponibilidad){
		List<ActCuartoServidore> cuartoServidores = new ArrayList<ActCuartoServidore>();
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActCuartoServidore o ");
			sentencia.append("where o.actFormulario = :formulario and o.disponibilidad = :disponibilidad order by o.codigoItem asc");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("formulario", formulario)
					.setParameter("disponibilidad", disponibilidad);
			
			cuartoServidores = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cuartoServidores;
	}
}
