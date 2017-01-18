package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.DistritoDAO;
import ec.gob.educacion.activos.model.asignacion.InsDistrito;
import ec.gob.educacion.activos.service.DistritoService;

@Stateless
public class DistritoServiceImpl implements DistritoService {

	@EJB
	private DistritoDAO distritoDAO;

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.DistritoService#obtenerPorCodigoSenplades(java.lang.String)
	 */
	@Override
	public InsDistrito obtenerPorCodigoSenplades(String codigoSenplades) {
		return distritoDAO.findByCodigoSenplades(codigoSenplades);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.DistritoService#findByCodigoZona(java.lang.Long)
	 */
	public List<InsDistrito> listarDistritosPorCodigoZona(String codigoZonaSenplades){
		return distritoDAO.findByCodigoZona(codigoZonaSenplades);
	}

}
