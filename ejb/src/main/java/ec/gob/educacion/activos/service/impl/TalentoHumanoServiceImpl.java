package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.TalentoHumanoDAO;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.TalentoHumanoException;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.model.ActTalentoHumano;
import ec.gob.educacion.activos.service.TalentoHumanoService;

@Stateless
public class TalentoHumanoServiceImpl implements TalentoHumanoService {

	@EJB
	private TalentoHumanoDAO talentoHumanoDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.TalentoHumanoService#guardar(ec.gob.educacion.activos.model.ActTalentoHumano)
	 */
	public void guardar(ActTalentoHumano o) throws TalentoHumanoException {
		try {
			talentoHumanoDAO.persist(o);
		} catch (EducacionPersistException e) {
			throw new TalentoHumanoException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.TalentoHumanoService#actualizar(ec.gob.educacion.activos.model.ActTalentoHumano)
	 */
	public void actualizar(ActTalentoHumano o) throws TalentoHumanoException {
		try {
			talentoHumanoDAO.update(o);
		} catch (EducacionUpdateException e) {
			throw new TalentoHumanoException(e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.TalentoHumanoService#listaTalentoHumanoPorFormulario(ec.gob.educacion.activos.model.ActFormulario)
	 */
	public List<ActTalentoHumano> listaTalentoHumanoPorFormulario(ActFormulario formulario){
		return talentoHumanoDAO.listaTalentoHumanoPorFormulario(formulario);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.TalentoHumanoService#listaTalentoHumanoPorCodigoFormulario(java.lang.Long)
	 */
	public List<ActTalentoHumano> listaTalentoHumanoPorCodigoFormulario(Long codigoFormulario){
		return talentoHumanoDAO.listaTalentoHumanoPorCodigoFormulario(codigoFormulario);
	}
}
