package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.FormularioDAO;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.FormularioException;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.service.FormularioService;

@Stateless
public class FormularioServiceImpl implements FormularioService {

	@EJB
	private FormularioDAO formularioDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.FormularioService#guardar(ec.gob.educacion.activos.model.ActFormulario)
	 */
	public void guardar(ActFormulario o) throws FormularioException {
		try {
			formularioDAO.persist(o);
		} catch (EducacionPersistException e) {
			throw new FormularioException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.gob.educacion.activos.service.FormularioService#actualizar(ec.gob.educacion.activos.model.ActFormulario)
	 */
	public void actualizar(ActFormulario o) throws FormularioException {
		try {
			formularioDAO.update(o);
		} catch (EducacionUpdateException e) {
			throw new FormularioException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.FormularioService#obtenerPorInstitucionAnioTipoEstado(java.lang.String, int, java.lang.Integer, int)
	 */
	@Override
	public ActFormulario obtenerPorInstitucionAnioTipoEstado(String amie, int anio, Integer tipo, int estado) {
		return formularioDAO.findByInstitucionAnioTipoEstado(amie, anio, tipo, estado);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.FormularioService#obtenerPorInstitucionAnioEstado(java.lang.String, int, int)
	 */
	@Override
	public ActFormulario obtenerPorInstitucionAnioEstado(String amie, int anio, int estado) {
		return formularioDAO.findByInstitucionAnioEstado(amie, anio, estado);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.FormularioService#obtenerAniosFormularioPorAmie(java.lang.String)
	 */
	@Override
	public List<Integer> obtenerAniosFormularioPorAmie(String amie) {
		return formularioDAO.findAniosFormularioByAmie(amie);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.FormularioService#obtenerPorInstitucionTipoEstado(java.lang.String, java.lang.Integer, int)
	 */
	@Override
	public List<ActFormulario> obtenerPorInstitucionTipoEstado(String amie, Integer tipo, int estado) {
		return formularioDAO.findByInstitucionTipoEstado(amie, tipo, estado);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.FormularioService#findByInstitucionAnio(java.lang.String, int)
	 */
	public List<ActFormulario> findByInstitucionAnio(String amie, int anio){
		return formularioDAO.findByInstitucionAnio(amie, anio);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.FormularioService#obtenerPorCodigo(long)
	 */
	public ActFormulario obtenerPorCodigo(long codigo){
		return formularioDAO.findById(codigo);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.FormularioService#listadoPorAmie(java.lang.String)
	 */
	public List<ActFormulario> listadoPorAmie(String amie){
		return formularioDAO.listadoPorAmie(amie);
	}

}
