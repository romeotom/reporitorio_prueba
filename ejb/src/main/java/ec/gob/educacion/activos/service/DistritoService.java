package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.asignacion.InsDistrito;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface DistritoService {

	/**
	 * Método que obtiene un distrito por su código senplades
	 * 
	 * @param amie
	 * @return Objeto de tipo InsDistrito
	 */
	public InsDistrito obtenerPorCodigoSenplades(String codigoSenplades);
	
	/**
	 * Método que obtiene los distritos por código de zona
	 * @param codigoZonaSenplades
	 * @return lista de objetos InsDistrito
	 */
	public List<InsDistrito> listarDistritosPorCodigoZona(String codigoZonaSenplades);

}
