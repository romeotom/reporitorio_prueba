package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;





import ec.gob.educacion.activos.dao.DetalleActivoDAO;
import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.model.ActDetalleActivo;
import ec.gob.educacion.activos.model.ActResponsable;
import ec.gob.educacion.activos.service.DetalleActivoService;

@Stateless
public class DetalleActivoServiceImpl implements DetalleActivoService {

	
	@EJB
	private DetalleActivoDAO detalleActivoDAO;
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.DetalleActivoService#listarDetalleActivoLaboratorio(long)
	 */
	public List<ActDetalleActivo> listarDetalleActivoLaboratorio(long codigoSalaLaboratorio,long codigoTipo,String amie, int estado,int anio){
		return detalleActivoDAO.listarDetalleActivoLaboratorio(codigoSalaLaboratorio,codigoTipo,amie,estado,anio);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.DetalleActivoService#buscarPorSerial(String,String)
	 */
	public ActDetalleActivo buscarPorSerial(String serial){
		return detalleActivoDAO. buscarPorSerial(serial);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.DetalleActivoService#buscarPorSerial(String,String)
	 */
	public ActDetalleActivo buscarPorSerial(String serial,String amie, int estado,int anio){
		return detalleActivoDAO.buscarPorSerial(serial,amie,  estado, anio);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.DetalleActivoService#listarPorSerial(String,String)
	 */
	public List<ActDetalleActivo> listarPorSerial(String serial,String amie, int estado,Integer anio,int estadoActivo){
		return detalleActivoDAO.listarPorSerial(serial,amie, estado, anio,estadoActivo);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.DetalleActivoService#guardar(ActDetalleActivo)
	 */
	public void guardar(ActDetalleActivo detalle)  throws DetalleActivoException {
	    try {
	    	detalleActivoDAO.persist(detalle);
	    	
		} catch (EducacionPersistException e) {
			throw new DetalleActivoException(e);
			} 
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.DetalleActivoService#actualizar(ActDetalleActivo)
	 */
	public void actualizar(ActDetalleActivo detalle)  throws DetalleActivoException {
        try { 	
        	detalleActivoDAO.update(detalle);
			
		} catch (EducacionUpdateException e) {
			throw new DetalleActivoException(e);
		}
    }

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.DetalleActivoService#obtenerPorResponsableEstado(ec.gob.educacion.activos.model.ActResponsable, java.lang.Integer, java.lang.Long, boolean, java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<ActDetalleActivo> obtenerPorResponsableEstado(ActResponsable responsable, Integer estado, Long tipoActivo, boolean sinResponsable, Long codigoInstitucion, Long tipoLabSala) {
		return detalleActivoDAO.findByResponsableEstado(responsable, estado, tipoActivo, sinResponsable, codigoInstitucion, tipoLabSala);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.DetalleActivoService#contarPorResponsableEstado(ec.gob.educacion.activos.model.ActResponsable, java.lang.Integer)
	 */
	@Override
	public long contarPorResponsableEstado(ActResponsable responsable, Integer estado) {
		return detalleActivoDAO.countByResponsableEstado(responsable, estado);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.DetalleActivoService#obtenerPorCodigo(long)
	 */
	@Override
	public ActDetalleActivo obtenerPorCodigo(long codigo) {
		return detalleActivoDAO.findById(codigo);
	}
	
	@Override
	public List<ActDetalleActivo> obtenerInstitucionesPorDistrito(String codigo, long tsSeleccionada, long tipoSeleccionado) {
		return detalleActivoDAO.listarInstitucionesPorDistrito(codigo, tsSeleccionada, tipoSeleccionado);
	}
}
