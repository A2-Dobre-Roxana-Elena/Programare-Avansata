import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Network myNodes=new Network();

        Person programmer = new Programmer("Bogdan",  new Date(2001,07,20), "Python");
        Person designer = new Designer("Ana", new Date(2002,6,22), "Mona Lisa");

        programmer.addRelationship(designer,"friend");

        Node firstCompany=new Company("Amazon");

        programmer.addRelationship(firstCompany,"employee");

        myNodes.addNode(programmer);
        myNodes.addNode(designer);
        myNodes.addNode(firstCompany);

        System.out.println(myNodes);
        System.out.println(programmer.getRelationships());
        System.out.println(programmer.getNumberOfRelationship(programmer));
    }
}