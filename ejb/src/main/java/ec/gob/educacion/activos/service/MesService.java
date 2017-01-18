package ec.gob.educacion.activos.service;

import java.util.List;

import javax.ejb.Local;

import ec.gob.educacion.activos.model.ActMes;


@Local
public interface MesService {

	public List<ActMes> listaMeses();
}
