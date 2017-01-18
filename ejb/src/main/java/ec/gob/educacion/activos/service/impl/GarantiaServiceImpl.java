package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.gob.educacion.activos.dao.GarantiaDAO;
import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.model.ActDetalleGarantia;
import ec.gob.educacion.activos.service.GarantiaService;

@Stateless
public class GarantiaServiceImpl implements GarantiaService {

	
	@Inject
	private GarantiaDAO garantiaDAO;
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.GarantiaService#listarGarantiasActivo(long)
	 */
	public List<ActDetalleGarantia> listarGarantiasActivo(long codigoActivo){
		return garantiaDAO.listarGarantiasActivo(codigoActivo);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.GarantiaService#buscarPorCodigo(String)
	 */
	public ActDetalleGarantia buscarPorCodigo(long codigo){
		return garantiaDAO.buscarPorCodigo(codigo);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.GarantiaService#buscarPorCodigo(String)
	 */
	public long buscarMaxCodigo(){
		return garantiaDAO.buscarMaxCodigo();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.GarantiaService#guardar(ActDetalleGarantia)
	 */
	public void guardar(ActDetalleGarantia detalle)  throws DetalleActivoException {
	    try {
	    	garantiaDAO.persist(detalle);
	    	
		} catch (EducacionPersistException e) {
			throw new DetalleActivoException(e);
			} 
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.GarantiaService#actualizar(ActDetalleGarantia)
	 */
	public void actualizar(ActDetalleGarantia detalle)  throws DetalleActivoException {
        try { 	
        	garantiaDAO.update(detalle);
			
		} catch (EducacionUpdateException e) {
			throw new DetalleActivoException(e);
		}
    }

}
