package vehicles;

import java.util.Scanner;

public class Vehicle {
    private int maxSpeed;
    private String model;
    private String colour;

    static Scanner sc = new Scanner(System.in);

    public Vehicle(int maxSpeed, String model, String colour) {
        this.maxSpeed = maxSpeed;
        this.model = model;
        this.colour = colour;
    }

    public Vehicle() {
        System.out.println("--< Ново превозно средство >--\n" +
                "Моля, въведете следните свойства на това ППС:");
        System.out.print("Максимална скорост (km/h): ");
        setMaxSpeed();
        System.out.print("Модел: ");
        setModel();
        System.out.print("Цвят: ");
        this.colour = sc.next();
        System.out.println("[ВЪВЕДЕНО ППС] " + this);
    }

    public void showInfo() {
        System.out.println(this);
    }

    public void tune() {
        System.out.printf("%n<Променям %s...>%n", this.toString());
        System.out.println("Въведете нови стойности на полетата за това ППС.\n" +
                "Ако не искате да променяте някое от свойствата, оставете реда празен.");
        changeMaxSpeed();
        changeModel();
        changeColour();
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void changeMaxSpeed() {
        System.out.print("Въведете новa скорост (km/h): ");
        String temp = sc.nextLine();
        if (!temp.isBlank())
        setMaxSpeed(Integer.parseInt(temp));
    }

    public void setMaxSpeed() {
        System.out.print("Въведете скорост (km/h): ");
        int temp = sc.nextInt();
        while (temp < 0) {
            System.out.println("Невалидна стойност! Скоростта трябва да бъде положително число.");
            temp = sc.nextInt();
        }
            this.maxSpeed = temp;
    }

    public void setMaxSpeed(int temp) {
        while (temp < 0) {
            System.out.println("Невалидна стойност! Скоростта трябва да бъде положително число.");
            temp = sc.nextInt();
        }
        this.maxSpeed = temp;
    }

    public String getModel() {
        return model.trim();
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void changeModel() {
        System.out.print("Въведете нов модел: ");
        String temp = sc.nextLine();
        if (!temp.isBlank())
            this.model = temp;
    }

    public void setModel() {
        System.out.print("Въведете нов модел: ");
        this.model = sc.next();
    }

    public String getColour() {
        return colour.trim();
    }

    public void changeColour(String colour) {
        this.colour = colour;
    }

    public void changeColour() {
        System.out.print("Въведете нов цвят: ");
        String temp = sc.nextLine();
        if (!temp.isBlank())
            this.colour = temp;
    }


    @Override
    public String toString() {
        return String.format("ППС %s: макс. скорост: %d km/h / цвят: %s",
                this.getModel(),
                this.getMaxSpeed(),
                this.getColour());
    }
}
