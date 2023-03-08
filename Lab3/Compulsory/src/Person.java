import java.util.HashMap;
import java.util.Map;

public class Person implements Node, Comparable<Person> {
    private String name;
    private Map<Node, String> relationships = new HashMap<>();

    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Map<Node, String> relationships) {
        this.name = name;
        this.relationships = relationships;
    }
    public Map<Node, String> getRelationships() {
        return relationships;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return 0;
    }

    public void setRelationships(Map<Node, String> relationships) {
        this.relationships = relationships;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", relationships=" + relationships +
                '}';
    }

}