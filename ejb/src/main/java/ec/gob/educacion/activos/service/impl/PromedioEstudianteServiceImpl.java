package ec.gob.educacion.activos.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.PromedioEstudianteDAO;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.PromedioEstudianteException;
import ec.gob.educacion.activos.model.ActPromedioEstudiante;
import ec.gob.educacion.activos.service.PromedioEstudianteService;

@Stateless
public class PromedioEstudianteServiceImpl implements PromedioEstudianteService {

	@EJB
	private PromedioEstudianteDAO promedioEstudianteDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.PromedioEstudianteService#guardar(ec.gob.educacion.activos.model.ActPromedioEstudiante)
	 */
	public void guardar(ActPromedioEstudiante o) throws PromedioEstudianteException {
		try {
			promedioEstudianteDAO.persist(o);
		} catch (EducacionPersistException e) {
			throw new PromedioEstudianteException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.PromedioEstudianteService#actualizar(ec.gob.educacion.activos.model.ActPromedioEstudiante)
	 */
	public void actualizar(ActPromedioEstudiante o) throws PromedioEstudianteException {
		try {
			promedioEstudianteDAO.update(o);
		} catch (EducacionUpdateException e) {
			throw new PromedioEstudianteException(e);
		}
	}

}
