package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.ZonaDAO;
import ec.gob.educacion.activos.model.asignacion.InsZona;
import ec.gob.educacion.activos.service.ZonaService;

@Stateless
public class ZonaServiceImpl implements ZonaService {

	@EJB
	private ZonaDAO zonaDao;
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ZonaService#listarZonas()
	 */
	public List<InsZona> listarZonas(){
		return zonaDao.findAll();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ZonaService#zonaPorCodigoSenplades(java.lang.String)
	 */
	public InsZona zonaPorCodigoSenplades(String codigoSenplades){
		return zonaDao.findByCodigoSenplades(codigoSenplades);
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ZonaService#zonaPorCodigo(long)
	 */
	public InsZona zonaPorCodigo(long codigo){
		return zonaDao.findById(codigo);
	}
}
