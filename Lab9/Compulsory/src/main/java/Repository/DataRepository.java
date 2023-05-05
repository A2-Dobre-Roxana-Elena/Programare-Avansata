package Repository;

import Entity.AbstractEntity;
import Entity.EntityManagerFactory;

import java.io.Serializable;


public abstract class DataRepository
        <T extends AbstractEntity, ID extends Serializable> {
    private EntityManagerFactory em;
//    public T findById(ID id) {
//    }
    public boolean persist(T entity) {
        try {
            beginTransaction();
            em.persist(entity);
           // commit();
            return true;
        } catch (Exception e) {
            handleException(e);
            //rollback();
        }
        return false;
    }

    private void handleException(Exception e) {
    }

    private void beginTransaction() {

    }


}

