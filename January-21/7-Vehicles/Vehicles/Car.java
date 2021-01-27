package Vehicles;

public class Car extends Vehicle {
    private int passengerCount;
    private int wheelCount;

    public Car(int speed, String model, String colour, int passengerCount, int wheelCount) {
        super(speed, model, colour);
        this.passengerCount = passengerCount;
        this.wheelCount = wheelCount;
        System.out.println("[ВЪВЕДЕН АВТОМОБИЛ] " + this);
    }

    public Car(int passengerCount, int wheelCount) {
        this.passengerCount = passengerCount;
        this.wheelCount = wheelCount;
        System.out.println("[ВЪВЕДЕН АВТОМОБИЛ] " + this);
    }

    public Car(Vehicle v, int passengerCount, int wheelCount) {
        super(v.getMaxSpeed(), v.getModel(), v.getColour());
        System.out.println("Въвеждам автомобил по модел от: \n" +
                super.toString());
        this.passengerCount = passengerCount;
        this.wheelCount = wheelCount;
        System.out.println("[ВЪВЕДЕН АВТОМОБИЛ] " + this);
    }

    public Car() {
        System.out.print("Въведете брой на пътниците: ");
        setPassengerCount();
        System.out.print("Въведете брой на колелата: ");
        setWheelCount();
        System.out.println("[ВЪВЕДЕН АВТОМОБИЛ] " + this);
    }

    public Car(Vehicle v) {
        super(v.getMaxSpeed(), v.getModel(), v.getColour());
        System.out.println("Въвеждам автомобил по модел от: \n" +
                super.toString());
        System.out.print("Въведете брой на пътниците: ");
        this.passengerCount = sc.nextInt();
        System.out.print("Въведете брой на колелата: ");
        setWheelCount();
        System.out.println("[ВЪВЕДЕН АВТОМОБИЛ] " + this);
    }

    public void tune() {
        System.out.printf("%n<Променям %s...>%n", this);
        System.out.println("Въведете нови стойности на полетата за този автомобил.\n" +
                "Ако не искате да променяте някое от свойствата, оставете реда празен.");
        changeWheelCount();
        changePassengerCount();
    }

    public void showInfo() {
        System.out.println(this);
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public void setPassengerCount() {
        System.out.print("Въведете брой на пътниците: ");
        int temp = sc.nextInt();
        while (temp <= -1) {
            System.out.println("Невалидна стойност! Моля, въведете неотрицателен брой на пътниците: ");
            temp = sc.nextInt();
        }
        this.passengerCount = temp;
    }

    public void changePassengerCount() {
        System.out.print("Въведете новия брой на пътниците: ");
        String temp = sc.nextLine();
        if (!temp.isBlank())
            setPassengerCount(Integer.parseInt(temp));
    }

    public void changeWheelCount() {
        System.out.print("Въведете новия брой на колелата: ");
        String temp = sc.nextLine();
        if (!temp.isBlank())
            setWheelCount(Integer.parseInt(temp));
    }


    public int getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    public void setWheelCount() {
        System.out.print("Въведете брой на колелата: ");
        int temp = sc.nextInt();
        while (temp < 0) {
            System.out.print("Невалидна стойност! Моля, въведете положителен брой на колелата: ");
            temp = sc.nextInt();
        }
        this.wheelCount = temp;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" / бр. пътници: %d / брой колела: %d",
                this.passengerCount,
                this.wheelCount);
    }
}
