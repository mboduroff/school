package Company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SoleTrader extends Company {
    private String ownerName;
    private double startupCapital;
    private double currentCapital;

    static Scanner sc = new Scanner(System.in);

    public SoleTrader(String companyName, LocalDate dateCreated,
                      String bulstat, String ownerName,
                      double startupCapital, double currentCapital) {

        super(companyName, dateCreated, bulstat);
        this.ownerName = ownerName;
        this.startupCapital = startupCapital;
        this.currentCapital = currentCapital;
    }

    public SoleTrader(Company c, String ownerName,
                      double startupCapital, double currentCapital) {
        super(c.getCompanyName(), c.getDateCreated(), c.getBulstat());
        this.ownerName = ownerName;
        this.startupCapital = startupCapital;
        this.currentCapital = currentCapital;
    }

    public SoleTrader(Company c) {
        System.out.println("Моля, въведете име на собственика на фирмата: ");
        this.ownerName = sc.nextLine();
        System.out.print("Начален капитал: ");
        this.startupCapital = sc.nextDouble();
        System.out.print("Настоящ капитал: ");
        this.currentCapital = sc.nextDouble();
    }

    public SoleTrader() {
        System.out.println("Моля, въведете име на собственика на фирмата: ");
        this.ownerName = sc.nextLine();
        System.out.print("Начален капитал: ");
        this.startupCapital = sc.nextDouble();
        System.out.print("Настоящ капитал: ");
        this.currentCapital = sc.nextDouble();
    }

    public void print() {
        super.print();
        System.out.printf("%nот %s с начален капитал %.2f лв и настоящ капитал %.2f лв.%n",
                this.getOwnerName(),
                this.getStartupCapital(),
                this.getCurrentCapital());
    }

    public void analyse() {
        double endCapital = this.currentCapital - this.startupCapital;
        if (endCapital > 0)
            System.out.printf("%nКапиталът на този ЕТ е %.2f, което означава, че е на печалба.%n",
                    endCapital);
        else
            System.out.printf("%nКапиталът на този ЕТ е %.2f, което означава, че е на загуба.%n",
                    endCapital);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getStartupCapital() {
        return startupCapital;
    }

    public void setStartupCapital(double startupCapital) {
        this.startupCapital = startupCapital;
    }

    public double getCurrentCapital() {
        return currentCapital;
    }

    public void setCurrentCapital(double currentCapital) {
        this.currentCapital = currentCapital;
    }

    @Override
    public String toString() {
        return (super.toString() + String.format("%nСобственик: %s / Начален и краен капитал (лв): %.2f и %.2f",
                this.getOwnerName(),
                this.getStartupCapital(),
                this.getCurrentCapital()));
    }
}
