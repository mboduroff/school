package electronics;

import java.util.Scanner;

public class ElectronicDevice {
    private int powerSupplyVoltage;
    private String CPUmodel;

    private boolean powered;

    public static Scanner sc = new Scanner(System.in);

    public ElectronicDevice(int powerSupplyVoltage, String CPUmodel) {
        this.powerSupplyVoltage = powerSupplyVoltage;
        this.CPUmodel = CPUmodel;
    }

    public ElectronicDevice() {
        System.out.println("---< Ново електронно устройство >---");
        System.out.println("Моля, въведете следните свойства за това електронно у-во:");
        System.out.print("Напрежение на захранването (V): ");
        this.powerSupplyVoltage = sc.nextInt();
        System.out.print("Модел на процесора: ");
        this.CPUmodel = sc.next();
    }

    public void turnOn() {
        if(powered)
            System.out.println("Електронното у-во вече е включено!");
        else {
            System.out.println("Включих електронното устройство.");
            powered = true;
        }
    }

    public void turnOff() {
        if(powered) {
            System.out.println("Изключих електронното устройство.");
            powered = false;
        } else
            System.out.println("У-вото вече е изключено.");
    }

    public int getPowerSupplyVoltage() {
        return powerSupplyVoltage;
    }

    public void setPowerSupplyVoltage(int powerSupplyVoltage) {
        this.powerSupplyVoltage = powerSupplyVoltage;
    }

    public String getCPUmodel() {
        return CPUmodel;
    }

    public void setCPUmodel(String CPUmodel) {
        this.CPUmodel = CPUmodel;
    }

    @Override
    public String toString() {
        return String.format("Ел. устр.: Напрежение %d V / Процесор модел: %s ",
                this.powerSupplyVoltage,
                this.CPUmodel);
    }
}
