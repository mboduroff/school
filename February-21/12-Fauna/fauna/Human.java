package fauna;

public class Human extends Mammal {
    private String name;
    private String eyeColour;

    public Human(boolean hasFur, String region, String name, String eyeColour) {
        super(hasFur, region);
        this.name = name;
        this.eyeColour = eyeColour;
    }

    public Human(int age, double sizeInCm, boolean hasFur, String region, String name, String eyeColour) {
        super(age, sizeInCm, hasFur, region);
        this.name = name;
        this.eyeColour = eyeColour;
    }

    public Human(String name, String eyeColour) {
        this.name = name;
        this.eyeColour = eyeColour;
    }

    public Human() {
        System.out.println("\n===< New human >===");
        System.out.println("Name:");
        this.name = sc.nextLine();
        System.out.println("Eye colour:");
        this.eyeColour = sc.nextLine();
    }

    @Override
    String getInfo() {
        return super.getInfo() + String.format("%nName: %s | Eye colour: %s%n",
                this.getName(),
                this.getEyeColour());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }
}
