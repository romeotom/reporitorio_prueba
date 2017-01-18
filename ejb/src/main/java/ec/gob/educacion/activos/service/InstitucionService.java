package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.asignacion.InsInstitucion;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface InstitucionService {

	/**
	 * Método que obtiene una institución por su código AMIE
	 * 
	 * @param amie
	 * @return Objeto de tipo InsInstitucion
	 */
	public InsInstitucion obtenerPorAmie(String amie);

	/**
	 * Método que obtiene una institución por su código
	 * 
	 * @param codigo
	 * @return Objeto de tipo InsInstitucion
	 */
	public InsInstitucion obtenerPorCodigo(long codigo);
	
	/**
	 * Método que obtiene una institución por su código AMIE con su distrito
	 * 
	 * @param amie
	 * @return Objeto de tipo InsInstitucion
	 */
	public InsInstitucion obtenerPorAmieConDistrito(String amie);
	
	/**
	 * Método que obtiene los códigos AMIE de las instituciones educativas que
	 * pertenecen al distrito
	 * 
	 * @param distrito
	 * @return Lista de objetos de tipo String
	 */
	public List<String> obtenerAmiePorDistrito(String distrito);

}
