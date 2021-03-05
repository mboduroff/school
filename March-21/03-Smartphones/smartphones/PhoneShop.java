package smartphones;

import java.util.Scanner;

public class PhoneShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Smartphone smartphone = new Smartphone();

        smartphone.browse("aol.com");
        smartphone.browse("g00gle.com");

        smartphone.call("0888888888");
        smartphone.call("08888888B8");

        System.out.println("\nEnter a website you'd like to visit:");
        smartphone.browse(sc.nextLine().trim());

        System.out.println("\nEnter a number you'd like to call:");
        smartphone.call(sc.nextLine().trim());
    }

}
