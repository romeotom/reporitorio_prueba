package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.ActCuartoServidore;
import ec.gob.educacion.activos.model.ActFormulario;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface CuartoServidoreDAO extends GenericDAO<ActCuartoServidore, Long> {

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
