package ec.gob.educacion.activos.dao;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.asignacion.InsCanton;


@Local
public interface CantonDAO extends GenericDAO<InsCanton, Long> {

	/**
	 * Método que lista los cantones por el código dde la provincia
	 * @param codigoProvincia
	 * @return lista de objetos InsCanton
	 */
	public List<InsCanton> findByCodigoProvincia(String codigoProvincia);
	
}
