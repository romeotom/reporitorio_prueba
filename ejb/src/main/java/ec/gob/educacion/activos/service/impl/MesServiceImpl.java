package ec.gob.educacion.activos.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.MesDAO;
import ec.gob.educacion.activos.model.ActMes;
import ec.gob.educacion.activos.service.MesService;

@Stateless
public class MesServiceImpl implements MesService {

	@EJB
	private MesDAO mesDAO;
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.service.MesService#listaMeses()
	 */
	public List<ActMes> listaMeses(){
		return mesDAO.findAll();
	}
}
