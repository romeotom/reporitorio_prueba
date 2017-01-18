package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.asignacion.InsProvincia;

/**
 * 
 * @author Vimeworks Cia. Ltda.
 */
@Local
public interface ProvinciaService {

	/**
	 * Método que lista todas las provincias
	 * @return listado de objetos InsProvincia
	 */
	public List<InsProvincia> listarProvincias();

}
