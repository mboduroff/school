package Airport;

import java.util.Scanner;

public class Passenger {
    private String name;

    static Scanner sc = new Scanner(System.in);

    public Passenger(String name) {
        this.name = name;
    }

    public Passenger() {
        this.name = sc.nextLine();
    }

    public void print() {
        System.out.printf("Пасажер %s",
                this.getName());
    }

//    Getters and setters below this line.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Пасажер: %s",
                this.getName());
    }
}
