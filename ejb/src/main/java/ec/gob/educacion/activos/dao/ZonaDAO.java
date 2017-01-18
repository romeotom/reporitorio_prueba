package ec.gob.educacion.activos.dao;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.asignacion.InsZona;


@Local
public interface ZonaDAO extends GenericDAO<InsZona, Long> {

	/**
	 * Método que busca una zona por su código senplades
	 * @param codigoSenplades
	 * @return InsZona
	 */
	public InsZona findByCodigoSenplades(String codigoSenplades);
	
}
