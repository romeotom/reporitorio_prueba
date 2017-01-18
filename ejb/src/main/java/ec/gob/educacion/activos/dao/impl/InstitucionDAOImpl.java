package ec.gob.educacion.activos.dao.impl;

import java.util.List;

import javax.ejb.Stateless;

import ec.gob.educacion.activos.dao.InstitucionDAO;
import ec.gob.educacion.activos.model.asignacion.InsInstitucion;

@Stateless
public class InstitucionDAOImpl extends GenericDAOImpl<InsInstitucion, Long> implements InstitucionDAO {

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.InstitucionDAO#findByAmie(java.lang.String)
	 */
	@Override
	public InsInstitucion findByAmie(String amie) {
		InsInstitucion insInstitucion = null;
		try {
			insInstitucion = (InsInstitucion) em.createQuery("select o from InsInstitucion o where o.amie = :amie ")
					.setParameter("amie", amie)
					.getSingleResult();
			if (insInstitucion != null) {
				insInstitucion.getInsCirPar().getInsCircuito().getInsDistrito().getInsZona().getNombre();
				insInstitucion.getInsCirPar().getInsCircuito().getInsDistrito().getCodigoSenplades();
				insInstitucion.getInsCirPar().getInsCircuito().getInsDistrito().getDescripcion();
				insInstitucion.getInsCirPar().getInsCircuito().getCodigoSenplades();
				insInstitucion.getInsCirPar().getInsCircuito().getDescripcion();
				insInstitucion.getInsCirPar().getCodigo();
				insInstitucion.getInsCirPar().getInsCircuito().getCodigo();
				insInstitucion.getInsCirPar().getInsCircuito().getInsDistrito().getCodigo();
			}
		} catch (Exception e) {
		}
		return insInstitucion;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.InstitucionDAO#findByAmieWithDistrito(java.lang.String)
	 */
	@Override
	public InsInstitucion findByAmieWithDistrito(String amie) {
		InsInstitucion insInstitucion = null;
		try {
			insInstitucion = (InsInstitucion) em.createQuery("select o from InsInstitucion o where o.amie = :amie ")
					.setParameter("amie", amie)
					.getSingleResult();
			if (insInstitucion != null) {
				insInstitucion.getInsCirPar().getCodigo();
				insInstitucion.getInsCirPar().getInsCircuito().getCodigo();
				insInstitucion.getInsCirPar().getInsCircuito().getInsDistrito().getCodigo();
				insInstitucion.getInsCirPar().getInsCircuito().getInsDistrito().getCodigoSenplades();
			}
		} catch (Exception e) {
		}
		return insInstitucion;
	}

	/*
	 * (non-Javadoc)
	 * @see ec.gob.educacion.activos.dao.InstitucionDAO#findAmieByDistrito(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAmieByDistrito(String distrito) {
		List<String> amies = null;
		try {
			StringBuilder sentencia = new StringBuilder().append("select distinct(i.amie) ");
			sentencia.append("from InsInstitucion i join i.insCirPar cp join cp.insCircuito c join c.insDistrito d  ");
			sentencia.append("where d.codigoSenplades = :distrito ");
			sentencia.append("order by i.amie ");
			
			amies = em.createQuery(sentencia.toString())
					.setParameter("distrito", distrito)
					.getResultList();
		} catch (Exception e) {
		}
		return amies;
	}

}
