package es.albarregas.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Maria
 */
public interface IGenericoDao<T>{

    public void insertOrUpdate(T objeto);

    public <T> List<T> selectAll(Class<T> claseEntidad);

    public <T> T getById(Serializable pk, Class<T> claseEntidad);

    public void delete(T objeto);
}
