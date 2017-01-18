package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.gob.educacion.activos.dao.MantenimientoDAO;
import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.model.ActDetalleMantenimiento;
import ec.gob.educacion.activos.service.MantenimientoService;

@Stateless
public class MantenimientoServiceImpl implements MantenimientoService {

	
	@Inject
	private MantenimientoDAO mantenimientoDAO;
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MantenimientoService#listarMantenimientosActivo(long)
	 */
	public List<ActDetalleMantenimiento> listarMantenimientosActivo(long codigoActivo){
		return mantenimientoDAO.listarMantenimientosActivo(codigoActivo);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MantenimientoService#buscarPorCodigo(String)
	 */
	public ActDetalleMantenimiento buscarPorCodigo(long codigo){
		return mantenimientoDAO.buscarPorCodigo(codigo);
	}
	
	public long buscarMaxCodigo(){
		return mantenimientoDAO.buscarMaxCodigo();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MantenimientoService#guardar(ActArchivoActivo)
	 */
	public void guardar(ActDetalleMantenimiento detalle)  throws DetalleActivoException {
	    try {
	    	mantenimientoDAO.persist(detalle);
	    	
		} catch (EducacionPersistException e) {
			throw new DetalleActivoException(e);
			} 
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MantenimientoService#actualizar(ActArchivoActivo)
	 */
	public void actualizar(ActDetalleMantenimiento detalle)  throws DetalleActivoException {
        try { 	
        	mantenimientoDAO.update(detalle);
			
		} catch (EducacionUpdateException e) {
			throw new DetalleActivoException(e);
		}
    }

}
