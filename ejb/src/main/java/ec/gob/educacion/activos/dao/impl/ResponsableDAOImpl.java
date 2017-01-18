package ec.gob.educacion.activos.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.ResponsableDAO;
import ec.gob.educacion.activos.enumerator.EstadoEnum;
import ec.gob.educacion.activos.model.ActResponsable;

@Stateless
public class ResponsableDAOImpl extends GenericDAOImpl<ActResponsable, Long> implements ResponsableDAO {

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ResponsableDAO#findByNombre(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActResponsable> findByNombre(String descripcion, String distrito) {
		List<ActResponsable> responsables = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select distinct(o) from ActResponsable o ");
			if (distrito != null) {
				sentencia.append(", InsInstitucion i join i.insCirPar cp join cp.insCircuito c join c.insDistrito ds ");
			}
			sentencia.append("where upper(o.nombre) like upper(:descripcion) ");
			if (distrito != null) {
				sentencia.append("and o.codigoInstitucion = i.codigo ");
				sentencia.append("and ds.codigoSenplades = :distrito ");
			}
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("descripcion", "%" + descripcion + "%");
			if (distrito != null) {
				query.setParameter("distrito", distrito);
			}
			
			responsables = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responsables;
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ResponsableDAO#findBySerial(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActResponsable> findBySerial(String descripcion, String distrito) {
		List<ActResponsable> responsables = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select distinct(o) from ActDetalleActivo d join d.actResponsable o ");
			if (distrito != null) {
				sentencia.append(", InsInstitucion i join i.insCirPar cp join cp.insCircuito c join c.insDistrito ds ");
			}
			sentencia.append("where d.serial = :descripcion ");
			sentencia.append("and d.actLaboratorioSala.actFormulario.estado = :estado ");
			if (distrito != null) {
				sentencia.append("and o.codigoInstitucion = i.codigo ");
				sentencia.append("and ds.codigoSenplades = :distrito ");
			}
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("descripcion", descripcion)
					.setParameter("estado", EstadoEnum.ACTIVO.getCodigo());
			if (distrito != null) {
				query.setParameter("distrito", distrito);
			}
			
			responsables = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responsables;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ResponsableDAO#findByIdentificacion(java.lang.String)
	 */
	@Override
	public ActResponsable findByIdentificacion(String identificacion) {
		ActResponsable responsable = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActResponsable o ");
			sentencia.append("where o.identificacion = :identificacion ");
			
			responsable = (ActResponsable) em.createQuery(sentencia.toString())
					.setParameter("identificacion", identificacion)
					.getSingleResult();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responsable;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ResponsableDAO#findBySerial(java.lang.String)
	 */
	@Override
	public ActResponsable findBySerial(String descripcion){
		ActResponsable responsable = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select o from ActDetalleActivo d join d.actResponsable o ");
			sentencia.append("where d.serial= :descripcion and o.estado=1 and d.estado=1");
			Query query = em.createQuery(sentencia.toString())
					.setParameter("descripcion", descripcion);
			responsable = (ActResponsable) query.getSingleResult();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responsable;
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ResponsableDAO#findByIdentificacionRes(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActResponsable> findByIdentificacionRes(String descripcion, String distrito) {
		List<ActResponsable> responsables = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select distinct(o) from ActResponsable o ");
			if (distrito != null) {
				sentencia.append(", InsInstitucion i join i.insCirPar cp join cp.insCircuito c join c.insDistrito ds ");
			}
			sentencia.append("where upper(o.identificacion) like upper(:descripcion) ");
			if (distrito != null) {
				sentencia.append("and o.codigoInstitucion = i.codigo ");
				sentencia.append("and ds.codigoSenplades = :distrito ");
			}
			
			Query query = em.createQuery(sentencia.toString())
					.setParameter("descripcion", "%" + descripcion + "%");
			if (distrito != null) {
				query.setParameter("distrito", distrito);
			}
			
			responsables = query.getResultList();
		} catch (NoResultException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responsables;
	}
}
