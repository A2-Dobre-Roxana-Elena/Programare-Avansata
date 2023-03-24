import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private Project projectAllocated = new Project("");

    private List<Project> admissibleProjects = new ArrayList<>();


    public Student(String name) {
        this.name = name;
    }

    public Student(String name, List<Project> admissibleProjects) {
        this.name = name;
        this.admissibleProjects = admissibleProjects;
    }

    public String getName() {
        return name;
    }

    public Project getProjectAllocated() {
        return projectAllocated;
    }

    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectAllocated(Project projectAllocated) {
        this.projectAllocated = projectAllocated;
    }

    public void setAdmissibleProjects(List<Project> admissibleProjects) {
        this.admissibleProjects = admissibleProjects;
    }

    @Override
    public int compareTo(Student o) {
        if(o==null) throw new NullPointerException();
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", projectAllocated=" + projectAllocated +
                ", admissibleProjects=" + admissibleProjects +
                '}';
    }
}