import java.sql.*;

public class AlbumDAO {
    public void create(int release_year, String title, String artist, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums ( release_year, title, artist, genre) values (?,?,?,?)")) {
            pstmt.setInt(1, release_year);
            pstmt.setString(2, title);
            pstmt.setString(3, artist);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where id ='" + id + "'")) {
            return String.valueOf(rs.next() ? rs.getInt(1) : null);
        }
    }

}
