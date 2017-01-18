package ec.gob.educacion.activos.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.DetalleActivoDAO;
import ec.gob.educacion.activos.model.ActDetalleActivo;
import ec.gob.educacion.activos.model.ActResponsable;

@Stateless
public class DetalleActivoDAOImpl extends GenericDAOImpl<ActDetalleActivo, Long> implements DetalleActivoDAO {

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.DetalleActivoDAO#listarDetalleActivoLaboratorio(long,String) 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActDetalleActivo> listarDetalleActivoLaboratorio(long codigoSalaLaboratorio,long codigoTipo,String amie, int estado,int anio){
		Query query =em.createQuery("select c from ActDetalleActivo c,ActLaboratorioSala s,ActFormulario f"
				+ " where s.codigo=:codigoSalaLaboratorio "
				+ " and c.actLaboratorioSala.codigo=s.codigo "
				+ " and s.actFormulario.codigo=f.codigo "
				+ " and f.amie=:amie "
				+ " and c.codigoTipo=:codigoTipo"
				+ " and f.estado = :estado"
				+ " and c.estado = :estado"
				+ " and f.anio = :anio"
				+ " order by c.codigo")
				.setParameter("codigoSalaLaboratorio", codigoSalaLaboratorio).setParameter("amie", amie)
				.setParameter("codigoTipo", codigoTipo).setParameter("estado", estado).setParameter("anio", anio);		
		return query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.DetalleActivoDAO#buscarPorSerial(String) 
	 */
	@Override
	public ActDetalleActivo buscarPorSerial(String serial) {
		try{
		Query query =em.createQuery("select c from ActDetalleActivo c "
				+ " where c.serial=:serial")
				.setParameter("serial", serial);		
		return (ActDetalleActivo) query.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.DetalleActivoDAO#buscarPorSerial(String) 
	 */
	@Override
	public ActDetalleActivo buscarPorSerial(String serial,String amie, int estado,int anio) {
		try{
		Query query =em.createQuery("select c from ActDetalleActivo c,ActLaboratorioSala s,ActFormulario f "
				+ " where c.serial=:serial"
				+ " and c.actLaboratorioSala.codigo=s.codigo "
				+ " and s.actFormulario.codigo=f.codigo "
				+ " and f.amie=:amie "
				+ " and f.estado = :estado"
				+ " and c.estado = :estado"
				+ " and f.anio = :anio")
				.setParameter("serial", serial).setParameter("amie", amie).setParameter("estado", estado).setParameter("anio", anio);		
		return (ActDetalleActivo) query.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.DetalleActivoDAO#listarPorSerial(String) 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActDetalleActivo> listarPorSerial(String serial,String amie, int estado,Integer anio,int estadoActivo) {
		StringBuilder sentencia = new StringBuilder().append("select c from ActDetalleActivo c,ActLaboratorioSala s,ActFormulario f ");
		sentencia.append(" where c.serial like :serial");
		sentencia.append(" and c.actLaboratorioSala.codigo=s.codigo ");
		sentencia.append(" and s.actFormulario.codigo=f.codigo ");
		sentencia.append(" and f.estado = :estado");
		sentencia.append(" and c.estado = :estadoActivo");
		sentencia.append(" and f.amie=:amie ");
		if (anio != null) {
			sentencia.append(" and f.anio = :anio");
		}
		sentencia.append(" order by s.codigoTipo, s.nombreTipo, c.codigoTipo, c.codigo ");
		
		Query query =em.createQuery(sentencia.toString())
				.setParameter("amie", amie)
				.setParameter("serial", "%" + serial + "%")
				.setParameter("estado", estado)
				.setParameter("estadoActivo", estadoActivo);
		if (anio != null) {
			query.setParameter("anio", anio);		
		}
		
		List<ActDetalleActivo> listaAux = query.getResultList();
		
		for (ActDetalleActivo item : listaAux) {
			if (item.getActLaboratorioSala() != null) {
				item.getActLaboratorioSala().getCodigo();
				item.getActLaboratorioSala().getCodigoTipo();
				item.getActLaboratorioSala().getNombreTipo();
				item.getActLaboratorioSala().getActFormulario().getCodigo();
				item.getActLaboratorioSala().getActFormulario().getAnio();
			}
		}

		return listaAux;
		
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.DetalleActivoDAO#findByResponsableEstado(ec.gob.educacion.activos.model.ActResponsable, java.lang.Integer, java.lang.Long, boolean, java.lang.Long, java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActDetalleActivo> findByResponsableEstado(ActResponsable responsable, Integer estado, Long tipoActivo, boolean sinResponsable, Long codigoInstitucion, Long tipoLabSala) {
		List<ActDetalleActivo> detalleActivos = null;		
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActDetalleActivo o ");
			sentencia.append("where o.actResponsable ").append(sinResponsable ? "is null " : "= :actResponsable ");
			sentencia.append(estado == null ? "" : "and o.estado = :estado ");
			sentencia.append(tipoActivo == null ? "" : "and o.codigoTipo = :tipoActivo ");
			sentencia.append("and o.actLaboratorioSala.actFormulario.codigoInstitucion = :codigoInstitucion ");
			if (tipoLabSala != null) {
				sentencia.append("and o.actLaboratorioSala.codigoTipo = :tipoLabSala ");
			}
			sentencia.append("and o.serial is not null ");
			sentencia.append("order by o.codigo, o.codigoTipo ");
			
			Query query = em.createQuery(sentencia.toString());
			if (!sinResponsable) {
				query.setParameter("actResponsable", responsable);
			}
			if (estado != null) {
				query.setParameter("estado", estado);
			}
			if (tipoActivo != null) {
				query.setParameter("tipoActivo", tipoActivo);
			}
			query.setParameter("codigoInstitucion", codigoInstitucion);
			if (tipoLabSala != null) {
				query.setParameter("tipoLabSala", tipoLabSala);
			}
			
			detalleActivos = query.getResultList();
			
			for (ActDetalleActivo actDetalleActivo : detalleActivos) {
				actDetalleActivo.getActLaboratorioSala().getCodigo();
				actDetalleActivo.getActLaboratorioSala().getActFormulario().getCodigo();
				actDetalleActivo.getActLaboratorioSala().getActFormulario().getAnio();
			}
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detalleActivos;
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.DetalleActivoDAO#countByResponsableEstado(ec.gob.educacion.activos.model.ActResponsable, java.lang.Integer)
	 */
	@Override
	public long countByResponsableEstado(ActResponsable responsable, Integer estado) {
		long cantidad = 0;
		try {
			StringBuilder sentencia = new StringBuilder().append("select count(o) from ActDetalleActivo o ");
			sentencia.append("where o.actResponsable = :actResponsable ");
			if (estado != null) {
				sentencia.append("and o.estado = :estado ");
			}
			sentencia.append("order by o.codigo ");
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("actResponsable", responsable);
			if (estado != null) {
				query.setParameter("estado", estado);
			}
			
			cantidad = (Long) query.getSingleResult();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cantidad;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActDetalleActivo> listarInstitucionesPorDistrito(String codigo, long tsSeleccionada, long tipoSeleccionado) {	
		List<ActDetalleActivo> detalleActivos = null;
		try {
		Query query =em.createQuery("select distinct ad from InsDistrito d, InsCirPar cp, InsCircuito c, InsInstitucion i, "
				+ "ActDetalleActivo ad, ActFormulario f, ActLaboratorioSala al where d.codigoSenplades = :codigo "
				+ "and f.codigoInstitucion = i.codigo and c.insDistrito.codigo = d.codigo and cp.insCircuito.codigo = c.codigo " 
				+ "and i.insCirPar.codigo = cp.codigo and al.actFormulario.codigo = f.codigo and ad.codigoTipo = :tipoSeleccionado "
				+ "and ad.actLaboratorioSala.codigo = al.codigo and al.codigoTipo = :tsSeleccionada and i.codSostenimiento=1 "
				+ "and i.estado=1 and ad.serial is not null and f.estado = 1 and ad.estado = 1 and i.actualizado='F'")
				.setParameter("codigo", codigo).setParameter("tsSeleccionada", tsSeleccionada).setParameter("tipoSeleccionado", tipoSeleccionado);
		detalleActivos = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detalleActivos;
	}

}

