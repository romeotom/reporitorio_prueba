package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.ActAccesibilidadServicio;
import ec.gob.educacion.activos.model.ActFormulario;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface AccesibilidadServicioDAO extends GenericDAO<ActAccesibilidadServicio, Long> {

	/**
	 * Método que obtiene la lista de accesibilidad por formulario
	 * @param formulario
	 * @return lista de objetos ActAccesibilidadServicio
	 */
	public List<ActAccesibilidadServicio> listaAccesibilidadPorFormulario(ActFormulario formulario);
	
	/**
	 * Método que obtiene la lista de accesibilidad por formulario y disponibilidad
	 * @param formulario
	 * @param disponibilidad
	 * @return lista de objetos ActAccesibilidadServicio
	 */
	public List<ActAccesibilidadServicio> listaAccesibilidadPorFormularioYDisponibilidad(ActFormulario formulario, int disponibilidad);
}
