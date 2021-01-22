package Company;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Employee {
    private String name;
    private String position;
    private int age;
    private double salary;

    static Scanner sc = new Scanner(System.in);

    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public Employee(String name, String position, int age, double salary) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.salary = salary;
        System.out.println("✓ [ВЪВЕДЕН] " + this);
    }

    public Employee() {
        System.out.println("\n---< Нов служител >---");
        System.out.print("Име: ");
        this.name = sc.nextLine().trim();
        System.out.print("Заемана длъжност: ");
        this.position = sc.nextLine().trim();
        System.out.print("Възраст (г.): ");
        this.age = sc.nextInt();
        System.out.print("Заплата (лв): ");
        this.salary = sc.nextDouble();
        System.out.println("✓ [ВЪВЕДЕН] " + this);

    }

    public static void filterByJobPosition(String query) {
        System.out.println("\n===: Филтрирам по позиция " + ANSI_RED + query + ANSI_RESET + " :===");
        for (int i = 0; i < Company.list.size(); i++) {
            if(Company.list.get(i).getPosition().equalsIgnoreCase(query)) {
                System.out.println(Company.list.get(i));
            }
        }
    }

    public static void filterByJobPosition() {
        System.out.println("\n===: Филтриране :===");
        System.out.println("Моля, въведете позиция по която да филтрирам: ");
        System.out.print("→ ");
        String query = sc.next().trim();
        System.out.println("===: Филтрирам по позиция " + ANSI_RED + query + ANSI_RESET + " :===");
        for (int i = 0; i < Company.list.size(); i++) {
            if(Company.list.get(i).getPosition().toLowerCase().equalsIgnoreCase(query)) {
                System.out.println(Company.list.get(i));
            }
        }
    }

    public static void filterBySalaryRange(double min, double max) {
        System.out.printf("\n===: Филтрирам по диапазон на заплатите от %s%.2f%s лв до %s%.2f%s лв :===%n",
                ANSI_RED, min, ANSI_RESET,
                ANSI_RED, max, ANSI_RESET);

        for (int i = 0; i < Company.list.size(); i++) {
            if(Company.list.get(i).getSalary() >= min && Company.list.get(i).getSalary() <= max) {
                System.out.println(Company.list.get(i));
            }
        }
    }

    public static void filterBySalaryRange() {
        System.out.println("\n===: Филтриране :===");
        System.out.println("Моля, въведете следните данни, по които да филтрирам:");
        System.out.print("Минимална заплата (лв): ");
        double min = sc.nextDouble();
        System.out.print("Максимална заплата (лв): ");
        double max = sc.nextDouble();

        System.out.printf("\n===: Филтрирам по диапазон на заплатите от %s%.2f%s лв до %s%.2f%s лв :===%n",
                ANSI_RED, min, ANSI_RESET,
                ANSI_RED, max, ANSI_RESET);

        for (int i = 0; i < Company.list.size(); i++) {
            if(Company.list.get(i).getSalary() >= min && Company.list.get(i).getSalary() <= max) {
                System.out.println(Company.list.get(i));
            }
        }
    }

    public static List<Employee> sortBySalary() {
        Company.list.sort(Comparator.comparing(employee -> employee.getAge()));
        System.out.println("\n===: Всички служители, подредени по възраст (↑) :===");
        Company.list.forEach(System.out::println);
        return Company.list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Служител %s: Възраст: %d г. / Позиция: %s / Заплата: %.2f лв",
                this.getName(),
                this.getAge(),
                this.getPosition(),
                this.getSalary());
    }
}
