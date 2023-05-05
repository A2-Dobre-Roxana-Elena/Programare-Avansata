package Repository;

import Entity.Artists;
import Entity.EntityManagerFactory;
import Entity.Genres;

import java.util.ArrayList;
import java.util.List;

public class GenresRepository extends DataRepository<Genres, Integer> {
    private EntityManagerFactory em;


    public List<Artists> findByName(String name) {
//        return em.createNamedQuery("Genres.findByName")
//                .setParameter("name", name)
//                .getResultList();
        return new ArrayList<>();
    }

}
