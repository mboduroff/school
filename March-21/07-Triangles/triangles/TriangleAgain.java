package triangles;

import java.util.InputMismatchException;
import java.util.Scanner;

class TriangleAgain {
    private double sideA;
    private double sideB;
    private int angleGamma;

    static Scanner sc = new Scanner(System.in);

    public TriangleAgain(double sideA, double sideB, int angleGamma) {
        if (sideA <= 0 || sideB <= 0 || angleGamma <= 0) {
            System.err.println("Грешка! Мерките не могат да бъдат отрицателни числа.");
        } else {
            this.sideA = sideA;
            this.sideB = sideB;
            this.angleGamma = angleGamma;
        }
    }

    public TriangleAgain() {
        System.out.println("===< Нов триъгълник >===\n" +
                "Моля, въведете следните мерки на триъгълника: ");
        System.out.println("Страна а (cm): ");

        double a = 0, b = 0;
        int gamma = 0;

        try {
            a = sc.nextDouble();
            System.out.println("Страна b (cm): ");
            b = sc.nextDouble();
            System.out.println("Ъгъл гама (градуса): ");
            gamma = sc.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Грешка! Ъгълът трябва да е цяло число.");
        } catch (InputMismatchException e) {
            System.out.println("Грешка! Моля, въвеждайте само числа.");
        } finally {
            if (sideA <= 0 || sideB <= 0 || angleGamma <= 0) {
                System.out.println("Грешка! Мерките не могат да бъдат отрицателни числа.");
            } else {
                this.sideA = a;
                this.sideB = b;
                this.angleGamma = gamma;
            }
        }
    }

    void printArea() {
        double sideC = Math.sqrt(
                Math.pow(this.sideA, 2) + Math.pow(this.sideB, 2)
                - 2 * this.sideA * this.sideB *
                Math.cos(Math.toRadians(this.angleGamma))
        );

        double p = (this.sideA + this.sideB + sideC) / 2;

        double S = Math.sqrt(p * (p - this.sideB) * (p - this.sideB) * (p - sideC));

        if (S == 0) {
            System.err.println("Такава фигура не съществува.");
        } else
            System.out.println(S);
    }
}
