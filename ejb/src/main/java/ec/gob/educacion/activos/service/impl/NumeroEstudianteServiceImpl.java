package ec.gob.educacion.activos.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.NumeroEstudianteDAO;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.NumeroEstudianteException;
import ec.gob.educacion.activos.model.ActNumeroEstudiante;
import ec.gob.educacion.activos.service.NumeroEstudianteService;

@Stateless
public class NumeroEstudianteServiceImpl implements NumeroEstudianteService {

	@EJB
	private NumeroEstudianteDAO numeroEstudianteDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.NumeroEstudianteService#guardar(ec.gob.educacion.activos.model.ActNumeroEstudiante)
	 */
	public void guardar(ActNumeroEstudiante o) throws NumeroEstudianteException {
		try {
			numeroEstudianteDAO.persist(o);
		} catch (EducacionPersistException e) {
			throw new NumeroEstudianteException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.NumeroEstudianteService#actualizar(ec.gob.educacion.activos.model.ActNumeroEstudiante)
	 */
	public void actualizar(ActNumeroEstudiante o) throws NumeroEstudianteException {
		try {
			numeroEstudianteDAO.update(o);
		} catch (EducacionUpdateException e) {
			throw new NumeroEstudianteException(e);
		}
	}

}
