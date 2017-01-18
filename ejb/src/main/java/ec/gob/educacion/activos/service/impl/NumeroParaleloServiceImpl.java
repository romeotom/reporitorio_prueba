package ec.gob.educacion.activos.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.NumeroParaleloDAO;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.NumeroParaleloException;
import ec.gob.educacion.activos.model.ActNumeroParalelo;
import ec.gob.educacion.activos.service.NumeroParaleloService;

@Stateless
public class NumeroParaleloServiceImpl implements NumeroParaleloService {

	@EJB
	private NumeroParaleloDAO numeroParaleloDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.NumeroParaleloService#guardar(ec.gob.educacion.activos.model.ActNumeroParalelo)
	 */
	public void guardar(ActNumeroParalelo o) throws NumeroParaleloException {
		try {
			numeroParaleloDAO.persist(o);
		} catch (EducacionPersistException e) {
			throw new NumeroParaleloException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.NumeroParaleloService#actualizar(ec.gob.educacion.activos.model.ActNumeroParalelo)
	 */
	public void actualizar(ActNumeroParalelo o) throws NumeroParaleloException {
		try {
			numeroParaleloDAO.update(o);
		} catch (EducacionUpdateException e) {
			throw new NumeroParaleloException(e);
		}
	}

}
