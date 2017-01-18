package ec.gob.educacion.activos.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import ec.gob.educacion.activos.exception.EducacionDeleteException;
import ec.gob.educacion.activos.exception.EducacionPersistException;
import ec.gob.educacion.activos.exception.EducacionUpdateException;

/**
*
* @author Vimeworks Cia. Ltda.
*/
public interface GenericDAO<T, ID extends Serializable> {

    public T findById(ID id);

    public List<T> findAll();

    public List<T> findByNamedQuery(String queryName, Object... params);

    public List<T> findByNamedQueryAndNamedParams(String queryName, Map<String, ? extends Object> params);

    public T update(T entity) throws EducacionUpdateException;

    public void delete(T entity) throws EducacionDeleteException;

    public void delete(ID id) throws EducacionDeleteException;

    public void persist(T entity) throws EducacionPersistException;
	
}
