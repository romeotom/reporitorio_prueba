package ec.gob.educacion.activos.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.SalaLaboratorioDAO;
import ec.gob.educacion.activos.enumerator.LaboratorioSalaEnum;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.ActLaboratorioSala;

@Stateless
public class SalaLaboratorioDAOImpl extends GenericDAOImpl<ActLaboratorioSala, Long> implements SalaLaboratorioDAO {
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.SalaLaboratorioDAO#buscarSalaPorId(long) 
	 */
	@Override
	public ActLaboratorioSala buscarSalaPorId(long codigo){	
		Query query =em.createQuery("select c from ActLaboratorioSala c, ActDetalleActivo a  "
				+ " where a.actLaboratorioSala.codigo=c.codigo and a.codigo=:codigo")
				.setParameter("codigo", codigo);		
		return (ActLaboratorioSala) query.getSingleResult();
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.SalaLaboratorioDAO#listarSalasLaboratorios(long) 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActLaboratorioSala> listarSalasLaboratorios(long codigo) {	
		Query query =em.createQuery("select c from ActLaboratorioSala c "
				+ " where c.actFormulario.codigo=:codigo order by c.codigo")
				.setParameter("codigo", codigo);		
		return query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.SalaLaboratorioDAO#listarSalasLabFormularioIn(long) 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActLaboratorioSala> listarSalasLabFormularioIn(String amie,int anio, int estado,List<Long> codigos) {	
		Query query =em.createQuery("select c from ActLaboratorioSala c,ActFormulario o  "
				+ " where c.actFormulario.codigo=o.codigo"
				+ " and o.anio = :anio"
				+ " and o.estado = :estado"
				+ " and o.amie = :amie"
				+ " and c.codigoTipo in (:codigos)"
				+ " order by c.codigoTipo")
				.setParameter("estado", estado).setParameter("anio", anio).setParameter("amie", amie).setParameter("codigos", codigos);		
		return query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.SalaLaboratorioDAO#listarSalasLabFormularioNotIn(long) 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActLaboratorioSala> listarSalasLabFormularioNotIn(String amie,int anio, int estado,List<Long> codigos) {	
		Query query =em.createQuery("select c from ActLaboratorioSala c,ActFormulario o  "
				+ " where c.actFormulario.codigo=o.codigo"
				+ " and o.anio = :anio"
				+ " and o.estado = :estado"
				+ " and o.amie = :amie"
				+ " and c.codigoTipo not in (:codigos)"
				+ " order by c.codigoTipo")
				.setParameter("estado", estado).setParameter("anio", anio).setParameter("amie", amie).setParameter("codigos", codigos);		
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.SalaLaboratorioDAO#findByFormulario(ec.gob.educacion.activos.model.ActFormulario)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActLaboratorioSala> findByFormulario(ActFormulario actFormulario) {
		List<ActLaboratorioSala> actLaboratorioSalas = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActLaboratorioSala o ");
			sentencia.append("where o.actFormulario = :actFormulario ");
			sentencia.append("order by o.codigoTipo, o.nombreTipo ");
			
			actLaboratorioSalas = em.createQuery(sentencia.toString())
					.setParameter("actFormulario", actFormulario)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actLaboratorioSalas;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.SalaLaboratorioDAO#findAllForLaboratorioSala(ec.gob.educacion.activos.model.ActFormulario, boolean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActItemCatalogo> findAllForLaboratorioSala(ActFormulario actFormulario, boolean enLista) {
		List<ActItemCatalogo> itemCatalogos = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActItemCatalogo o ");
			sentencia.append("where o.codigo ")
					.append(enLista ? "in " : "not in ")
					.append("(select p.codigoTipo from ActLaboratorioSala p where p.actFormulario = :actFormulario) ");
			sentencia.append("and o.codigo between :codigoInicio and :codigoFin ");
			sentencia.append("order by o.codigo ");
			
			itemCatalogos = em.createQuery(sentencia.toString())
					.setParameter("actFormulario", actFormulario)
					.setParameter("codigoInicio", LaboratorioSalaEnum.LABORATORIO_TI.getCodigo())
					.setParameter("codigoFin", LaboratorioSalaEnum.AREA_ADMINISTRATIVA.getCodigo())
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemCatalogos;
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.SalaLaboratorioDAO#findLastByFormularioTipo(ec.gob.educacion.activos.model.ActFormulario, long)
	 */
	@Override
	public String findLastByFormularioTipo(ActFormulario actFormulario, long codigoTipo) {
		String nombre = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select o.nombreTipo from ActLaboratorioSala o ");
			sentencia.append("where o.actFormulario = :actFormulario ");
			sentencia.append("and o.codigoTipo = :codigoTipo ");
			sentencia.append("order by o.nombreTipo desc ");
			
			nombre = (String) em.createQuery(sentencia.toString())
					.setParameter("actFormulario", actFormulario)
					.setParameter("codigoTipo", codigoTipo)
					.setMaxResults(1)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nombre;
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.SalaLaboratorioDAO#findByFormularios(java.util.List)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Long> findByFormularios(List<ActFormulario> actFormularios) {
		List<Long> tipoLaboratorioSalas = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select distinct(o.codigoTipo) from ActLaboratorioSala o ");
			sentencia.append("where o.actFormulario in (:actFormularios) ");
			sentencia.append("order by o.codigoTipo ");
			
			tipoLaboratorioSalas = em.createQuery(sentencia.toString())
					.setParameter("actFormularios", actFormularios)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoLaboratorioSalas;
	}

}
