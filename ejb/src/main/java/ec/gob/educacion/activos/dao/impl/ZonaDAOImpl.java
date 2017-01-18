package ec.gob.educacion.activos.dao.impl;

import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.ZonaDAO;
import ec.gob.educacion.activos.model.asignacion.InsZona;

@Stateless
public class ZonaDAOImpl extends GenericDAOImpl<InsZona, Long> implements ZonaDAO {


	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.ZonaDAO#findByCodigoSenplades(java.lang.String)
	 */
	public InsZona findByCodigoSenplades(String codigoSenplades){
		InsZona zona = null;
		try {
			zona = (InsZona) em.createQuery("select o from InsZona o where o.codigoSenplades = :codigoSenplades ")
					.setParameter("codigoSenplades", codigoSenplades)
					.getSingleResult();
		} catch (Exception e) {
		}
		return zona;
	}
}
