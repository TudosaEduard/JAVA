package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;

import homework.objects.Admissible;
import homework.objects.Project;
import homework.objects.Student;

public class Homework {
    private Map<Student, List<Project>> prefMap = new HashMap<>();

    public void main() {

        Faker faker = new Faker();

        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student(faker.name().lastName()))
                .toArray(Student[]::new);

        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project(faker.name().firstName()))
                .toArray(Project[]::new);

        List<Student> listOfStudents = new LinkedList<>();
        Set<Project> listOfProjects = new TreeSet<>();

        for (Student s : students) {
            listOfStudents.add(s);
        }
        Collections.sort(listOfStudents, ((u, v) -> u.getName().compareTo(v.getName())));

        for (Project p : projects) {
            listOfProjects.add(p);
        }

        // System.out.println(listOfStudents.toString());
        // System.out.println(listOfProjects.toString());

        var assigned = new Admissible();
        assigned.addPrefMap(students[0], Arrays.asList(projects[0], projects[1], projects[2]));
        assigned.addPrefMap(students[1], Arrays.asList(projects[0], projects[1]));
        assigned.addPrefMap(students[2], Arrays.asList(projects[0]));

        double avgPrefs = assigned.getPrefMap().values().stream()
                .mapToInt(List::size)
                .average()
                .orElse(0.0);

        Map<Student, List<Project>> filteredMap = assigned.getPrefMap().entrySet().stream()
                .filter(entry -> entry.getValue().size() < avgPrefs)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // filteredMap.forEach((stud, proj) -> {
        // System.out.println(stud.toString() + " preferences:" + proj.toString());
        // });

        greedyAlg(assigned);

    }

    public void greedyAlg(Admissible assigned) {
        prefMap = assigned.getPrefMap();
        System.out.println(prefMap.toString());
        while (!prefMap.isEmpty()) {
            Student minStudent = null;
            int minSize = Integer.MAX_VALUE;

            for (Map.Entry<Student, List<Project>> entry : prefMap.entrySet()) {
                if (entry.getValue().size() < minSize) {
                    minStudent = entry.getKey();
                    minSize = entry.getValue().size();
                }
            }

            if(minStudent != null && prefMap.get(minStudent).size() > 0)
            {
                System.out.print(minStudent.toString() + " preference: " + prefMap.get(minStudent).get(0));
                System.out.println("\n");

                Project projectRemove = prefMap.get(minStudent).get(0);
                List<Student> keys = new ArrayList<>(prefMap.keySet());
                for(Student student : keys)
                {
                    List<Project> copy = new ArrayList<>(prefMap.get(student));
                    copy.remove(projectRemove);
                    prefMap.put(student, copy);
                }
                prefMap.remove(minStudent);
            }
            else
            {
                System.out.println("Algoritmul greedy nu a putut gasi o solutie valida.");
                return;
            }
        }
    }
}
