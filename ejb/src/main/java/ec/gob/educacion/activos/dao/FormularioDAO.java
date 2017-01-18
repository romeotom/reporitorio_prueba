package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.ActFormulario;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface FormularioDAO extends GenericDAO<ActFormulario, Long> {

	/**
	 * Método obtiene un formulario según su institución, año, tipo y estado
	 * 
	 * @param amie
	 * @param anio
	 * @param tipo
	 * @param estado
	 * @return Objeto de tipo ActFormulario
	 */
	public ActFormulario findByInstitucionAnioTipoEstado(String amie, int anio, Integer tipo, int estado);

	/**
	 * Método obtiene un formulario según su institución, año y estado
	 * 
	 * @param amie
	 * @param anio
	 * @param estado
	 * @return Objeto de tipo ActFormulario
	 */
	public ActFormulario findByInstitucionAnioEstado(String amie, int anio, int estado);
	
	/**
	 * Método que obtiene los años de los formularios que se encuentran activos
	 * según el código AMIE de la institución educativa
	 * 
	 * @param amie
	 * @return Lista de objetos de tipo Integer
	 */
	public List<Integer> findAniosFormularioByAmie(String amie);
	
	/**
	 * Método obtiene formularios según su institución, tipo y estado
	 * 
	 * @param amie
	 * @param tipo
	 * @param estado
	 * @return Lista de objetos de tipo ActFormulario
	 */
	public List<ActFormulario> findByInstitucionTipoEstado(String amie, Integer tipo, int estado);
	
	/**
	 * Método que obtiene los formularios cargados de una institución para un año específico
	 * @param amie
	 * @param anio
	 * @return Lista de objetos de tipo ActFormulario
	 */
	public List<ActFormulario> findByInstitucionAnio(String amie, int anio);
	
	/**
	 * Método que obtiene los formularios por amie, incluyen activos inactivos
	 * @param amie
	 * @return Lista de objetos de tipo ActFormulario
	 */
	public List<ActFormulario> listadoPorAmie(String amie);
	
}
