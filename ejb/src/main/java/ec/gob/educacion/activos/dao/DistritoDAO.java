package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.asignacion.InsDistrito;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface DistritoDAO extends GenericDAO<InsDistrito, Long> {

	/**
	 * Método que obtiene un distrito por su código senplades
	 * 
	 * @param codigoSenplades
	 * @return Objeto de tipo InsDistrito
	 */
	public InsDistrito findByCodigoSenplades(String codigoSenplades);
	
	/**
	 * Método que obtiene los distritos por código de zona
	 * @param codigoZonaSenplades
	 * @return lista de objetos InsDistrito
	 */
	public List<InsDistrito> findByCodigoZona(String codigoZonaSenplades);
	
}
