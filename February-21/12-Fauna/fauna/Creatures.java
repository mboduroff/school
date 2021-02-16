package fauna;

import java.util.Scanner;

abstract class Creatures {
    private int age;
    private double sizeInCm;

    static Scanner sc = new Scanner(System.in);

    public Creatures(int age, double sizeInCm) {
        this.age = age;
        this.sizeInCm = sizeInCm;

        System.out.println("[Entered] " + this);
    }

    public Creatures() {
        System.out.println("\t===< New creature >===");
        System.out.println("Please enter the following properties of this creature:");
        System.out.print("Age: ");
        this.age = sc.nextInt();
        System.out.print("Size (in cm): ");
        this.sizeInCm = sc.nextDouble();
        System.out.println("[Entered] " + this);
    }

    abstract String printInfo();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSizeInCm() {
        return sizeInCm;
    }

    public void setSizeInCm(double sizeInCm) {
        this.sizeInCm = sizeInCm;
    }

    @Override
    public String toString() {
        return String.format("Creature: age: %d y. | size: %.1f cm",
                this.getAge(),
                this.getSizeInCm());

    }
}
