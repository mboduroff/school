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

        System.out.println("\nEnter the websites you'd like to visit: (separated by a space)");
        String[] websites = sc.nextLine().split("\\s+");
        for (String website : websites) {
            smartphone.browse(website.trim());
        }

        System.out.println("\nEnter the numbers you'd like to call: (separated by a space)");
        String[] phoneNumbers = sc.nextLine().split("\\s+");
        for (String number : phoneNumbers) {
            smartphone.call(number.trim());
        }
    }

}
