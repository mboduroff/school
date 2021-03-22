package studentfiles;

public class Student {
    private String name;
    private int ageInYears;

    public Student(String name, int ageInYears) {
        this.name = name;
        this.ageInYears = ageInYears;
    }

    void print() {
        System.out.println(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears(int ageInYears) {
        this.ageInYears = ageInYears;
    }

    @Override
    public String toString() {
        return String.format("%s %d",
                this.getName(),
                this.getAgeInYears());
    }
}
