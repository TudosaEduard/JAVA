package homework.objects;

public class Project implements Comparable<Project> {
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Project [name=" + name + "]";
    }

    @Override
    public int compareTo(Project other) {
        if (this == other)
            return 0;
        if (other == null)
            return 1;
        return this.name.compareTo(other.name);
    }

}
