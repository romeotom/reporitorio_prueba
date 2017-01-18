package ec.gob.educacion.activos.service;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.JornadaEducacionException;
import ec.gob.educacion.activos.model.ActJornadaEducacion;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface JornadaEducacionService {

	/**
	 * Método que persiste una entidad de tipo ActJornadaEducacion
	 * 
	 * @param o
	 * @throws JornadaEducacionException
	 */
	public void guardar(ActJornadaEducacion o) throws JornadaEducacionException;

	/**
	 * Método que actualiza una entidad de tipo ActJornadaEducacion
	 * 
	 * @param o
	 * @throws JornadaEducacionException
	 */
	public void actualizar(ActJornadaEducacion o) throws JornadaEducacionException;

}
