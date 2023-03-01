/**
 * Laboratorul 2, Programare Avansata
 * @author Dobre Roxana-Elena
 * grupa 3A2
 */
public class Main {
    public static void main(String[] args) {

        Location c1 = new Location();
        c1.setName("Iași");
        c1.setX(0.0);
        c1.setY(0.0);
        c1.setType(LocationType.CITY);
        System.out.println(c1);

        Location c2 = new Location("Vaslui", 10.0, 20.0);
        System.out.println(c2);

        Location c3 = new Location("Bacau", 11.0, 22.0, LocationType.CITY);
        System.out.println(c3);

        Road r1 = new Road("D24", RoadType.EXPRESS, c1, c2);
        System.out.println(r1);

        Road r2= new Road();
        r2.setName("D22");
        r2.setType(RoadType.COUNTRY);
        System.out.println(r2);
    }
}