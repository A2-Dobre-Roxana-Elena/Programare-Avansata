import java.util.ArrayList;
import java.util.List;

/**
 * Programare Avansata,
 * Lab3, Compulsory
 * @author Dobre Roxana-Elena
 * */

public class Main {
    public static void main(String[] args) {
        List<Node> myNodes=new ArrayList<>();

        Node firstCompany=new Company("Amazon");
        myNodes.add(firstCompany);

        Node firstPerson=new Person("Matei");
        Node secondPerson=new Person("Marian");
        myNodes.add(firstPerson);
        myNodes.add(secondPerson);

        System.out.println(myNodes);
    }
}