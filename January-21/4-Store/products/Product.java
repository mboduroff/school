package products;

import java.util.Scanner;

public class Product {
    private String description;
    private double price;
    private double weight;

    static Scanner sc = new Scanner(System.in);

    public Product(String description, double price, double weight) {
        this.description = description;
        this.price = price;
        this.weight = weight;
    }

    public Product(String description, double price, double weight, boolean quiet) {
        this.description = description;
        this.price = price;
        this.weight = weight;

        if (!quiet)
            System.out.println("[ВЪВЕДЕН] " + this);
    }

    public Product() {
        System.out.println("===: Нов продукт :===");
        System.out.print("Описание: ");
        this.description = sc.nextLine();
        System.out.print("Цена (лв): ");
        setPrice();
        System.out.print("Тегло (kg): ");
        setWeight();
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public void print() {
        System.out.printf("%nПродуктът %s е на цена %.2f лв и тежи %.3f kg. ",
                this.getDescription(),
                this.getPrice(),
                this.getWeight());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
        else {
            while (price > 0) {
                System.out.println("Цената не може да бъде отрицателно число.\n" +
                        "Моля, въведете нова цена: ");
                price = sc.nextDouble();
            }
            this.price = price;
        }
    }

    public void setPrice() {
        double price = sc.nextDouble();
        if (price > 0)
            this.price = price;
        else {
            while (price < 0) {
                System.out.println("Цената не може да бъде отрицателно число.\n" +
                        "Моля, въведете нова цена: ");
                price = sc.nextDouble();
            }
            this.price = price;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0)
            this.weight = weight;
        else {
            while (weight > 0) {
                System.out.println("Теглото не може да бъде отрицателно число.\n" +
                        "Моля, въведете ново тегло: ");
                weight = sc.nextDouble();
            }
            this.weight = price;
        }    }

    public void setWeight() {
        double weight = sc.nextDouble();
        if (weight > 0)
            this.weight = weight;
        else {
            while (weight < 0) {
                System.out.println("Теглото не може да бъде отрицателно число!\n" +
                        "Моля, въведете ново тегло: ");
                weight = sc.nextDouble();
            }
            this.weight = weight;
        }
    }

    @Override
    public String toString() {
        return String.format("Продукт: %s / Цена: %.2f лв / Тегло: %.3f kg",
                this.getDescription(),
                this.getPrice(),
                this.getWeight());
    }
}
