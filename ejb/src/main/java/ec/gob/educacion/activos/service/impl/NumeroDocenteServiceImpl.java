package ec.gob.educacion.activos.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.NumeroDocenteDAO;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.NumeroDocenteException;
import ec.gob.educacion.activos.model.ActNumeroDocente;
import ec.gob.educacion.activos.service.NumeroDocenteService;

@Stateless
public class NumeroDocenteServiceImpl implements NumeroDocenteService {

	@EJB
	private NumeroDocenteDAO numeroDocenteDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.NumeroDocenteService#guardar(ec.gob.educacion.activos.model.ActNumeroDocente)
	 */
	public void guardar(ActNumeroDocente o) throws NumeroDocenteException {
		try {
			numeroDocenteDAO.persist(o);
		} catch (EducacionPersistException e) {
			throw new NumeroDocenteException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.NumeroDocenteService#actualizar(ec.gob.educacion.activos.model.ActNumeroDocente)
	 */
	public void actualizar(ActNumeroDocente o) throws NumeroDocenteException {
		try {
			numeroDocenteDAO.update(o);
		} catch (EducacionUpdateException e) {
			throw new NumeroDocenteException(e);
		}
	}

}
