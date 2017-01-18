package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.CuartoServidoreException;
import ec.gob.educacion.activos.model.ActCuartoServidore;
import ec.gob.educacion.activos.model.ActFormulario;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface CuartoServidoreService {

	/**
	 * Método que persiste una entidad de tipo ActCuartoServidore
	 * 
	 * @param o
	 * @throws CuartoServidoreException
	 */
	public void guardar(ActCuartoServidore o) throws CuartoServidoreException;

	/**
	 * Método que actualiza una entidad de tipo ActCuartoServidore
	 * 
	 * @param o
	 * @throws CuartoServidoreException
	 */
	public void actualizar(ActCuartoServidore o) throws CuartoServidoreException;

	/**
	 * Método que obtiene la lista de cuarto de servidores por formulario
	 * @param formulario
	 * @return lista de objetos ActCuartoServidore
	 */
	public List<ActCuartoServidore> listaCuartoServidoresPorFormulario(ActFormulario formulario);
	
	/**
	 * Método que obtiene la lista de cuarto de servidores por formulario y disponibilidad
	 * @param formulario
	 * @param disponibilidad
	 * @return lista de objetos ActCuartoServidore
	 */
	public List<ActCuartoServidore> listaCuartoServidoresPorFormularioYDisponibilidad(ActFormulario formulario, int disponibilidad);
}
