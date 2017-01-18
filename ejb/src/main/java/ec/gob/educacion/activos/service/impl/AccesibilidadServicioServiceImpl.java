package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.AccesibilidadServicioDAO;
import ec.gob.educacion.activos.exception.AccesibilidadServicioException;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.model.ActAccesibilidadServicio;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.service.AccesibilidadServicioService;

@Stateless
public class AccesibilidadServicioServiceImpl implements AccesibilidadServicioService {

	@EJB
	private AccesibilidadServicioDAO accesibilidadServicioDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.AccesibilidadServicioService#guardar(ec.gob.educacion.activos.model.ActAccesibilidadServicio)
	 */
	public void guardar(ActAccesibilidadServicio o) throws AccesibilidadServicioException {
		try {
			accesibilidadServicioDAO.persist(o);
		} catch (EducacionPersistException e) {
			throw new AccesibilidadServicioException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.AccesibilidadServicioService#actualizar(ec.gob.educacion.activos.model.ActAccesibilidadServicio)
	 */
	public void actualizar(ActAccesibilidadServicio o) throws AccesibilidadServicioException {
		try {
			accesibilidadServicioDAO.update(o);
		} catch (EducacionUpdateException e) {
			throw new AccesibilidadServicioException(e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.AccesibilidadServicioService#listaAccesibilidadPorFormulario(ec.gob.educacion.activos.model.ActFormulario)
	 */
	public List<ActAccesibilidadServicio> listaAccesibilidadPorFormulario(ActFormulario formulario){
		return accesibilidadServicioDAO.listaAccesibilidadPorFormulario(formulario);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.AccesibilidadServicioService#listaAccesibilidadPorFormularioYDisponibilidad(ec.gob.educacion.activos.model.ActFormulario, int)
	 */
	public List<ActAccesibilidadServicio> listaAccesibilidadPorFormularioYDisponibilidad(ActFormulario formulario, int disponibilidad){
		return accesibilidadServicioDAO.listaAccesibilidadPorFormularioYDisponibilidad(formulario, disponibilidad);
	}
}
