package fauna;

public class Cat extends Mammal {
    private String name;
    private String breed;

    public Cat(boolean hasFur, String region, String name, String breed) {
        super(hasFur, region);
        this.name = name;
        this.breed = breed;
    }

    public Cat(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public Cat() {
        System.out.println("===< New cat >===");
        System.out.println("Name:");
        this.name = sc.nextLine();
        System.out.println("Breed: ");
        this.breed = sc.nextLine();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    String getInfo() {
        return super.getInfo() + String.format("%nName: %s | Breed: %s",
                this.getName(),
                this.getBreed());
    }
}
