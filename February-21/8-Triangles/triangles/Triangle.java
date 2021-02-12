package triangles;

import java.util.Scanner;

public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    static Scanner sc = new Scanner(System.in);

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;

        System.out.println("Въведен: " + this + "\n");
    }

    public Triangle() {
        System.out.println("===< Нов триъгълник >===");
        System.out.println("Въведете страна a:");
        this.sideA = sc.nextDouble();
        System.out.println("Въведете страна b:");
        this.sideB = sc.nextDouble();
        System.out.println("Въведете страна c:");
        this.sideC = sc.nextDouble();

        System.out.println("Въведен: " + this);
    }

    public double findArea() {
        double p = this.sideA + this.sideB + this.sideC;
        return Math.sqrt(p * (p - this.sideA) * (p - this.sideB) * (p - this.sideC));
    }

    public static double findArea(double base, double height) {
        return 0.5 * base * height;
    }

    public static double findArea(double side) {
        return ((Math.sqrt(3)/4) * (side * side));
    }

    public static double findArea(double sideA, double sideB, double sideC) {
        double p = sideA + sideB + sideC;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    public static double findArea(double sideA, double sideB, int angleC) {
        return (sideA * sideB)/2 * Math.sin(Math.toRadians(angleC));
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    @Override
    public String toString() {
        return String.format("Триъгълник със страни a: %.1f cm, b: %.1f cm, c: %.1f cm е с лице: %.2f кв. cm.",
                this.sideA,
                this.sideB,
                this.sideC,
                this.findArea());
    }
}
