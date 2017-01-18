package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.CuartoServidoreDAO;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.CuartoServidoreException;
import ec.gob.educacion.activos.model.ActCuartoServidore;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.service.CuartoServidoreService;

@Stateless
public class CuartoServidoreServiceImpl implements CuartoServidoreService {

	@EJB
	private CuartoServidoreDAO cuartoServidoreDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.CuartoServidoreService#guardar(ec.gob.educacion.activos.model.ActCuartoServidore)
	 */
	public void guardar(ActCuartoServidore o) throws CuartoServidoreException {
		try {
			cuartoServidoreDAO.persist(o);
		} catch (EducacionPersistException e) {
			throw new CuartoServidoreException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.CuartoServidoreService#actualizar(ec.gob.educacion.activos.model.ActCuartoServidore)
	 */
	public void actualizar(ActCuartoServidore o) throws CuartoServidoreException {
		try {
			cuartoServidoreDAO.update(o);
		} catch (EducacionUpdateException e) {
			throw new CuartoServidoreException(e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.CuartoServidoreService#listaCuartoServidoresPorFormulario(ec.gob.educacion.activos.model.ActFormulario)
	 */
	public List<ActCuartoServidore> listaCuartoServidoresPorFormulario(ActFormulario formulario){
		return cuartoServidoreDAO.listaCuartoServidoresPorFormulario(formulario);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.CuartoServidoreService#listaCuartoServidoresPorFormularioYDisponibilidad(ec.gob.educacion.activos.model.ActFormulario, int)
	 */
	public List<ActCuartoServidore> listaCuartoServidoresPorFormularioYDisponibilidad(ActFormulario formulario, int disponibilidad){
		return cuartoServidoreDAO.listaCuartoServidoresPorFormularioYDisponibilidad(formulario, disponibilidad);
	}
}
