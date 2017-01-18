package ec.gob.educacion.activos.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.JornadaEducacionTiDAO;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.JornadaEducacionTiException;
import ec.gob.educacion.activos.model.ActJornadaEducacionTi;
import ec.gob.educacion.activos.service.JornadaEducacionTiService;

@Stateless
public class JornadaEducacionTiServiceImpl implements JornadaEducacionTiService {

	@EJB
	private JornadaEducacionTiDAO jornadaEducacionTiDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.JornadaEducacionTiService#guardar(ec.gob.educacion.activos.model.ActJornadaEducacionTi)
	 */
	public void guardar(ActJornadaEducacionTi o) throws JornadaEducacionTiException {
		try {
			jornadaEducacionTiDAO.persist(o);
		} catch (EducacionPersistException e) {
			throw new JornadaEducacionTiException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.JornadaEducacionTiService#actualizar(ec.gob.educacion.activos.model.ActJornadaEducacionTi)
	 */
	public void actualizar(ActJornadaEducacionTi o) throws JornadaEducacionTiException {
		try {
			jornadaEducacionTiDAO.update(o);
		} catch (EducacionUpdateException e) {
			throw new JornadaEducacionTiException(e);
		}
	}

}
