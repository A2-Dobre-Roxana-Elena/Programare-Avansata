import java.util.*;

public class GreedyAlgorithm {
    private Map<Student, Project> matches;

    public GreedyAlgorithm(List<Student> students, Set<Project> projects) {
        this.matches = new HashMap<>();
        match(students, projects);
    }

    private void match(List<Student> students, Set<Project> projects) {
        // sort students by the number of admissible projects
        students.sort(Comparator.comparingInt(s -> s.getAdmissibleProjects().size()));
        for (Student student : students) {
            if (!matches.containsKey(student)) {
                for(Project proj : student.getAdmissibleProjects()) {
                    if (matches.containsValue(proj))
                        continue;
//                    student.setProjectAllocated(proj);
//                    proj.setStudentAllocated(student);
                    matches.put(student, proj);
                    break;
                }
            }
        }
    }

    public Map<Student, Project> getMatches() {
        return matches;
    }

    @Override
    public String toString() {
        return matches.toString();
    }
}
