package homework.objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admissible {
    private Map<Student, List<Project>> prefMap = new HashMap<>();

    public Admissible() {}

    public Map<Student, List<Project>> getPrefMap() {
        return prefMap;
    }

    public void setPrefMap(Map<Student, List<Project>> prefMap) {
        this.prefMap = prefMap;
    }

    public void addPrefMap(Student student, List<Project> projectList)
    {
        prefMap.put(student, projectList);
    }

    @Override
    public String toString() {
        return "Admissible [prefMap=" + prefMap + "]";
    }
    
}
