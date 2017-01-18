package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.exception.MesParametrizadoFormularioException;
import ec.gob.educacion.activos.model.ActMes;
import ec.gob.educacion.activos.model.ActMesParametrizadoFormulario;


@Local
public interface MesParametrizadoFormularioService {

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
	 * Método que guarda un formulario para una fecha parametrizada
	 * @param o
	 * @throws MesParametrizadoFormularioException
	 */
	public void guardar(ActMesParametrizadoFormulario o) throws MesParametrizadoFormularioException;

	/**
	 * Método que actualiza un formulario para una fecha parametrizada
	 * @param o
	 * @throws MesParametrizadoFormularioException
	 */
	public void actualizar(ActMesParametrizadoFormulario o) throws MesParametrizadoFormularioException;
	
	/**
	 * Método que elimina un formulario para una fecha parametrizada
	 * @param o
	 * @throws MesParametrizadoFormularioException
	 */
	public void eliminar(ActMesParametrizadoFormulario o) throws MesParametrizadoFormularioException;
	
	/**
	 * Método que lista los formualrios que se han generado en los meses parametrizados
	 * @param mes
	 * @param anio
	 * @return lista de objetos ActMesParametrizadoFormulario
	 */
	public List<ActMesParametrizadoFormulario> listaMesParametrizadoFormulariosPorMesAnio(int mes, int anio);
}
