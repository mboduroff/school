package Car;

import org.jetbrains.annotations.NotNull;

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

        System.out.print("✓ [ВЪВЕДЕНА КОЛА] " + this);
    }

    Car() {
        System.out.println("► НОВА КОЛА ◄");
        System.out.print("Марка: ");
        this.manufacturer = sc.next().trim();
        System.out.print("Модел: ");
        this.model = sc.next().trim();
        System.out.print("Цвят: ");
        this.colour = sc.next().trim();
        System.out.print("Обем на двигателя (куб. см): ");
        this.engineDisplacement = sc.nextInt();
        while (this.engineDisplacement < 0) {
            System.out.print("Обемът на двигателя не може да бъде отрицателно число!" +
                    " Моля, въведете нов обем: ");
            this.engineDisplacement = sc.nextInt();
        }
        System.out.print("Цена (лв): ");
        this.price = sc.nextInt();
        while (this.price < 0) {
            System.out.print("Цената не може да бъде отрицателно число!" +
                    " Моля, въведете нова цена: ");
            this.price = sc.nextInt();
        }
        System.out.print("Година на производство: ");
        this.yearProduced = sc.nextInt();
        while (this.yearProduced < 0) {
            System.out.print("Годината на производство не може да бъде отрицателно число!" +
                    " Моля, въведете нова цена: ");
            this.yearProduced = sc.nextInt();
        }
        System.out.print("✓ [ВЪВЕДЕНА КОЛА] " + this);
    }

    public static void mainMenu() {
        System.out.println("\n⦿  М Е Н Ю  ⦿");
        String line = "";
        while (!line.equals("0")) {
            System.out.println("1. Нов автомобил\n" +
                    "2. Справка по марка\n" +
                    "3. Справка по ценови диапазон\n" +
                    "4. Справка по цвят\n" +
                    "5. Справка по година на производство\n" +
                    "6. Подреждане\n" +
                    "7. Изчисляване на данък\n" +
                    "8. Търсене по зададени параметри\n" +
                    "9. Изтрий дубликати\n" +
                    "0. Изход\n");
            System.out.print("→ Избор: ");
            switch (sc.next().trim()) {
                default:
                    System.out.println("Неразпозната команда. Моля, опитайте отново.");
                    mainMenu();
                    break;
                case "1":
                    Cars.carList.add(new Car());
                    mainMenu();
                    break;
                case "2":
                    filterByManufacturer();
                    continueOrNot();
                    break;
                case "3":
                    filterByPriceRange();
                    continueOrNot();
                    break;
                case "4":
                    filterByColour();
                    continueOrNot();
                    break;
                case "5":
                    filterByProductionYear();
                    continueOrNot();
                    break;
                case "6":
                    sortByManufacturer();
                    continueOrNot();
                    break;
                case "7":
                    calculateTaxes(new Car());
                    continueOrNot();
                    break;
                case "8":
                    searchByParameters();
                    continueOrNot();
                    break;
                case "9":
                    purgeDuplicates();
                    continueOrNot();
                    break;
                case "0":
                    System.out.println("Благодаря Ви, че използвахте програмата! :)");
                    System.exit(0);
            }
            line = sc.next().trim();
        }
    }

    // Methods below this line

    public static void continueOrNot() {
        System.out.println("Желаете ли да продължите?");
        System.out.print("→ Избор: ");
        char c = sc.next().toLowerCase().charAt(0);
        if (c == 'д' || c == 'y' || c == 'd' || c == 'ъ')
            mainMenu();
        else if(c == 'н' || c == 'n') {
            System.out.println("Благодаря Ви, че използвахте програмата! :)");
            System.exit(0);
        }
        else {
            System.out.println("Неразпозната команда. Моля, опитайте отново с \"да\", \"не\", \"yes\" или \"no\".");
            System.out.print("→ Избор: ");
        }
    }

    public static void searchByParameters() {
        System.out.println("Моля, въведете параметри по които да търсите:");
        System.out.print("→ Марка: ");
        String manufacturerQuery = sc.next().trim().toLowerCase();
        System.out.print("→ Година на производство: ");
        int yearQuery = sc.nextInt();
        System.out.print("→ Цвят: ");
        String colourQuery = sc.next().trim().toLowerCase();

        System.out.println("\nТърся...\n");
        for (int i = 0; i < Cars.carList.size(); i++) {
            Car c = Cars.carList.get(i);
            if (c.getManufacturer().toLowerCase().equals(manufacturerQuery)
                    && c.getYearProduced() == yearQuery
                    && c.getColour().toLowerCase().equals(colourQuery)) {
                System.out.println("Открито попадение: ");
                System.out.println(c);
            }
        }
    }

    public static void purgeDuplicates() {
        System.out.println("\nТърся дубликати...\n");
        for (int i = 0; i < Cars.carList.size(); i++) {
            Car c = Cars.carList.get(i);
            for (int j = 0; j < Cars.carList.size(); j++) {
                Car c1 = Cars.carList.get(j);
                if(c != c1) {
                    if(c.getManufacturer().equals(c1.getManufacturer())) {
                        if (c.getModel().equals(c1.getModel())) {
                            if (c.getEngineDisplacement() == c1.getEngineDisplacement()) {
                                if(c.getYearProduced() == c1.getYearProduced()) {
                                    if (c.getColour().equals(c1.getColour())) {
                                        if(c.getPrice() == c1.getPrice()) {
                                            System.out.println("Открит дубликат! Изтривам следния автомобил: ");
                                            System.out.println(c);
                                            Cars.carList.remove(c);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void filterByManufacturer(String query) {
        System.out.println("✱ Всички коли от марка " + query + ": ✱");
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getManufacturer().toLowerCase().equals(query.toLowerCase().trim()))
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterByManufacturer() {
        System.out.print("Въведете марка, по която да филтрирам: ");
        String query = sc.next().toLowerCase().trim();
        System.out.println("✱ Всички коли от марка " + query + ": ✱");
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getManufacturer().toLowerCase().equals(query))
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterByPriceRange(double min, double max) {
        System.out.printf("✱ Всички коли на цени между %.2f лв и %.2f лв са: ✱%n", min, max);
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getPrice() >= min && Cars.carList.get(i).getPrice() <= max)
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterByPriceRange() {
        System.out.print("\nМоля, въведете долна граница за цените: ");
        double min = sc.nextDouble();
        System.out.print("Моля, въведете горна граница за цените: ");
        double max = sc.nextDouble();
        System.out.printf("✱ Всички коли на цени между %.2f лв и %.2f лв са: ✱%n", min, max);
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getPrice() > min && Cars.carList.get(i).getPrice() < max)
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterByColour(String query) {
        System.out.println("\n✱ Всички коли от цвят " + query + ": ✱");
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getColour().toLowerCase().equals(query))
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterByColour() {
        System.out.print("\nМоля, въведете цвят, по който да филтрирам: ");
        String query = sc.next().toLowerCase().trim();
        System.out.println("✱ Всички коли от цвят " + query + ": ✱");
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getColour().toLowerCase().equals(query))
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterByProductionYear(int query) {
        System.out.println("✱ Всички коли, произведени през " + query + " г. са: ✱");
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getYearProduced() == query)
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void filterByProductionYear() {
        System.out.print("Моля, въведете година на производство, по която да филтрирам: ");
        int query = sc.nextInt();
        System.out.println("✱ Всички коли, произведени през " + query + " г. са: ✱");
        for (int i = 0; i < Cars.carList.size(); i++) {
            if (Cars.carList.get(i).getYearProduced() == query)
                System.out.print(Cars.carList.get(i));
        }
        System.out.println();
    }

    public static void sortByManufacturer() {
        System.out.println("\nМоля, въведете в какъв ред да бъде сортиран списъкът:\n" +
                "↑ A (ascending), В (възходящ) или ↓ D (descending), Н (низходящ)");
        System.out.print("→ Избор: ");
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
        System.out.println("✱ Всички коли подредени във възходящ (↑) ред по марка: ✱");
        Cars.carList.forEach(System.out::print);
        System.out.println();
       return Cars.carList;
    }

    private static List<Car> sortDescending() {
        Cars.carList.sort(Comparator.comparing(c -> c.getManufacturer()));
        Collections.reverse(Cars.carList);
        System.out.println("✱ Всички коли подредени в низходящ (↓) ред по марка ✱");
        Cars.carList.forEach(System.out::print);
        System.out.println();
        return Cars.carList;
    }

    public double calculateTaxes() {
        double taxes = 0;
        taxes += (this.getEngineDisplacement() * 0.2);
        if (this.yearProduced >= 2010)
            taxes += 50;
        else if (this.yearProduced >= 2001)
            taxes += 60;
        else
            taxes += 70;
        System.out.printf("Данъкът за тази кола е %.2f лв.%n", taxes);
        return taxes;
    }

    public static double calculateTaxes(@NotNull Car c) {
        double taxes = 0;
        taxes += (c.getEngineDisplacement() * 0.2);
        if (c.yearProduced >= 2010)
            taxes += 50;
        else if (c.yearProduced > 2001)
            taxes += 60;
        else
            taxes += 70;
        System.out.printf("Данъкът за тази кола е %.2f лв.%n", taxes);
        return taxes;
    }

    @Override
    public String toString() {
        return String.format("%s %s в цвят %s, произведена %d г. с обем на двигателя %d куб. см. на цена %.2f лв.%n",
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