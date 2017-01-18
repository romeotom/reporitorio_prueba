package ec.gob.educacion.activos.service;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.RecursoDigitalException;
import ec.gob.educacion.activos.model.ActRecursoDigital;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface RecursoDigitalService {

	/**
	 * Método que persiste una entidad de tipo ActRecursoDigital
	 * 
	 * @param o
	 * @throws RecursoDigitalException
	 */
	public void guardar(ActRecursoDigital o) throws RecursoDigitalException;

	/**
	 * Método que actualiza una entidad de tipo ActRecursoDigital
	 * 
	 * @param o
	 * @throws RecursoDigitalException
	 */
	public void actualizar(ActRecursoDigital o) throws RecursoDigitalException;

}
