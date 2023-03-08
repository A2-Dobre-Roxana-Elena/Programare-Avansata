public class Company implements Node, Comparable<Company>{
    private String name;

    public Company(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getId() {
        return 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Company o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }

}
