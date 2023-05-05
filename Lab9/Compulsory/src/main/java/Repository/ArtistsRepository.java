package Repository;

import Entity.Artists;
import Entity.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class ArtistsRepository extends DataRepository<Artists, Integer> {
    private EntityManagerFactory em;


    public List<Artists> findByName(String name) {
//        return em.createNamedQuery("Album.findByName")
//                .setParameter("name", name)
//                .getResultList();
        return new ArrayList<>();
    }

}
