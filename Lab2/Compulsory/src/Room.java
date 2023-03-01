import java.util.Objects;
/**
 * Clasa 'Room' este menita sa reprezinte un sala a facultatii, avand urmatoarele caracteristici:
 * nume, tipul (ce se regaseste in 'RoomType') si capacitatea (numarul maxim de persoane ce pot incapea in sala);
 */
public class Room {
    private String name;
    private RoomType type;
    private int cap;
    public Room(String name, RoomType type) {
        this.name = name;
        this.type = type;
    }
    /**
     * Pentru fiecare data membru au fost implementate setere.
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }
    /**
     * Pentru fiecare data membru au fost implementate getere.
     */
    public String getName() {
        return name;
    }

    public RoomType getType() {
        return type;
    }

    public int getCap() {
        return cap;
    }

    /**
     * S-au suprascris corespunzator functiile 'equals' si 'toString' din clasa Object
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Room)) {
            return false;
        }
        Room other = (Room) obj;
        return name.equals(other.name);
    }

    public String toString() {
        return name;
    }
}
