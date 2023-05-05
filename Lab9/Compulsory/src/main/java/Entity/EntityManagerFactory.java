package Entity;

import javax.persistence.EntityManager;
import java.security.Signature;

public class EntityManagerFactory {
    public <T extends AbstractEntity> void persist(T entity) {
    }

    public EntityManager createEntityManager() {

    }
}
