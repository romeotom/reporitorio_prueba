package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.MesParametrizadoException;
import ec.gob.educacion.activos.model.ActMes;
import ec.gob.educacion.activos.model.ActMesParametrizado;


@Local
public interface MesParametrizadoService {

	/**
	 * Método que guarda una fecha parametrizada para la carga de formularios
	 * @param o
	 * @throws MesParametrizadoException
	 */
	public void guardar(ActMesParametrizado o) throws MesParametrizadoException;

	/**
	 * Método que actualiza una fecha parametrizada para la carga de formularios
	 * @param o
	 * @throws MesParametrizadoException
	 */
	public void actualizar(ActMesParametrizado o) throws MesParametrizadoException;
	
	/**
	 * Método que elimina una fecha parametrizada para la carga de formularios
	 * @param o
	 * @throws MesParametrizadoException
	 */
	public void eliminar(ActMesParametrizado o) throws MesParametrizadoException;
	
	
	/**
	 * Método para buscar un mes Parametrizado por codigo
	 * @param codigo
	 * @return objeto ActMesParametrizado
	 */
	public ActMesParametrizado buscarPorCodigo(long codigo);
	
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
