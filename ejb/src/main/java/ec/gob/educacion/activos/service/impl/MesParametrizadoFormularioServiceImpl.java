package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.MesParametrizadoFormularioDAO;
import ec.gob.educacion.activos.exception.EducacionDeleteException;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.MesParametrizadoFormularioException;
import ec.gob.educacion.activos.model.ActMes;
import ec.gob.educacion.activos.model.ActMesParametrizadoFormulario;
import ec.gob.educacion.activos.service.MesParametrizadoFormularioService;

@Stateless
public class MesParametrizadoFormularioServiceImpl implements MesParametrizadoFormularioService {

	@EJB
	private MesParametrizadoFormularioDAO mesParametrizadoFormularioDAO;
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MesParametrizadoFormularioService#existenFormulariosParaFechaParametrizadaMenorFechaActual(ec.gob.educacion.activos.model.ActMes)
	 */
	public boolean existenFormulariosParaFechaParametrizadaMenorFechaActual(ActMes mes){
		return mesParametrizadoFormularioDAO.existenFormulariosParaFechaParametrizadaMenorFechaActual(mes);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MesParametrizadoFormularioService#listaMesParametrizadoFormulariosPorAmieAnio(java.lang.String, int)
	 */
	public List<ActMesParametrizadoFormulario> listaMesParametrizadoFormulariosPorAmieAnio(String amie, int anio){
		return mesParametrizadoFormularioDAO.listaMesParametrizadoFormulariosPorAmieAnio(amie, anio);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MesParametrizadoFormularioService#guardar(ec.gob.educacion.activos.model.ActMesParametrizadoFormulario)
	 */
	public void guardar(ActMesParametrizadoFormulario o) throws MesParametrizadoFormularioException{
		try {
			mesParametrizadoFormularioDAO.persist(o);
		} catch (EducacionPersistException e) {
			// TODO: handle exception
			throw new MesParametrizadoFormularioException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MesParametrizadoFormularioService#actualizar(ec.gob.educacion.activos.model.ActMesParametrizadoFormulario)
	 */
	public void actualizar(ActMesParametrizadoFormulario o) throws MesParametrizadoFormularioException{
		try {
			mesParametrizadoFormularioDAO.update(o);
		} catch (EducacionUpdateException e) {
			// TODO: handle exception
			throw new MesParametrizadoFormularioException(e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MesParametrizadoFormularioService#eliminar(ec.gob.educacion.activos.model.ActMesParametrizadoFormulario)
	 */
	public void eliminar(ActMesParametrizadoFormulario o) throws MesParametrizadoFormularioException{
		try {
			mesParametrizadoFormularioDAO.delete(o);
		} catch (EducacionDeleteException e) {
			// TODO: handle exception
			throw new MesParametrizadoFormularioException(e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MesParametrizadoFormularioService#listaMesParametrizadoFormulariosPorMesAnio(int, int)
	 */
	public List<ActMesParametrizadoFormulario> listaMesParametrizadoFormulariosPorMesAnio(int mes, int anio){
		return mesParametrizadoFormularioDAO.listaMesParametrizadoFormulariosPorMesAnio(mes, anio);
	}
}
