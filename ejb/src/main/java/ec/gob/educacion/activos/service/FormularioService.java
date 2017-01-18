package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.FormularioException;
import ec.gob.educacion.activos.model.ActFormulario;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface FormularioService {

	/**
	 * Método que persiste una entidad de tipo ActFormulario
	 * 
	 * @param o
	 * @throws FormularioException
	 */
	public void guardar(ActFormulario o) throws FormularioException;

	/**
	 * Método que actualiza una entidad de tipo ActFormulario
	 * 
	 * @param o
	 * @throws FormularioException
	 */
	public void actualizar(ActFormulario o) throws FormularioException;
	
	/**
	 * Método que obtiene un formulario según su institución, año, tipo y estado
	 * 
	 * @param amie
	 * @param anio
	 * @param tipo
	 * @param estado
	 * @return Objeto de tipo ActFormulario
	 */
	public ActFormulario obtenerPorInstitucionAnioTipoEstado(String amie, int anio, Integer tipo, int estado);
	
	/**
	 * Método que obtiene un formulario según su institución, año y estado
	 * 
	 * @param amie
	 * @param anio
	 * @param estado
	 * @return Objeto de tipo ActFormulario
	 */
	public ActFormulario obtenerPorInstitucionAnioEstado(String amie, int anio, int estado);
	
	/**
	 * Método que obtiene los años de los formularios que se encuentran activos
	 * según el código AMIE de la institución educativa
	 * 
	 * @param amie
	 * @return Lista de objetos de tipo Integer
	 */
	public List<Integer> obtenerAniosFormularioPorAmie(String amie);
	
	/**
	 * Método que obtiene formularioa según su institución, tipo y estado
	 * 
	 * @param amie
	 * @param tipo
	 * @param estado
	 * @return Lista de objetos de tipo ActFormulario
	 */
	public List<ActFormulario> obtenerPorInstitucionTipoEstado(String amie, Integer tipo, int estado);
	
	/**
	 * Método que obtiene los formularios cargados de una institución para un año específico
	 * @param amie
	 * @param anio
	 * @return Lista de objetos de tipo ActFormulario
	 */
	public List<ActFormulario> findByInstitucionAnio(String amie, int anio);
	
	/**
	 * Método que obtiene un formulario por codigo
	 * @param codigo
	 * @return objeto ActFormulario
	 */
	public ActFormulario obtenerPorCodigo(long codigo);
	
	/**
	 * Método que obtiene los formularios por amie, incluyen activos inactivos
	 * @param amie
	 * @return Lista de objetos de tipo ActFormulario
	 */
	public List<ActFormulario> listadoPorAmie(String amie);

}
