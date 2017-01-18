package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.AccesibilidadServicioException;
import ec.gob.educacion.activos.model.ActAccesibilidadServicio;
import ec.gob.educacion.activos.model.ActFormulario;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface AccesibilidadServicioService {

	/**
	 * Método que persiste una entidad de tipo ActAccesibilidadServicio
	 * 
	 * @param o
	 * @throws AccesibilidadServicioException
	 */
	public void guardar(ActAccesibilidadServicio o) throws AccesibilidadServicioException;

	/**
	 * Método que actualiza una entidad de tipo ActAccesibilidadServicio
	 * 
	 * @param o
	 * @throws AccesibilidadServicioException
	 */
	public void actualizar(ActAccesibilidadServicio o) throws AccesibilidadServicioException;
	
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
