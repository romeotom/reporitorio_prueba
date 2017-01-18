package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.CantonDAO;
import ec.gob.educacion.activos.model.asignacion.InsCanton;
import ec.gob.educacion.activos.service.CantonService;

@Stateless
public class CantonServiceImpl implements CantonService {

	@EJB
	private CantonDAO cantonDAO;

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.CantonService#listarCantonesPorCodigoProvincia(java.lang.String)
	 */
	@Override
	public List<InsCanton> listarCantonesPorCodigoProvincia(String codigoProvincia) {
		return cantonDAO.findByCodigoProvincia(codigoProvincia);
	}

}
