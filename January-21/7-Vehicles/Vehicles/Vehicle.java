package Vehicles;

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
        System.out.print("Максимална скорост: ");
        this.maxSpeed = sc.nextInt();
        System.out.print("Модел: ");
        this.model = sc.next();
        System.out.print("Цвят: ");
        this.colour = sc.next();
    }

    public void showInfo() {
        System.out.println(this);
    }

    public void tune() {
        System.out.println("Въведете нови стойности на полетата за това ППС.\n" +
                "Ако не искате да променяте някое от свойствата, оставете реда празен.");
        setSpeed();
        setModel();
        setColour();
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setSpeed() {
        System.out.print("Въведете новa скорост: ");
        String temp = sc.next();
        if (!temp.isBlank())
        this.maxSpeed = Integer.parseInt(temp);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setModel() {
        System.out.print("Въведете нов цвят: ");
        String temp = sc.next();
        if (!temp.isBlank())
        this.model = temp;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setColour() {
        System.out.print("Въведете нов цвят: ");
        String temp = sc.next();
        if (!temp.isBlank())
            this.colour = temp;
    }


    @Override
    public String toString() {
        return String.format("ППС %s: макс. скорост: %d km/h / цвят: %s ",
                this.getModel(),
                this.getMaxSpeed(),
                this.getColour());
    }
}
