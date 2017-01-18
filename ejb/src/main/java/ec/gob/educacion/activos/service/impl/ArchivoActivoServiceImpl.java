package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.gob.educacion.activos.dao.ArchivoActivoDAO;
import ec.gob.educacion.activos.exception.DetalleActivoException;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;
import ec.gob.educacion.activos.model.ActArchivoActivo;
import ec.gob.educacion.activos.service.ArchivoActivoService;

@Stateless
public class ArchivoActivoServiceImpl implements ArchivoActivoService {

	
	@Inject
	private ArchivoActivoDAO archivoActivoDAO;
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ArchivoActivoService#listarArchivosActivo(long)
	 */
	public List<ActArchivoActivo> listarArchivosActivo(long codigoActivo){
		return archivoActivoDAO.listarArchivosActivo(codigoActivo);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ArchivoActivoService#buscarPorCodigo(String)
	 */
	public ActArchivoActivo buscarPorCodigo(long codigo){
		return archivoActivoDAO.buscarPorCodigo(codigo);
	}
	
	public long buscarMaxCodigo(){
		return archivoActivoDAO.buscarMaxCodigo();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ArchivoActivoService#guardar(ActArchivoActivo)
	 */
	public void guardar(ActArchivoActivo detalle)  throws DetalleActivoException {
	    try {
	    	archivoActivoDAO.persist(detalle);
	    	
		} catch (EducacionPersistException e) {
			throw new DetalleActivoException(e);
			} 
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ArchivoActivoService#actualizar(ActArchivoActivo)
	 */
	public void actualizar(ActArchivoActivo detalle)  throws DetalleActivoException {
        try { 	
        	archivoActivoDAO.update(detalle);
			
		} catch (EducacionUpdateException e) {
			throw new DetalleActivoException(e);
		}
    }
	
	public String buscarNombreArchivo(String nombre) throws DetalleActivoException {
		return archivoActivoDAO.buscarNombreArchivo(nombre);
	}

}
