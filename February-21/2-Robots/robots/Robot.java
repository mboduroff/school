package robots;

import java.util.Scanner;

public class Robot {
    private String name;
    private int xCoords = 0;
    private int yCoords = 0;

    private int lookingAt = 0;
    static Scanner sc = new Scanner(System.in);

    public Robot(String name) {
        this.name = name;
    }

    // TODO create method printing the walked distance

    public void moveLeft() {
        xCoords -= 1;
    }

    public void moveRight() {
        xCoords += 1;
    }

    public void moveUp() {
        yCoords += 1;
    }

    public void moveDown() {
        yCoords -= 1;
    }

    public void turnLeft() {
        turn90Deg();
        System.out.println("Завъртях се наляво.");
    }

    public void turnRight() {
        turn90Deg();
        System.out.println("Завъртях се надясно.");
    }

    private void turn90Deg() {
        if(lookingAt < 4)
            lookingAt = 0;
        else
            lookingAt++;

        int temp = this.xCoords;
        this.xCoords = this.yCoords;
        this.yCoords = temp;
    }

    public String getCoords() {
        return String.format("(%d; %d)",
                this.xCoords,
                this.yCoords);
    }

    public double findDistanceFromHome() {
        return Math.round(Math.sqrt(Math.pow(this.xCoords, 2) + Math.pow(this.yCoords, 2)) * 100);
    }

    public void menu() {
        System.out.println("\n⦿  М Е Н Ю  ⦿");
        String line = "";
        while (!line.equals("0")) {
            System.out.println(); // TODO enter menu items
            switch (sc.next().trim()) {
                default:
                    System.out.println("Неразпозната команда. Моля, опитайте отново.");
                    menu();
                    break;
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    this.moveLeft();
                    break;
                case "2":
                    this.moveRight();
                    break;
                case "3":
                    this.moveUp();
                    break;
                case "4":
                    this.moveDown();
                    break;
                case "5":
                    System.out.println("Настоящите координати са: " + getCoords());
                    break;
            }
            line = sc.next().trim();
        }
    }

}
