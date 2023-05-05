package Repository;

import Entity.Albums;
import Entity.Artists;
import Entity.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class AlbumsRepository extends DataRepository<Albums, Integer> {
    private EntityManagerFactory em;

    public List<Albums> findByArtist(Artists artist) {
//        return em.createNamedQuery("Album.findByArtist")
//                .setParameter("artist", artist)
//                .getResultList();
        return new ArrayList<>();
    }

    public List<Albums> findByName(String name) {
//        return em.createNamedQuery("Album.findByName")
//                .setParameter("name", name)
//                .getResultList();
        return new ArrayList<>();
    }

    public List<Albums> findByYearRelease(Integer year) {
//        return em.createNamedQuery("Album.findByYearRelease")
//                .setParameter("year", year)
//                .getResultList();
        return new ArrayList<>();
    }


}
