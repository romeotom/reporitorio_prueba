package ec.gob.educacion.activos.service;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.NumeroParaleloException;
import ec.gob.educacion.activos.model.ActNumeroParalelo;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface NumeroParaleloService {

	/**
	 * Método que persiste una entidad de tipo ActNumeroParalelo
	 * 
	 * @param o
	 * @throws NumeroParaleloException
	 */
	public void guardar(ActNumeroParalelo o) throws NumeroParaleloException;

	/**
	 * Método que actualiza una entidad de tipo ActNumeroParalelo
	 * 
	 * @param o
	 * @throws NumeroParaleloException
	 */
	public void actualizar(ActNumeroParalelo o) throws NumeroParaleloException;

}
