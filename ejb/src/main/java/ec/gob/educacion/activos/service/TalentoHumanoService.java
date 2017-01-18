package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.TalentoHumanoException;
import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.model.ActTalentoHumano;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface TalentoHumanoService {

	/**
	 * Método que persiste una entidad de tipo ActTalentoHumano
	 * 
	 * @param o
	 * @throws TalentoHumanoException
	 */
	public void guardar(ActTalentoHumano o) throws TalentoHumanoException;

	/**
	 * Método que actualiza una entidad de tipo ActTalentoHumano
	 * 
	 * @param o
	 * @throws TalentoHumanoException
	 */
	public void actualizar(ActTalentoHumano o) throws TalentoHumanoException;
	
	/**
	 * Método que obtiene la lista de talento humano por formulario
	 * @param formulario
	 * @return lista de objetos ActTalentoHumano
	 */
	public List<ActTalentoHumano> listaTalentoHumanoPorFormulario(ActFormulario formulario);

	/**
	 * Método que obtiene la lista de talento humano por codigo de Formulario
	 * @param formulario
	 * @return lista de objetos ActTalentoHumano
	 */
	public List<ActTalentoHumano> listaTalentoHumanoPorCodigoFormulario(Long codigoFormulario);
}
