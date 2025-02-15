package es.albarregas.daoFactory;

import es.albarregas.dao.GenericoDao;
import es.albarregas.dao.IGenericoDao;

/**
 *
 * @author Maria
 */
public class MySQLDAOFactory extends DAOFactory {  

    @Override
    public IGenericoDao getGenericoDao() {
        return new GenericoDao();
    }

}
