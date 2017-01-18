package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.MesParametrizadoDAO;
import ec.gob.educacion.activos.exception.EducacionDeleteException;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.MesParametrizadoException;
import ec.gob.educacion.activos.model.ActMes;
import ec.gob.educacion.activos.model.ActMesParametrizado;
import ec.gob.educacion.activos.service.MesParametrizadoService;

@Stateless
public class MesParametrizadoServiceImpl implements MesParametrizadoService {

	@EJB
	private MesParametrizadoDAO mesParametrizadoDAO;
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MesParametrizadoService#guardar(ec.gob.educacion.activos.model.ActMesParametrizado)
	 */
	public void guardar(ActMesParametrizado o) throws MesParametrizadoException{
		try {
			mesParametrizadoDAO.persist(o);
		} catch (EducacionPersistException e) {
			// TODO: handle exception
			throw new MesParametrizadoException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MesParametrizadoService#actualizar(ec.gob.educacion.activos.model.ActMesParametrizado)
	 */
	public void actualizar(ActMesParametrizado o) throws MesParametrizadoException{
		try {
			mesParametrizadoDAO.update(o);
		} catch (EducacionUpdateException e) {
			// TODO: handle exception
			throw new MesParametrizadoException(e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MesParametrizadoService#eliminar(ec.gob.educacion.activos.model.ActMesParametrizado)
	 */
	public void eliminar(ActMesParametrizado o) throws MesParametrizadoException{
		try {
			mesParametrizadoDAO.delete(o);
		} catch (EducacionDeleteException e) {
			// TODO: handle exception
			throw new MesParametrizadoException(e);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MesParametrizadoService#buscarPorCodigo(long)
	 */
	public ActMesParametrizado buscarPorCodigo(long codigo){
		return mesParametrizadoDAO.findById(codigo);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MesParametrizadoService#buscarPorMesYAnio(ec.gob.educacion.activos.model.ActMes, int)
	 */
	public ActMesParametrizado buscarPorMesYAnio(ActMes mes, int anio){
		return mesParametrizadoDAO.buscarPorMesYAnio(mes, anio);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MesParametrizadoService#ListadoPorAnio(int)
	 */
	public List<ActMesParametrizado> ListadoPorAnio(int anio){
		return mesParametrizadoDAO.ListadoPorAnio(anio);
	}
	
}
