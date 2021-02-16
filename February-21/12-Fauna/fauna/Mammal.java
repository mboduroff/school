package fauna;

public class Mammal extends Creature {
    private boolean hasFur;
    private String region;

    public Mammal(boolean hasFur, String region) {
        this.hasFur = hasFur;
        this.region = region;
    }

    public Mammal() {
        super();
        System.out.println("Creating new mammal, based on");
        System.out.println(super.toString());
        setHasFur();
        setRegion();
    }

    public boolean hasFur() {
        return hasFur;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }

    public void setHasFur() {
        System.out.println("Does this mammal have fur?");
        System.out.print("→ ");
        char c = sc.next().charAt(0);
        while(c != 't' && c != 'f' && c != 'y' && c != 'n') {
            System.out.println("Invalid answer. Please try again, using one of these words:\n" +
                    "\"yes\", \"no\", \"true\" or \"false\"\n");
            System.out.print("→ ");
            c = sc.next().charAt(0);
        }

        setHasFur(c == 't' || c == 'y');
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setRegion() {
        System.out.println("In which region does this mammal live?");
        String temp = sc.nextLine();
        while (temp.isBlank()) {
            System.out.println("Invalid answer. Please try again.\n"
             + "In which region does this mammal live?");
        }
        this.region = temp;
    }

    void printInfo() {
        System.out.println(this.getInfo());
    }

    String getInfo() {
        return String.format("Size: %.1f | Age: %d y.%n" +
                        "Fur: %s | Region: %s",
                this.getSizeInCm(),
                this.getAge(),
                this.hasFur() ? "yes" : "no",
                this.getRegion());
    }
}
