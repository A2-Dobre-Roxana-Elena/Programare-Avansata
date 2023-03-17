import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Person implements Node,Comparable<Person>{
    protected String name;
    protected Date birthDate;
    protected Map<Node, String> relationships = new HashMap<>();

    public Person(String name, Date date)
    {
        this.name=name;
        this.birthDate=date;
    }
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    public int getNumberOfRelationship(Node node) {
        return relationships.size();
    }

    @Override
    public int compareTo(Person other) {
        if(other==null) throw new NullPointerException();
        return this.name.compareTo(other.name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}