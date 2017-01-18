package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.ActFormulario;
import ec.gob.educacion.activos.model.ActItemCatalogo;
import ec.gob.educacion.activos.model.ActLaboratorioSala;

/**
*
* @author Vimeworks Cia. Ltda.
*/
@Local
public interface SalaLaboratorioDAO extends GenericDAO<ActLaboratorioSala, Long>{
	
	/**
	 * Metodo que busca salas y laboratorios por codigo
	 * @param codigo
	 * @return objeto del tipo ActLaboratorioSala
	 */
	public ActLaboratorioSala buscarSalaPorId(long codigo);
	
	/**
	 * Metodo para  listar salas y laboratorios de un formulario
	 * @param codigo formulario
	 * @return lista de salas y laboratorios
	 */
	public List<ActLaboratorioSala> listarSalasLaboratorios(long codigo);
	
	/**
	 * Metodo para listar salas y laboratorios
	 * @param amie
	 * @param anio
	 * @param estado
	 * @param codigos de salas o laboratorios
	 * @return lista del tipo ActLaboratorioSala
	 */
	public List<ActLaboratorioSala> listarSalasLabFormularioIn(String amie,int anio, int estado,List<Long> codigos);
	
	/**
	 * Metodo para listar salas y laboratorios
	 * @param amie
	 * @param anio
	 * @param estado
	 * @param  codigos de salas o laboratorios
	 * @return lista del tipo ActLaboratorioSala
	 */
	public List<ActLaboratorioSala> listarSalasLabFormularioNotIn(String amie,int anio, int estado,List<Long> codigos);
	
	/**
	 * Método que permite obtener los laboratorios/salas por su formulario
	 * 
	 * @param actFormulario
	 * @return Lista de objetos de tipo ActLaboratorioSala
	 */
	public List<ActLaboratorioSala> findByFormulario(ActFormulario actFormulario);
	
	/**
	 * Método que obtiene los ítems de catálogo para la creación/edición de
	 * laboratorios/salas
	 * 
	 * @param actFormulario
	 * @param enLista
	 * @return Lista de objetos de tipo ActItemCatalogo
	 */
	public List<ActItemCatalogo> findAllForLaboratorioSala(ActFormulario actFormulario, boolean enLista);
	
	/**
	 * Método que obtiene el último nombre del tipo de laboratorio/sala según
	 * los parámetros enviados
	 * 
	 * @param actFormulario
	 * @param codigoTipo
	 * @return Objeto de tipo String
	 */
	public String findLastByFormularioTipo(ActFormulario actFormulario, long codigoTipo);
	
	/**
	 * Método que permite obtener los tipos de laboratorios/salas por sus formularios
	 * 
	 * @param actFormularios
	 * @return Lista de objetos de tipo Long
	 */
	public List<Long> findByFormularios(List<ActFormulario> actFormularios);

}
