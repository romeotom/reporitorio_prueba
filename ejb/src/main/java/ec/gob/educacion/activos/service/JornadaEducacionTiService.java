package ec.gob.educacion.activos.service;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.JornadaEducacionTiException;
import ec.gob.educacion.activos.model.ActJornadaEducacionTi;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface JornadaEducacionTiService {

	/**
	 * Método que persiste una entidad de tipo ActJornadaEducacionTi
	 * 
	 * @param o
	 * @throws JornadaEducacionTiException
	 */
	public void guardar(ActJornadaEducacionTi o) throws JornadaEducacionTiException;

	/**
	 * Método que actualiza una entidad de tipo ActJornadaEducacionTi
	 * 
	 * @param o
	 * @throws JornadaEducacionTiException
	 */
	public void actualizar(ActJornadaEducacionTi o) throws JornadaEducacionTiException;

}
