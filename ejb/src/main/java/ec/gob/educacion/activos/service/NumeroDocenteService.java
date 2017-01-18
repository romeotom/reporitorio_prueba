package ec.gob.educacion.activos.service;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.NumeroDocenteException;
import ec.gob.educacion.activos.model.ActNumeroDocente;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface NumeroDocenteService {

	/**
	 * Método que persiste una entidad de tipo ActNumeroDocente
	 * 
	 * @param o
	 * @throws NumeroDocenteException
	 */
	public void guardar(ActNumeroDocente o) throws NumeroDocenteException;

	/**
	 * Método que actualiza una entidad de tipo ActNumeroDocente
	 * 
	 * @param o
	 * @throws NumeroDocenteException
	 */
	public void actualizar(ActNumeroDocente o) throws NumeroDocenteException;

}
