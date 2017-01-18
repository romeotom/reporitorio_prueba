package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.ConectividadDAO;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.ConectividadException;
import ec.gob.educacion.activos.model.ActConectividad;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.service.ConectividadService;

@Stateless
public class ConectividadServiceImpl implements ConectividadService {

	@EJB
	private ConectividadDAO conectividadDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.ConectividadService#guardar(ec.gob.educacion.activos.model.ActConectividad)
	 */
	public void guardar(ActConectividad o) throws ConectividadException {
		try {
			conectividadDAO.persist(o);
		} catch (EducacionPersistException e) {
			throw new ConectividadException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.ConectividadService#actualizar(ec.gob.educacion.activos.model.ActConectividad)
	 */
	public void actualizar(ActConectividad o) throws ConectividadException {
		try {
			conectividadDAO.update(o);
		} catch (EducacionUpdateException e) {
			throw new ConectividadException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ConectividadService#listaConectividadPorFormulario(ec.gob.educacion.activos.model.ActFormulario)
	 */
	public List<ActConectividad> listaConectividadPorFormulario(ActFormulario formulario){
		return conectividadDAO.listaConectividadPorFormulario(formulario);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ConectividadService#listaConectividadPorFormularioYDisponibilidad(ec.gob.educacion.activos.model.ActFormulario, int)
	 */
	public List<ActConectividad> listaConectividadPorFormularioYDisponibilidad(ActFormulario formulario, int disponibilidad){
		return conectividadDAO.listaConectividadPorFormularioYDisponibilidad(formulario, disponibilidad);
	}
}
