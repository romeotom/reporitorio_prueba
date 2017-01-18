package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.ProvinciaDAO;
import ec.gob.educacion.activos.model.asignacion.InsProvincia;
import ec.gob.educacion.activos.service.ProvinciaService;

@Stateless
public class ProvinciaServiceImpl implements ProvinciaService {

	@EJB
	private ProvinciaDAO provinciaDAO;
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.ProvinciaService#listarProvincias()
	 */
	public List<InsProvincia> listarProvincias(){
		return provinciaDAO.findAll();
	}

}
