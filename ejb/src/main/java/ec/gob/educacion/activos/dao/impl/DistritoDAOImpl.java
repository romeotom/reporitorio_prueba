package ec.gob.educacion.activos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.DistritoDAO;
import ec.gob.educacion.activos.model.asignacion.InsDistrito;

@Stateless
public class DistritoDAOImpl extends GenericDAOImpl<InsDistrito, Long> implements DistritoDAO {

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.DistritoDAO#findByCodigoSenplades(java.lang.String)
	 */
	@Override
	public InsDistrito findByCodigoSenplades(String codigoSenplades) {
		InsDistrito insDistrito = null;
		try {
			insDistrito = (InsDistrito) em.createQuery("select o from InsDistrito o where o.codigoSenplades = :codigoSenplades ")
					.setParameter("codigoSenplades", codigoSenplades)
					.getSingleResult();
		} catch (Exception e) {
		}
		return insDistrito;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.DistritoDAO#findByCodigoZona(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	public List<InsDistrito> findByCodigoZona(String codigoZonaSenplades){
		List<InsDistrito> distritos = new ArrayList<InsDistrito>();
		try {
			Query query = em.createQuery("select o from InsDistrito o where o.insZona.codigoSenplades = :codigoZonaSenplades order by o.codigoSenplades asc")
					.setParameter("codigoZonaSenplades", codigoZonaSenplades);
			distritos = query.getResultList();
		} catch (Exception e) {
		}
		return distritos;
	}

}
