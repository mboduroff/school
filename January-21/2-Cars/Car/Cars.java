package Car;

import java.util.ArrayList;
import java.util.List;

import static Car.Car.*;

public class Cars {
    public static List<Car> carList = new ArrayList<>();
    public static void main(String[] args) {
        //Manufacturer, model, colour, engine displacement, price, year produced
        Car c = new Car("Chevrolet", "Tacuma", "червен",
                1600, 10000, 2019);
        carList.add(c);

        Car c1 = new Car("Audi", "A2", "сребрист",
                1400, 4000, 1999);
        carList.add(c1);
        Car c2 = new Car("Chevrolet", "Orlando", "кафяв",
                1400, 14000, 2014);
        carList.add(c2);

        Car c3 = new Car("Toyota", "Prius", "син",
                1800, 30000, 2016);
        carList.add(c3);

        Car c4 = new Car("BMW", "X3", "син",
                1000, 100000, 2019);
        carList.add(c4);

        carList.add(new Car());

        filterByColour();
        sortByManufacturer();
        c4.calculateTaxes();
        calculateTaxes(c1);
    }
}
