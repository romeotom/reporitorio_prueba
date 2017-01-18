package ec.gob.educacion.activos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.FormularioDAO;
import ec.gob.educacion.activos.enumerator.EstadoEnum;
import ec.gob.educacion.activos.model.ActFormulario;

@Stateless
public class FormularioDAOImpl extends GenericDAOImpl<ActFormulario, Long> implements FormularioDAO {

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.FormularioDAO#findByInstitucionAnioTipoEstado(java.lang.String, int, java.lang.Integer, int)
	 */
	@Override
	public ActFormulario findByInstitucionAnioTipoEstado(String amie, int anio, Integer tipo, int estado) {
		ActFormulario actFormulario = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActFormulario o ");
			sentencia.append("where o.amie = :amie ");
			sentencia.append("and o.anio = :anio ");
			if (tipo != null) {
				sentencia.append("and o.tipo = :tipo ");
			}
			sentencia.append("and o.estado = :estado ");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("amie", amie)
					.setParameter("anio", anio)
					.setParameter("estado", estado);
			if (tipo != null) {
				query.setParameter("tipo", tipo);
			}
			
			actFormulario = (ActFormulario) query.getSingleResult();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actFormulario;
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.FormularioDAO#findByInstitucionAnioEstado(java.lang.String, int, int)
	 */
	@Override
	public ActFormulario findByInstitucionAnioEstado(String amie, int anio, int estado) {
		ActFormulario actFormulario = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActFormulario o ");
			sentencia.append("where o.amie = :amie ");
			sentencia.append("and o.anio = :anio ");
			sentencia.append("and o.estado = :estado ");
			
			actFormulario = (ActFormulario) em
					.createQuery(sentencia.toString())
					.setParameter("amie", amie)
					.setParameter("anio", anio)
					.setParameter("estado", estado)
					.getSingleResult();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actFormulario;
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.FormularioDAO#findAniosFormularioByAmie(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> findAniosFormularioByAmie(String amie) {
		List<Integer> anios = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select distinct(o.anio) from ActFormulario o ");
			sentencia.append("where o.amie = :amie ");
			sentencia.append("and o.estado = :estado ");
			sentencia.append("order by o.anio ");
			
			anios = em.createQuery(sentencia.toString())
					.setParameter("amie", amie)
					.setParameter("estado", EstadoEnum.ACTIVO.getCodigo())
					.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return anios;
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.FormularioDAO#findByInstitucionTipoEstado(java.lang.String, java.lang.Integer, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActFormulario> findByInstitucionTipoEstado(String amie, Integer tipo, int estado) {
		List<ActFormulario> actFormularios = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActFormulario o ");
			sentencia.append("where o.amie = :amie ");
			if (tipo != null) {
				sentencia.append("and o.tipo = :tipo ");
			}
			sentencia.append("and o.estado = :estado ");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("amie", amie)
					.setParameter("estado", estado);
			if (tipo != null) {
				query.setParameter("tipo", tipo);
			}
			
			actFormularios = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actFormularios;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.FormularioDAO#findByInstitucionAnio(java.lang.String, int)
	 */
	@SuppressWarnings("unchecked")
	public List<ActFormulario> findByInstitucionAnio(String amie, int anio) {
		List<ActFormulario> actFormularios = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActFormulario o ");
			sentencia.append("where o.amie = :amie and o.anio = :anio order by o.fechaCarga desc");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("amie", amie)
					.setParameter("anio", anio);
			
			actFormularios = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actFormularios;
	}

	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.FormularioDAO#listadoPorAmie(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<ActFormulario> listadoPorAmie(String amie){
		List<ActFormulario> actFormularios = new ArrayList<ActFormulario>();
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActFormulario o ");
			sentencia.append("where o.amie = :amie order by o.fechaCarga desc");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("amie", amie);
			
			actFormularios = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actFormularios;
	}
}
