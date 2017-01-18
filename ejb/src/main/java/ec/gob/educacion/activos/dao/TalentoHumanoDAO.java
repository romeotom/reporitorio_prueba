package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.model.ActTalentoHumano;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface TalentoHumanoDAO extends GenericDAO<ActTalentoHumano, Long> {

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
