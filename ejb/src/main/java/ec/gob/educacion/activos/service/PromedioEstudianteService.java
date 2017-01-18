package ec.gob.educacion.activos.service;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.PromedioEstudianteException;
import ec.gob.educacion.activos.model.ActPromedioEstudiante;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface PromedioEstudianteService {

	/**
	 * Método que persiste una entidad de tipo ActPromedioEstudiante
	 * 
	 * @param o
	 * @throws PromedioEstudianteException
	 */
	public void guardar(ActPromedioEstudiante o) throws PromedioEstudianteException;

	/**
	 * Método que actualiza una entidad de tipo ActPromedioEstudiante
	 * 
	 * @param o
	 * @throws PromedioEstudianteException
	 */
	public void actualizar(ActPromedioEstudiante o) throws PromedioEstudianteException;

}
