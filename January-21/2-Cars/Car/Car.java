package Car;

import java.util.*;

public class Car {
    private String manufacturer;
    private String model;
    private String colour;
    private int engineDisplacement;
    private double price;
    private int yearProduced;

    static Scanner sc = new Scanner(System.in);

    Car(String manufacturer, String model, String colour,
               int engineDisplacement, double price, int yearProduced) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.colour = colour;
        this.engineDisplacement = engineDisplacement;
        this.price = price;
        this.yearProduced = yearProduced;

        System.out.print("[ВЪВЕДЕНА КОЛА] " + this);
    }

    Car() {
        System.out.println("=== НОВА КОЛА ===");
        System.out.print("Марка: ");
        this.manufacturer = sc.next().trim();
        System.out.print("Модел: ");
        this.model = sc.next().trim();
        System.out.print("Цвят: ");
        this.colour = sc.next().trim();
        System.out.print("Обем на двигателя: ");
        this.engineDisplacement = sc.nextInt();
        System.out.print("Цена: ");
        this.price = sc.nextInt();
        System.out.print("Година на производство: ");
        this.yearProduced = sc.nextInt();

        System.out.print("[ВЪВЕДЕНА КОЛА] " + this);
    }

    public static void filterCarsByManufacturer(String query) {
        System.out.println("=== Всички коли от марка " + query + ": ===");
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getManufacturer().toLowerCase().equals(query.toLowerCase().trim()))
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterCarsByManufacturer() {
        System.out.print("Въведете марка, по която да филтрирам: ");
        String query = sc.next().toLowerCase().trim();
        System.out.println("=== Всички коли от марка " + query + ": ===");
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getManufacturer().toLowerCase().equals(query))
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterCarsByPriceRange(double min, double max) {
        System.out.printf("=== Всички коли на цени между %.2f и %.2f са: ===", min, max);
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getPrice() > min && Cars.carList.get(i).getPrice() < max)
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterCarsByPriceRange() {
        System.out.print("\nМоля, въведете долна граница за цените: ");
        double min = sc.nextDouble();
        System.out.print("Моля, въведете горна граница за цените: ");
        double max = sc.nextDouble();
        System.out.printf("=== Всички коли на цени между %.2f и %.2f са: ===", min, max);
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getPrice() > min && Cars.carList.get(i).getPrice() < max)
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterByColour(String query) {
        System.out.println("\n=== Всички коли от цвят " + query + ": ===");
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getColour().toLowerCase().equals(query))
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterByColour() {
        System.out.print("\nМоля, въведете цвят, по който да филтрирам: ");
        String query = sc.next().toLowerCase().trim();
        System.out.println("=== Всички коли от цвят " + query + ": ===");
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getColour().toLowerCase().equals(query))
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterByProductionYear(int query) {
        System.out.println("=== Всички коли, произведени през " + query + " г. са: ===");
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getYearProduced() == query)
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterByProductionYear() {
        System.out.print("Моля, въведете година на производство, по която да филтрирам: ");
        int query = sc.nextInt();
        System.out.println("=== Всички коли, произведени през " + query + " г. са: ===");
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getYearProduced() == query)
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void sortByManufacturer() {
        System.out.println("\nМоля, въведете в какъв ред да бъде сортиран списъкът:\n" +
                "A (ascending), В (възходящ) или D (descending), Н (низходящ)");
        char c = sc.next().toLowerCase().charAt(0);
        if (c == 'а' || c == 'a' || c == 'b' || c == 'в')
            sortAscending();
        else if(c == 'd' || c == 'н' || c == 'h' || c == 'д')
            sortDescending();
        else {
            System.out.println("Грешка! Невалиден избор.");
            sortByManufacturer();
        }
    }

    private static List<Car> sortAscending() {
        Cars.carList.sort(Comparator.comparing(c -> c.getManufacturer()));
        System.out.println("=== Всички коли подредени във възходящ ред по марка: ===");
        Cars.carList.forEach(System.out::print);
        System.out.println();
       return Cars.carList;
    }

    private static List<Car> sortDescending() {
        Cars.carList.sort(Comparator.comparing(c -> c.getManufacturer()));
        Collections.reverse(Cars.carList);
        System.out.println("=== Всички коли подредени в низходящ ред по марка ===");
        Cars.carList.forEach(System.out::print);
        System.out.println();
        return Cars.carList;
    }

    public double calculateTaxes() {
        double taxes = 0;
        taxes += (getEngineDisplacement() * 0.2);
        if (this.yearProduced >= 2010)
            taxes += 50;
        else if (this.yearProduced >= 2001)
            taxes += 60;
        else
            taxes += 70;
        System.out.printf("Данъкът за тази кола е %.2f лв.", taxes);
        return taxes;
    }

    public static double calculateTaxes(Car c) {
        double taxes = 0;
        taxes += (c.getEngineDisplacement() * 0.2);
        if (c.yearProduced >= 2010)
            taxes += 50;
        else if (c.yearProduced > 2001)
            taxes += 60;
        else
            taxes += 70;
        System.out.printf("%nДанъкът за тази кола е %.2f лв.", taxes);
        return taxes;
    }

    @Override
    public String toString() {
        return String.format("%s %s в цвят %s, произведена %d г. с обем на двигателя %d куб. м. на цена %.2f лв.%n",
                this.manufacturer, this.model, this.colour,
                this.yearProduced, this.engineDisplacement, this.price);
    }

    //Getters and Setters below this line

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(int engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearProduced() {
        return yearProduced;
    }

    public void setYearProduced(int yearProduced) {
        this.yearProduced = yearProduced;
    }
}