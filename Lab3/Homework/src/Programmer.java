import java.util.Date;

public class Programmer extends Person {
    private String favouriteProgrammingLanguage;
    public Programmer(String name, Date date, String programmingLanguage) {
        super(name, date);
        this.favouriteProgrammingLanguage = programmingLanguage;
    }

    public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
        this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
    }

    public String getFavouriteProgrammingLanguage() {
        return favouriteProgrammingLanguage;
    }
}