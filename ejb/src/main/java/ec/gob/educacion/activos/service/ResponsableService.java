package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.ResponsableException;
import ec.gob.educacion.activos.model.ActResponsable;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface ResponsableService {

	/**
	 * Método que persiste una entidad de tipo ActResponsable
	 * 
	 * @param o
	 * @throws ResponsableException
	 */
	public void guardar(ActResponsable o) throws ResponsableException;

	/**
	 * Método que actualiza una entidad de tipo ActResponsable
	 * 
	 * @param o
	 * @throws ResponsableException
	 */
	public void actualizar(ActResponsable o) throws ResponsableException;
	
	/**
	 * Método que obtiene un listado de responsables según el criterio de
	 * búsqueda enviado
	 * 
	 * @param descripcion
	 * @param distrito
	 * @return Lista de objetos de tipo ActResponsable
	 */
	public List<ActResponsable> obtenerPorNombre(String descripcion, String distrito);
	
	/**
	 * Método que obtiene el responsable de un activo según el serial del mismo
	 * 
	 * @param descripcion
	 * @param distrito
	 * @return Lista de objetos de tipo ActResponsable
	 */
	public List<ActResponsable> obtenerPorSerial(String descripcion, String distrito);
	
	/**
	 * Método que obtiene el responsable de un activo según el serial del mismo
	 * 
	 * @param descripcion
	 * @param distrito
	 * @return Lista de objetos de tipo ActResponsable
	 */
	public List<ActResponsable> obtenerPorIdentificacion(String descripcion, String distrito);
	
	/**
	 * Método que obtiene el responsable de un activo según el serial del mismo
	 * 
	 * @param descripcion
	 * @return Lista de objetos de tipo ActResponsable
	 */
	public ActResponsable obtenerPorSerial(String descripcion);
	
	
	/**
	 * Método que verifica la existencia de un responsable según su
	 * identificación
	 * 
	 * @param identificacion
	 * @return Verdadero o falso según el resultado obtenido
	 */
	public boolean verificarExistenciaResponsable(String identificacion);

}
