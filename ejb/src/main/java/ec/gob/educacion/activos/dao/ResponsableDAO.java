package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.ActResponsable;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface ResponsableDAO extends GenericDAO<ActResponsable, Long> {
	
	/**
	 * Método que obtiene un listado de responsables según el criterio de
	 * búsqueda enviado
	 * 
	 * @param descripcion
	 * @param distrito
	 * @return Lista de objetos de tipo ActResponsable
	 */
	public List<ActResponsable> findByNombre(String descripcion, String distrito);
	
	/**
	 * Método que obtiene el responsable de un activo según el serial del mismo
	 * 
	 * @param descripcion
	 * @param distrito
	 * @return Lista de objetos de tipo ActResponsable
	 */
	public List<ActResponsable> findBySerial(String descripcion, String distrito);
	
	/**
	 * Método que obtiene el responsable de un activo según el serial del mismo
	 * 
	 * @param descripcion
	 * @return Lista de objetos de tipo ActResponsable
	 */
	public ActResponsable findBySerial(String descripcion);
	
	/**
	 * Método que obtiene un responsable por su identificación
	 * 
	 * @param identificacion
	 * @return Objeto de tipo ActResponsable
	 */
	public ActResponsable findByIdentificacion(String identificacion);
	
	
	/**
	 * Método que obtiene el responsable de un activo según la identificación del mismo
	 * 
	 * @param descripcion
	 * @param distrito
	 * @return Lista de objetos de tipo ActResponsable
	 */
	public List<ActResponsable> findByIdentificacionRes(String descripcion,String distrito);

}
