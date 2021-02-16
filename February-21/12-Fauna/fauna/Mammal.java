package fauna;

public class Mammal {
    private boolean hasFur;
    private String region;

    public Mammal(boolean hasFur, String region) {
        this.hasFur = hasFur;
        this.region = region;
    }

    public Mammal() {
        super();
        System.out.println("New mammal, based on");
        System.out.println(super.toString());
        System.out.println("Does this mammal have fur?");

    }

    public boolean hasFur() {
        return hasFur;
    }

    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }

    public void setHasFur() {
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
