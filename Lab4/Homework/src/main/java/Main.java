import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("S0", Arrays.asList(new Project("P0"), new Project("P1"), new Project("P2"))),
                new Student("S1", Arrays.asList(new Project("P0"), new Project("P1"))),
                new Student("S2", List.of(new Project("P0"))),
                new Student("S3", List.of(new Project("P0")))
        );
        LinkedList<Student> studentsList=new LinkedList<>(students);
        Collections.sort(studentsList);
        System.out.println("The students are"+ studentsList);

        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i) )
                .toArray(Project[]::new);
        TreeSet<Project> projectsSet=new TreeSet<>(Arrays.stream(projects).toList());

        System.out.println("The projects are:");
        projectsSet.stream().sorted().forEach(p-> System.out.println(p.getName()));

        System.out.println("Students that have a number of preferences lower than the average number of preferences");
        double averageNumberOfPreferences = students.stream()
                .mapToInt(student -> student.getAdmissibleProjects().size())
                .average()
                .orElse(0.0);

        List<Student> studentsWithPreferencesLower = students.stream()
                .filter(student -> student.getAdmissibleProjects().size() < averageNumberOfPreferences)
                .collect(Collectors.toList());

        System.out.println(studentsWithPreferencesLower);

        GreedyAlgorithm algorithm=new GreedyAlgorithm(students,projectsSet);
        System.out.println("The Solution of the problem is:");
        System.out.println(algorithm);


        //using JavaFaker
        Faker faker = new Faker();
        List<Student> studs = new ArrayList<>();
        Set<Project> projs = new TreeSet<>();
        List<Project> admissibleProjects=new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String name = faker.name().fullName();
            String nameProject = faker.lorem().word();
            Project project = new Project(nameProject);
            projs.add(project);
            admissibleProjects.add(project);
            Student student = new Student(name, admissibleProjects);
            studs.add(student);
        }
        System.out.println("The new Projects are ");
        System.out.println(projs);
        System.out.println("The new Students are ");
        System.out.println(studs);
    }
}