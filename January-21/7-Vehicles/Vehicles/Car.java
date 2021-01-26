package Vehicles;

public class Car extends Vehicle {
    private String body;
    private int doorCount;

    public Car(int speed, String model, String colour, String body, int doorCount) {
        super(speed, model, colour);
        this.body = body;
        this.doorCount = doorCount;
    }

    public Car(String body, int doorCount) {
        this.body = body;
        this.doorCount = doorCount;
    }

    public Car(Vehicle v, String body, int doorCount) {
        super(v.getMaxSpeed(), v.getModel(), v.getColour());
        this.body = body;
        this.doorCount = doorCount;
    }

    public Car() {
        System.out.print("Въведете вид купе: ");
        this.body = sc.next();
        System.out.print("Въведете брой на вратите: ");
        setDoorCount();
    }

    public Car(Vehicle v) {
        super(v.getMaxSpeed(), v.getModel(), v.getColour());
        this.body = sc.next();
        setDoorCount();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public void setDoorCount() {
        int temp = sc.nextInt();
        while (temp < 0) {
            temp = sc.nextInt();
        }
        this.doorCount = temp;
    }
}
