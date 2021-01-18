package Products;

import java.util.Scanner;

public class ElectricalAppliance extends Product {
    private double voltage = 230; // standard for the EU
    private double power;

    private final double timeUsed = 24 * 0.4; // Calculations estimated for 40% usage

    public static double priceOfElectricity = 0.22238; // EVN's prices for daytime usage

    static Scanner sc = new Scanner(System.in);

    public ElectricalAppliance(String description, double price, double weight, double voltage, double power) {
        super(description, price, weight);
        setVoltage(voltage);
        setPower(power);
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public ElectricalAppliance(Product p, double voltage, double power) {
        super(p.getDescription(), p.getPrice(), p.getWeight());
        setVoltage(voltage);
        setPower(power);
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public ElectricalAppliance(Product p) {
        super(p.getDescription(), p.getPrice(), p.getWeight());
        System.out.println("\n===: Нов електроуред :===\n" +
                "(към " + p + ")");
        setVoltage();
        setPower();
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public ElectricalAppliance(double voltage, double power) {
        setVoltage(voltage);
        setPower(power);
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public ElectricalAppliance() {
        setVoltage();
        setPower();
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public double calculateCosts() {
        double costs = this.power / 1000 * timeUsed * priceOfElectricity;
        System.out.printf("Средният разход за този електроуред е %.2f лв/ден.", costs);
        return costs;
    }

    public void print() {
        super.print();
        System.out.printf("Той работи под напрежение от %.1f V и е с мощност %.1f W.%n",
                this.getVoltage(),
                this.getPower());
    }

    // Getters and setters below this line. Data validation implemented.

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        while (voltage < 0) {
            System.out.println("Не може напрежението да е отрицателно число!\n" +
                    "Въведете ново напрежение (V): ");
            voltage = sc.nextDouble();
        }
        this.voltage = voltage;
    }

    public void setVoltage() {
        System.out.print("Моля, въведете напрежението на уреда (V): ");
        double voltage = sc.nextDouble();
        while (voltage < 0) {
            System.out.println("Не може напрежението да е отрицателно число!\n" +
                    "Въведете ново напрежение (V): ");
            voltage = sc.nextDouble();
        }
        this.voltage = voltage;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        while (power < 0) {
            System.out.println("Не може мощността да е отрицателно число!\n" +
                    "Въведете нова мощност (W): ");
            power = sc.nextDouble();
        }
        this.power = power;
    }

    public void setPower() {
        System.out.print("Моля, въведете мощността на уреда (W): ");
        double power = sc.nextDouble();
        while (power < 0) {
            System.out.println("Не може мощността да е отрицателно число!\n" +
                    "Въведете нова мощност (W): ");
            power = sc.nextDouble();
        }
        this.power = power;
    }

    public static double getPriceOfElectricity() {
        return priceOfElectricity;
    }

    public void setPriceOfElectricity(double priceOfElectricity) {
        while(priceOfElectricity < 0) {
            System.out.println("Цената не може да бъде отрицателно число.\n" +
                    "Въведете нова цена: ");
            priceOfElectricity = sc.nextDouble();
        }
        ElectricalAppliance.priceOfElectricity = priceOfElectricity;
    }

    public void setPriceOfElectricity() {
        System.out.println("Моля, въведете нова цена на електроенергията (лв): ");
        double priceOfElectricity = sc.nextDouble();
        while(priceOfElectricity < 0) {
            System.out.println("Цената не може да бъде отрицателно число.\n" +
                    "Въведете нова цена: ");
            priceOfElectricity = sc.nextDouble();
        }
        ElectricalAppliance.priceOfElectricity = priceOfElectricity;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" / Напрежение:  %.1f V / Мощност: %.1f W.",
                this.getVoltage(),
                this.getPower());
    }
}
