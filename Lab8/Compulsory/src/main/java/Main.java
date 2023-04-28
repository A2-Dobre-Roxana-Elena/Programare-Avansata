import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            
            var genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            Database.getConnection().commit();

            var album = new AlbumDAO();
            album.create( 1979, "The Wall", "Pink Floyd", "Rock");
            //findByName
            System.out.println(album.findByName("The Wall"));
            album.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop" );
            Database.getConnection().commit();

            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM albums");
            while (rs.next()) {
                int id = rs.getInt("id");
                int releaseYear = rs.getInt("release_year");
                String title = rs.getString("title");
                String artist = rs.getString("artist");
                String genre = rs.getString("genre");
                System.out.println(id + "\t" + releaseYear + "\t" + title + "\t" + artist + "\t" + genre);
            }
            rs.close();
            stmt.close();
            con.close();
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            //Database.rollback();
        }
    }

}