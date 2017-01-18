package ec.gob.educacion.activos.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.JornadaEducacionDAO;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.JornadaEducacionException;
import ec.gob.educacion.activos.model.ActJornadaEducacion;
import ec.gob.educacion.activos.service.JornadaEducacionService;

@Stateless
public class JornadaEducacionServiceImpl implements JornadaEducacionService {

	@EJB
	private JornadaEducacionDAO jornadaEducacionDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.JornadaEducacionService#guardar(ec.gob.educacion.activos.model.ActJornadaEducacion)
	 */
	public void guardar(ActJornadaEducacion o) throws JornadaEducacionException {
		try {
			jornadaEducacionDAO.persist(o);
		} catch (EducacionPersistException e) {
			throw new JornadaEducacionException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.JornadaEducacionService#actualizar(ec.gob.educacion.activos.model.ActJornadaEducacion)
	 */
	public void actualizar(ActJornadaEducacion o) throws JornadaEducacionException {
		try {
			jornadaEducacionDAO.update(o);
		} catch (EducacionUpdateException e) {
			throw new JornadaEducacionException(e);
		}
	}

}
