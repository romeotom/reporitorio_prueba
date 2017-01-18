package ec.gob.educacion.activos.service;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.NumeroEstudianteException;
import ec.gob.educacion.activos.model.ActNumeroEstudiante;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface NumeroEstudianteService {

	/**
	 * Método que persiste una entidad de tipo ActNumeroEstudiante
	 * 
	 * @param o
	 * @throws NumeroEstudianteException
	 */
	public void guardar(ActNumeroEstudiante o) throws NumeroEstudianteException;

	/**
	 * Método que actualiza una entidad de tipo ActNumeroEstudiante
	 * 
	 * @param o
	 * @throws NumeroEstudianteException
	 */
	public void actualizar(ActNumeroEstudiante o) throws NumeroEstudianteException;

}
