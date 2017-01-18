package ec.gob.educacion.activos.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.ArchivoActivoDAO;
import ec.gob.educacion.activos.model.ActArchivoActivo;

@Stateless
public class ArchivoActivoDAOImpl extends GenericDAOImpl<ActArchivoActivo, Long> implements ArchivoActivoDAO {

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ArchivoActivoDAO#listarArchivosActivo(long) 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ActArchivoActivo> listarArchivosActivo(long codigoActivo) {	
		Query query =em.createQuery("select c from ActArchivoActivo c "
				+ " where c.actDetalleActivo.codigo=:codigoActivo order by c.codigo")
				.setParameter("codigoActivo", codigoActivo);		
		return query.getResultList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ArchivoActivoDAO#buscarPorCodigo(long) 
	 */
	@Override
	public ActArchivoActivo buscarPorCodigo(long codigo) {
		ActArchivoActivo actArchivoActivo = null;
		try {
			Query query = em.createQuery("select c from ActArchivoActivo c where c.codigo=:codigo")
					.setParameter("codigo",	codigo);
			actArchivoActivo = (ActArchivoActivo) query.getSingleResult();
			if (actArchivoActivo != null) {
				actArchivoActivo.getActDetalleActivo().getCodigo();
			}
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return actArchivoActivo;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ArchivoActivoDAO#buscarMaxCodigo() 
	 */
	@Override
	public long buscarMaxCodigo(){
		Query query =em.createQuery("select max(c.codigo) from ActArchivoActivo c");
		return (Long) query.getSingleResult();
	}

	@Override 
	public String buscarNombreArchivo(String nombre) {
		try{
		Query query = em.createQuery("select c.idArchivo from ActArchivoActivo c where c.idArchivo=:nombre")
				.setParameter("nombre", nombre);
		return query.getSingleResult().toString();
		}catch(NoResultException e){
			return "vacio";
		}
	}
}
