import java.util.Objects;

public class Project implements Comparable<Project>{
    private String name;
    private Student studentAllocated = null;

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, Student owner) {
        this.name = name;
        this.studentAllocated = owner;
    }

    public String getName() {
        return name;
    }

    public Student getStudentAllocated() {
        return studentAllocated;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setStudentAllocated(Student studentAllocated) {
        this.studentAllocated = studentAllocated;
    }

    @Override
    public int compareTo(Project o) {
        if(o==null) throw new NullPointerException();
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) && Objects.equals(studentAllocated, project.studentAllocated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studentAllocated);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", studentAllocated=" + studentAllocated +
                '}';
    }
}