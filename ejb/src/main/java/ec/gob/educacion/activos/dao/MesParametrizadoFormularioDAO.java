package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.ActMes;
import ec.gob.educacion.activos.model.ActMesParametrizadoFormulario;


@Local
public interface MesParametrizadoFormularioDAO extends GenericDAO<ActMesParametrizadoFormulario, Long>{
	
	/**
	 * Método que determina si existen formularios para un mes específico
	 * @param mes
	 * @return true or false
	 */
	public boolean existenFormulariosParaFechaParametrizadaMenorFechaActual(ActMes mes);
	
	/**
	 * Método que lista los formularios que se han generado para los meses parametrizados
	 * @param amie
	 * @param anio
	 * @return lista de objetos ActMesParametrizadoFormulario
	 */
	public List<ActMesParametrizadoFormulario> listaMesParametrizadoFormulariosPorAmieAnio(String amie, int anio);
	
	/**
	 * Método que lista los formualrios que se han generado en los meses parametrizados
	 * @param mes
	 * @param anio
	 * @return lista de objetos ActMesParametrizadoFormulario
	 */
	public List<ActMesParametrizadoFormulario> listaMesParametrizadoFormulariosPorMesAnio(int mes, int anio);
}
