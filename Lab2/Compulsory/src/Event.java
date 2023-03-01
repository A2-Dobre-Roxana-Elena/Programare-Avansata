/**
 * Clasa 'Event' este menita sa reprezinte un eveniment cu toate caractiristicile sale:
 * numele evenimentului, numarul de persoane care vor participa,
 * ora la care incepe evenimentul cat si ora la care se termina acesta.
 */
public class Event {
    private String name;
    private int start,end,size;

    public Event() { }
    public Event(String name,int size, int  start, int end) {
        this.name = name;
        this.size=size;
        this.start=start;
        this.end=end;
    }
    /**
     * Pentru fiecare data membru au fost implementate setere.
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    /**
     * Pentru fiecare data membru au fost implementate getere.
     */
    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getSize() {
        return size;
    }
    /**
     * S-a suprascris corespunzator functia 'toString' din clasa Object
     */
    @Override
    public String toString() {
        return name;
    }
}