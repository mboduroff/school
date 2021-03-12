package rectangle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rectangle {
    private double width;
    private double height;

    static Scanner sc = new Scanner(System.in);

    public Rectangle(double width, double height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        } else {
            System.out.println("Страните на правоъгълника не могат да бъдат отрицателни числа!");
            System.exit(1);
        }
    }

    public Rectangle() {
        System.out.println("\n===< Нов правоъгълник>===\n" +
                "Моля, въведете следните данни за този правоъгълник (в cm):");
        try {
            this.emptyConstructor();
        } catch (InputMismatchException e) {
            System.out.println("Невалиден вход! Моля, въвеждайте цели или дробни числа.");
            this.emptyConstructor();
        } catch (NumberFormatException ex) {
            System.out.println("Невалиден вход!");
            this.emptyConstructor();
        } finally {
            while (this.width <= 0 || this.height <= 0) {
                System.out.println("Страните на правоъгълника не могат да бъдат отрицателни числа!");
                this.emptyConstructor();
            }
        }
    }

    private void emptyConstructor() {
        System.out.println("Дължина: ");
        this.width = sc.nextDouble();
        System.out.println("Височина: ");
        this.height = sc.nextDouble();
    }

    public Rectangle(Rectangle r) {
        this(r.width, r.height);
    }

    public double findArea() {
        return this.height * this.width;
    }
}