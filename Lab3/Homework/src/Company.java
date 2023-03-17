public class Company implements Node, Comparable<Company> {
    private String name;
    private Integer numberOfEmployees;
    public Company(String name) {
        this.name = name;
    }

    public Company(String name, Integer numberOfEmployees) {
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", numberOfEmployees=" + numberOfEmployees +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Company other) {
        if(other==null) throw new NullPointerException();
        return this.name.compareTo(other.name);
    }

}