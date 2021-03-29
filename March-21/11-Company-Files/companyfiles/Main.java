package companyfiles;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Employee> company = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        String temp = sc.nextLine();
        while (!temp.equals("0|0|0")) {
            String[] tokens = temp.split("\\|");

            try {
                company.add(new Employee(tokens[0],
                        Double.parseDouble(tokens[1]), tokens[2]));
            } catch (NumberFormatException e) {
                System.out.println("Грешка! Вторият аргумент трябва да бъде число.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Грешка! Недостатъчно аргументи.");
            }

            temp = sc.nextLine();
        }

        System.out.println("\n\tКрай на въвеждането." +
                "\n= = = = = = = = =\n");

        try (PrintWriter out = new PrintWriter("\\employees.txt")) {
            for (Employee employee : company) {
                out.println(employee);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файлът не е открит!");
        }

        company.forEach(System.out::println);
    }
}
