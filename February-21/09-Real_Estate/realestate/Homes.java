package realestate;

public class Homes {
    public static void main(String[] args) {
        Home home = new Home(60, false);
        House house = new House(200, 800);

        System.out.printf("\nЦената за това жилище е %.2f EUR.%n", home.calculatePrice(2000));
        System.out.printf("Цената за тази къща е %.2f EUR.%n", house.calculatePrice(300));

        Home blankHome = new Home();
        System.out.printf("Цената за това жилище е %.2f EUR.%n", blankHome.calculatePrice());
    }
}
