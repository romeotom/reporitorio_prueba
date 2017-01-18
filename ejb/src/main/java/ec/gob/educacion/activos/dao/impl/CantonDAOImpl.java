package ec.gob.educacion.activos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.gob.educacion.activos.dao.CantonDAO;
import ec.gob.educacion.activos.model.asignacion.InsCanton;

@Stateless
public class CantonDAOImpl extends GenericDAOImpl<InsCanton, Long> implements CantonDAO {

	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.CantonDAO#findByCodigoProvincia(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<InsCanton> findByCodigoProvincia(String codigoProvincia) {
		List<InsCanton> cantones = new ArrayList<InsCanton>();
		try {
			Query query = em.createQuery("select o from InsCanton o where o.insProvincia.codigo = :codigoProvincia order by o.descripcion asc")
					.setParameter("codigoProvincia", codigoProvincia);
			cantones = query.getResultList();
		} catch (Exception e) {
		}
		return cantones;
	}

}
