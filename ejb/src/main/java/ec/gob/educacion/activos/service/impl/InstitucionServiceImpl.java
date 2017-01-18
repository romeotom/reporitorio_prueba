package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.InstitucionDAO;
import ec.gob.educacion.activos.model.asignacion.InsInstitucion;
import ec.gob.educacion.activos.service.InstitucionService;

@Stateless
public class InstitucionServiceImpl implements InstitucionService {

	@EJB
	private InstitucionDAO institucionDAO;

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.InstitucionService#obtenerPorAmie(java.lang.String)
	 */
	@Override
	public InsInstitucion obtenerPorAmie(String amie) {
		return institucionDAO.findByAmie(amie);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.InstitucionService#obtenerPorCodigo(long)
	 */
	@Override
	public InsInstitucion obtenerPorCodigo(long codigo) {
		return institucionDAO.findById(codigo);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.InstitucionService#obtenerPorAmieConDistrito(java.lang.String)
	 */
	@Override
	public InsInstitucion obtenerPorAmieConDistrito(String amie) {
		return institucionDAO.findByAmieWithDistrito(amie);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.InstitucionService#obtenerAmiePorDistrito(java.lang.String)
	 */
	@Override
	public List<String> obtenerAmiePorDistrito(String distrito) {
		return institucionDAO.findAmieByDistrito(distrito);
	}

}
