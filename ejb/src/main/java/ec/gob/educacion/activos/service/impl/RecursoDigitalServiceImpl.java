package ec.gob.educacion.activos.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.RecursoDigitalDAO;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.RecursoDigitalException;
import ec.gob.educacion.activos.model.ActRecursoDigital;
import ec.gob.educacion.activos.service.RecursoDigitalService;

@Stateless
public class RecursoDigitalServiceImpl implements RecursoDigitalService {

	@EJB
	private RecursoDigitalDAO recursoDigitalDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.RecursoDigitalService#guardar(ec.gob.educacion.activos.model.ActRecursoDigital)
	 */
	public void guardar(ActRecursoDigital o) throws RecursoDigitalException {
		try {
			recursoDigitalDAO.persist(o);
		} catch (EducacionPersistException e) {
			throw new RecursoDigitalException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.RecursoDigitalService#actualizar(ec.gob.educacion.activos.model.ActRecursoDigital)
	 */
	public void actualizar(ActRecursoDigital o) throws RecursoDigitalException {
		try {
			recursoDigitalDAO.update(o);
		} catch (EducacionUpdateException e) {
			throw new RecursoDigitalException(e);
		}
	}

}
