package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.asignacion.InsZona;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface ZonaService {

	/**
	 * Método que lista todas las zonas
	 * @return listado de objetos InsZona
	 */
	public List<InsZona> listarZonas();
	
	/**
	 * Método que busca una zona por su código senplades
	 * @param codigoSenplades
	 * @return InsZona
	 */
	public InsZona zonaPorCodigoSenplades(String codigoSenplades);
	
	/**
	 * Método que busca una zona por su código
	 * @param codigo
	 * @return InsZona
	 */
	public InsZona zonaPorCodigo(long codigo);

}
