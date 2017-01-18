package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.ResponsableDAO;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.ResponsableException;
import ec.gob.educacion.activos.model.ActResponsable;
import ec.gob.educacion.activos.service.ResponsableService;

@Stateless
public class ResponsableServiceImpl implements ResponsableService {

	@EJB
	private ResponsableDAO responsableDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.ResponsableService#guardar(ec.gob.educacion.activos.model.ActResponsable)
	 */
	public void guardar(ActResponsable o) throws ResponsableException {
		try {
			responsableDAO.persist(o);
		} catch (EducacionPersistException e) {
			throw new ResponsableException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.ResponsableService#actualizar(ec.gob.educacion.activos.model.ActResponsable)
	 */
	public void actualizar(ActResponsable o) throws ResponsableException {
		try {
			responsableDAO.update(o);
		} catch (EducacionUpdateException e) {
			throw new ResponsableException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ResponsableService#obtenerPorNombre(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ActResponsable> obtenerPorNombre(String descripcion, String distrito) {
		return responsableDAO.findByNombre(descripcion, distrito);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ResponsableService#obtenerPorSerial(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ActResponsable> obtenerPorSerial(String descripcion, String distrito) {
		return responsableDAO.findBySerial(descripcion, distrito);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ResponsableService#obtenerPorSerial(java.lang.String)
	 */
	@Override
	public ActResponsable obtenerPorSerial(String descripcion) {
		return responsableDAO.findBySerial(descripcion);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ResponsableService#obtenerPorIdentificacion(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ActResponsable> obtenerPorIdentificacion(String descripcion, String distrito) {
		return responsableDAO.findByIdentificacionRes(descripcion, distrito);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ResponsableService#verificarExistenciaResponsable(java.lang.String)
	 */
	@Override
	public boolean verificarExistenciaResponsable(String identificacion) {
		ActResponsable actResponsable = responsableDAO.findByIdentificacion(identificacion);
		return actResponsable != null;
	}

}
