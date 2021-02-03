package day23.model;

public class DepartmentSection {
    private String name;
    private String shortName;

    public DepartmentSection(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public DepartmentSection() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
