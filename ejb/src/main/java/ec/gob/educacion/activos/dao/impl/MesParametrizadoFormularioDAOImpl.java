package ec.gob.educacion.activos.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.MesParametrizadoFormularioDAO;
import ec.gob.educacion.activos.model.ActMes;
import ec.gob.educacion.activos.model.ActMesParametrizadoFormulario;

@Stateless
public class MesParametrizadoFormularioDAOImpl extends GenericDAOImpl<ActMesParametrizadoFormulario, Long> implements MesParametrizadoFormularioDAO {
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.MesParametrizadoFormularioDAO#existenFormulariosParaFechaParametrizadaMenorFechaActual(ec.gob.educacion.activos.model.ActMes)
	 */
	public boolean existenFormulariosParaFechaParametrizadaMenorFechaActual(ActMes mes){
		Long cantidad = null;
		Date fechaActual = new Date();
		
		try {
			StringBuilder sentencia = new StringBuilder().append("select count(o.codigo) from ActMesParametrizadoFormulario o ");
			sentencia.append("where o.mesParametrizado.mes = :mes and o.formulario.fechaCarga < :fechaActual");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("mes", mes)
					.setParameter("fechaActual", fechaActual);
			
			cantidad = (Long) query.getSingleResult();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (cantidad!=null && cantidad.longValue() > 0L)?true:false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.MesParametrizadoFormularioDAO#listaMesParametrizadoFormulariosPorAmieAnio(java.lang.String, int)
	 */
	@SuppressWarnings("unchecked")
	public List<ActMesParametrizadoFormulario> listaMesParametrizadoFormulariosPorAmieAnio(String amie, int anio){
		List<ActMesParametrizadoFormulario> lista = new ArrayList<ActMesParametrizadoFormulario>();
		
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActMesParametrizadoFormulario o ");
			sentencia.append("where o.mesParametrizado.anio = :anio and o.formulario.amie = :amie");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("amie", amie)
					.setParameter("anio", anio);
			
			lista = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.MesParametrizadoFormularioDAO#listaMesParametrizadoFormulariosPorMesAnio(int, int)
	 */
	@SuppressWarnings("unchecked")
	public List<ActMesParametrizadoFormulario> listaMesParametrizadoFormulariosPorMesAnio(int mes, int anio){
		List<ActMesParametrizadoFormulario> lista = new ArrayList<ActMesParametrizadoFormulario>();
		
		try {
			StringBuilder sentencia = new StringBuilder().append("select distinct o from ActMesParametrizadoFormulario o ");
			sentencia.append("where o.mesParametrizado.anio = :anio and o.mesParametrizado.mes.ordenMes = :mes");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("mes", mes)
					.setParameter("anio", anio);
			
			lista = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
