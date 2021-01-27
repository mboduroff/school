package vehicles;

public class Garage {
    public static void main(String[] args) {
        Vehicle v = new Vehicle(220, "BMW X3", "черен");

        v.tune();
        v.showInfo();
        Car c = new Car(v, 4, 3);
        c.tune();
        c.showInfo();
    }
}
