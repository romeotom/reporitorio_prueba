package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.SalaLaboratorioDAO;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.exception.SalaLaboratorioException;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.ActLaboratorioSala;
import ec.gob.educacion.activos.service.SalaLaboratorioService;

@Stateless
public class SalaLaboratorioServiceImpl implements SalaLaboratorioService {

	@EJB
	private SalaLaboratorioDAO salaLaboratorioDAO;
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.SalaLaboratorioService#buscarSalaPorId(long)
	 */
	public ActLaboratorioSala buscarSalaPorId(long codigo){
		return salaLaboratorioDAO.buscarSalaPorId(codigo);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.SalaLaboratorioService#listarSalasLaboratorios(long)
	 */
	public List<ActLaboratorioSala> listarSalasLaboratorios(long codigo){
		return salaLaboratorioDAO.listarSalasLaboratorios(codigo);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.SalaLaboratorioService#listarSalasLabFormularioIn(long)
	 */
	public List<ActLaboratorioSala> listarSalasLabFormularioIn(String amie,int anio, int estado,List<Long> codigos){
		return salaLaboratorioDAO.listarSalasLabFormularioIn( amie, anio,  estado, codigos);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.SalaLaboratorioService#listarSalasLabFormularioNotIn(long)
	 */
	public List<ActLaboratorioSala> listarSalasLabFormularioNotIn(String amie,int anio, int estado,List<Long> codigos){
		return salaLaboratorioDAO.listarSalasLabFormularioNotIn( amie, anio,  estado, codigos);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.SalaLaboratorioService#guardar(ActLaboratorioSala)
	 */
	public void guardar(ActLaboratorioSala sala) throws SalaLaboratorioException {
		try {
			salaLaboratorioDAO.persist(sala);
		} catch (EducacionPersistException e) {
			throw new SalaLaboratorioException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.SalaLaboratorioService#actualizar(ActLaboratorioSala)
	 */
	public void actualizar(ActLaboratorioSala sala) throws SalaLaboratorioException {
        try { 	
        	salaLaboratorioDAO.update(sala);
		} catch (EducacionUpdateException e) {
			throw new SalaLaboratorioException(e);
		}
    }

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.SalaLaboratorioService#obtenerPorFormulario(ec.gob.educacion.activos.model.ActFormulario)
	 */
	@Override
	public List<ActLaboratorioSala> obtenerPorFormulario(ActFormulario actFormulario) {
		return salaLaboratorioDAO.findByFormulario(actFormulario);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.SalaLaboratorioService#obtenerPorId(long)
	 */
	@Override
	public ActLaboratorioSala obtenerPorId(long codigo) {
		return salaLaboratorioDAO.findById(codigo);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.SalaLaboratorioService#obtenerPorLaboratorioSala(ec.gob.educacion.activos.model.ActFormulario, boolean)
	 */
	@Override
	public List<ActItemCatalogo> obtenerPorLaboratorioSala(ActFormulario actFormulario, boolean enLista) {
		return salaLaboratorioDAO.findAllForLaboratorioSala(actFormulario, enLista);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.SalaLaboratorioService#obtenerUltimoPorFormularioTipo(ec.gob.educacion.activos.model.ActFormulario, long)
	 */
	public String obtenerUltimoPorFormularioTipo(ActFormulario actFormulario, long codigoTipo) {
		return salaLaboratorioDAO.findLastByFormularioTipo(actFormulario, codigoTipo);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.SalaLaboratorioService#obtenerPorFormularios(java.util.List)
	 */
	@Override
	public List<Long> obtenerPorFormularios(List<ActFormulario> actFormularios) {
		return salaLaboratorioDAO.findByFormularios(actFormularios);
	}

}
