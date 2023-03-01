/**
 * Laboratorul 2, Programare Avansata
 * @author Dobre Roxana-Elena
 * grupa 3A2
 */
public class Main {
    /**
     * In interiorul functiei 'Main' se regasesc initiliazate, ca in exemplul dat din cerinta data, cele 5 evenimente respectiv:
     * Events: C1(size=100, start=8, end=10), C2(size=100, start=10, end=12)
     * L1(size=30, start=8, end=10), L2(size=30, start=8, end=10), L3(size=30, start=10, end=12).
     * Va fi afisat numele fiecarui 'event'.
     */
    public static void main(String args[]) {
        Event c1 = new Event("C1", 100, 8, 10);
        System.out.println(c1);
        Event c2 = new Event("C2", 100, 10, 12);
        System.out.println(c2);
        Event l1 = new Event("L1", 30, 8, 10);
        System.out.println(l1);
        Event l2 = new Event("L2", 30, 8, 10);
        System.out.println(l2);
        Event l3 = new Event("L3", 30, 10, 12);
        System.out.println(l3);
    }
}