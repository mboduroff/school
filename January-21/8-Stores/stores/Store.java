package stores;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private String name;
    private int employeeCount;
    private List<String> goods = new LinkedList<>();
    private double drawerAmount;

    public static Scanner sc = new Scanner(System.in);

    public Store(String name, int employeeCount, List<String> goods, double drawerAmount) {
        this.name = name;
        this.employeeCount = employeeCount;
        this.goods = goods;
        this.drawerAmount = drawerAmount;

        this.printWhenEntered();
    }

    public Store(boolean silent) {
        emptyConstructor();
    }

    public Store() {
        emptyConstructor();
        this.printWhenEntered();
    }

    public void emptyConstructor() {
        System.out.printf("%n--------------< %sНов магазин%s >---------------%n",
                ANSI_GREEN, ANSI_RESET);
        System.out.println("Въведете следните свойства за новия магазин:");
        setName();
        setEmployeeCount();
        sc.nextLine();
        setGoods();
        System.out.print("Оборот (лв): ");
        this.drawerAmount = sc.nextInt();
    }

    public void printWhenEntered() {
        System.out.printf("%n%s[ВЪВЕДЕН]%s Магазин%s",
                ANSI_RED,
                ANSI_RESET,
                this);
    }

    public void deliverGoods() {
        System.out.printf("%n%n\t%s▶ %sДоставям стоки в магазин %s...%n%s",
                ANSI_GREEN, ANSI_RESET,
                this.getName(),
                ANSI_BLUE);
        this.goods.forEach(s -> System.out.println("→ " + s));
        if(this.goods.isEmpty()) {
            System.out.printf("%sНеуспешна доставка! 0%s доставени стоки.%n",
                    ANSI_RED, ANSI_RESET);
        } else {
            System.out.printf("%s%nУспешна доставка! %s доставени стоки.%n",
                    ANSI_RESET,
                    (ANSI_GREEN + this.goods.size() + ANSI_RESET));
            this.goods.clear();
        }
    }

    public void collectCash() {
        System.out.printf("%n\t%s▶%s Събирам оборот... %n",
                ANSI_GREEN, ANSI_RESET);
        if (this.drawerAmount > 0) {
            System.out.printf("Успешно събрани %s%.2f%s лв. Нов оборот: %s0.00 лв%s%n",
                    ANSI_BLUE, this.drawerAmount, ANSI_RESET,
                    ANSI_RED, ANSI_RESET);
            this.drawerAmount = 0;
        } else {
            System.out.printf("%sНеуспешно събиране на оборот.%s " +
                    "Оборотът е отрицателен: %s%.2f%s лв.%n",
                    ANSI_RED, ANSI_RESET, ANSI_RED, this.drawerAmount, ANSI_RESET);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName() {
        System.out.print("Име: ");
        String temp = sc.next();
        while (temp.isBlank()) {
            System.out.println("Невалидно име! Името не може да бъде празно.\n" +
                    "Моля, въведете ново име: ");
            temp = sc.nextLine();
        }
        this.name = temp;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public void setEmployeeCount() {
        System.out.print("Брой служители: ");
        int temp = sc.nextInt();
        while (temp < 0) {
            System.out.println("Невалидна стойност! Служителите не могат да бъдат отрицателно число.\n" +
                    "Моля, въведете нов брой служители: ");
            temp = sc.nextInt();
        }
        this.employeeCount = temp;
        System.out.print("");
    }

    public List<String> getGoods() {
        return goods;
    }

    public void setGoods(List<String> goods) {
        this.goods = goods;
    }

    public void setGoods() {
        System.out.println("Въведете стоки: ");
        System.out.println(ANSI_BLUE + "Когато искате да приключите, въведете празен ред." + ANSI_RESET);
        String temp = sc.nextLine();
        goods.add(temp);
        while (!temp.isEmpty()) {
            temp = sc.nextLine();
            goods.add(temp);
        }
        goods.remove(goods.size() - 1); // Removes the last (empty) element from the list.
    }

    public double getDrawerAmount() {
        return drawerAmount;
    }

    public void setDrawerAmount(double drawerAmount) {
        this.drawerAmount = drawerAmount;
    }

    @Override
    public String toString() {
        return String.format(": %s / Брой служители: %s / Оборот: %s%.2f%s лв / Брой стоки: %s",
                (ANSI_BLUE + this.name + ANSI_RESET),
                (ANSI_BLUE + this.employeeCount + ANSI_RESET),
                ANSI_BLUE, this.drawerAmount, ANSI_RESET,
                (ANSI_BLUE + this.goods.size()) + ANSI_RESET);
    }

    // Colours

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
}
