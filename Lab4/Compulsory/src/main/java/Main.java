import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args)
    {
        LinkedList<Student> students = (LinkedList<Student>)Stream.of(
                new Student("S3"),
                new Student("S2"),
                new Student("S1")).collect(Collectors.toCollection(LinkedList::new));

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student p1, Student p2) {
                return p1.compareTo(p2);
            }
        });

        System.out.println("Students:");
        for(Student student : students)
            System.out.println(student.getName());

        TreeSet<Project> projects = Stream.of(
                new Project("P2"),
                new Project("P0"),
                new Project("P1")).collect(Collectors.toCollection(TreeSet::new));

        System.out.println("Projects:");
        for (Project project : projects)
        {
            System.out.println(project.getName());
        }

    }
}