package realestate;

import java.util.Scanner;

public class Home {
    private double area; // in sq.m.

    public Scanner sc = new Scanner(System.in);

    public Home(double area) {
        this.area = area;

        System.out.println("Въведено жилище: " + this);
    }

    public Home() {
        System.out.println("\n===< Ново жилище >===");
        System.out.print("Моля, въведете площта на това жилище (в кв. m): ");
        this.area = sc.nextDouble();

        System.out.println("Въведено жилище: " + this);
    }

    public double calculatePrice(double priceInEUR) {
        return this.area * priceInEUR;
    }

    public double calculatePrice() {
        System.out.print("Въведете цена за кв. m в EUR: ");
        double priceInEUR = sc.nextDouble();
        return this.area * priceInEUR;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return String.format("Жилище с площ %.1f кв. m",
                this.area);
    }
}
