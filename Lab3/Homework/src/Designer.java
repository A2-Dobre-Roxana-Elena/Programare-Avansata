import java.util.Date;

public class Designer extends Person {
    private String favouriteArtPiece;

    public Designer(String name, Date date, String artPiece) {
        super(name, date);
        this.favouriteArtPiece = artPiece;
    }

    public void setFavouriteArtPiece(String favouriteArtPiece) {
        this.favouriteArtPiece = favouriteArtPiece;
    }

    public String getFavouriteArtPiece() {
        return favouriteArtPiece;
    }
}