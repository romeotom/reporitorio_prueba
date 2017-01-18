package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.ConectividadException;
import ec.gob.educacion.activos.model.ActConectividad;
import ec.gob.educacion.activos.model.ActFormulario;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface ConectividadService {

	/**
	 * Método que persiste una entidad de tipo ActConectividad
	 * 
	 * @param o
	 * @throws ConectividadException
	 */
	public void guardar(ActConectividad o) throws ConectividadException;

	/**
	 * Método que actualiza una entidad de tipo ActConectividad
	 * 
	 * @param o
	 * @throws ConectividadException
	 */
	public void actualizar(ActConectividad o) throws ConectividadException;
	
	/**
	 * Método que obtiene la lista de conectividad por formulario
	 * @param formulario
	 * @return lista de objetos ActConectividad
	 */
	public List<ActConectividad> listaConectividadPorFormulario(ActFormulario formulario);
	
	/**
	 * Método que obtiene la lista de conectividad por formulario y disponibilidad
	 * @param formulario
	 * @param disponibilidad
	 * @return lista de objetos ActConectividad
	 */
	public List<ActConectividad> listaConectividadPorFormularioYDisponibilidad(ActFormulario formulario, int disponibilidad);

}
