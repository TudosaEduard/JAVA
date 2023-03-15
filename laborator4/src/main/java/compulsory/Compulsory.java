package compulsory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

import compulsory.objects.Project;
import compulsory.objects.Student;

public class Compulsory {
    public void main()
    {
        var students = IntStream.rangeClosed(0, 3)
                        .mapToObj(i -> new Student("S" + i) )
                        .toArray(Student[]::new);

        var projects = IntStream.rangeClosed(0, 2)
                        .mapToObj(i -> new Project("P" + i) )
                        .toArray(Project[]::new);

        List<Student> listOfStudents = new LinkedList<>();
        Set<Project> listOfProjects = new TreeSet<>();

        for (Student s : students) {
            listOfStudents.add(s);
        }
        Collections.sort(listOfStudents,((u, v) -> u.getName().compareTo(v.getName())));

        for (Project p : projects) {
            listOfProjects.add(p);
        }

        System.out.println(listOfStudents.toString());
        System.out.println(listOfProjects.toString());
    }
}
