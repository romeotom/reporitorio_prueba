package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.asignacion.InsInstitucion;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface InstitucionDAO extends GenericDAO<InsInstitucion, Long> {

	/**
	 * Método que obtiene una institución por su código AMIE
	 * 
	 * @param amie
	 * @return Objeto de tipo InsInstitucion
	 */
	public InsInstitucion findByAmie(String amie);
	
	/**
	 * Método que obtiene una institución por su código AMIE con su distrito
	 * 
	 * @param amie
	 * @return Objeto de tipo InsInstitucion
	 */
	public InsInstitucion findByAmieWithDistrito(String amie);
	
	/**
	 * Método que obtiene los códigos AMIE de las instituciones educativas que
	 * pertenecen al distrito
	 * 
	 * @param distrito
	 * @return Lista de objetos de tipo String
	 */
	public List<String> findAmieByDistrito(String distrito);
	
}
