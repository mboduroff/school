package Gift;

import java.util.*;

public class Gift {
    private String giftContent;
    private String recipient;
    private String occasion;
    private double price;
    private double weight;

    static Scanner sc = new Scanner(System.in);

    public Gift(String giftContent, String recipient, String occasion, double price, double weight) {
        this.giftContent = giftContent;
        this.recipient = recipient;
        this.occasion = occasion;
        this.price = price;
        this.weight = weight;
    }

    public Gift() {
        System.out.println("=== НОВ ПОДАРЪК ===");
        System.out.println("Какъв е Вашият подарък?");
        this.giftContent = sc.nextLine();
        System.out.println("Кой е получателят на Вашия подарък?");
        this.recipient = sc.nextLine();
        System.out.println("Какъв е поводът за Вашия подарък?");
        this.occasion = sc.nextLine();
        System.out.println("На каква цена е Вашият подарък?");
        this.price = sc.nextDouble();
        System.out.println("Колко тежи Вашият подарък? (kg)");
        this.weight = sc.nextDouble();

    }

    public void getInfo() {
        System.out.printf("Подаръкът %s е за %s по повод %s и е на цена %.2f лв.%n",
                giftContent, recipient, occasion, price);
    }

    public Gift findMoreExpensive(Gift g) {
        if (g.getPrice() < this.getPrice())
            return this;
        else
            return g;
    }

    public Gift findLessExpensive(Gift g) {
        if (g.getPrice() > this.getPrice())
            return this;
        else
            return g;
    }

    public Gift findHeavier(Gift g) {
        if (g.getWeight() < this.getWeight())
            return this;
        else
            return g;
    }

    public Gift findLighter(Gift g) {
        if (g.getWeight() > this.getWeight())
            return this;
        else
            return g;
    }

    public boolean checkForPhone() {
        if (this.getGiftContent().toLowerCase().contains("телефон"))
            return true;
        return false;
    }

    public boolean checkForCar() {
        if (this.getGiftContent().toLowerCase().contains("кола") ||
                this.getGiftContent().toLowerCase().contains("автомобил"))
            return true;
        return false;
    }

    public static List<Gift> sortGiftsByPrice(List<Gift> list) {
        list.sort(Comparator.comparing(Gift::getPrice));
        return list;
    }

    public String getGiftContent() {
        return giftContent;
    }

    public void setGiftContent(String giftContent) {
        this.giftContent = giftContent;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format(getGiftContent());
    }
}