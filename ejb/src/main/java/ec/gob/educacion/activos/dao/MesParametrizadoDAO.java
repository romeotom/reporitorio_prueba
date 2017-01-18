package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.ActMes;
import ec.gob.educacion.activos.model.ActMesParametrizado;


@Local
public interface MesParametrizadoDAO extends GenericDAO<ActMesParametrizado, Long>{
	
	/**
	 * Método para buscar un mes parametrizado por mes y año
	 * @param mes
	 * @param anio
	 * @return objeto ActMesParametrizado
	 */
	public ActMesParametrizado buscarPorMesYAnio(ActMes mes, int anio);

	/** 
	 * Método que devuelve una lista de meses parametrizados para un año específico
	 * @param anio
	 * @return
	 */
	public List<ActMesParametrizado> ListadoPorAnio(int anio);
}
