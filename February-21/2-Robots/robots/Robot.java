package robots;

import java.util.Scanner;

public class Robot {
    private String name;

    private int xCoords = 0;
    private int yCoords = 0;
    private int walkedDistance = 0;

    static Scanner sc = new Scanner(System.in);

    public Robot(String name) {
        this.name = name;
    }

    public void moveLeft() {
        xCoords++;
        walkedDistance++;
        System.out.printf("%sУспешно направих стъпка наляво.%s%n",
                ANSI_BLUE, ANSI_RESET);
    }

    public void moveRight() {
        xCoords++;
        walkedDistance++;
        System.out.printf("%sУспешно направих стъпка надясно.%s%n",
                ANSI_BLUE, ANSI_RESET);
    }

    public void moveForwards() {
        yCoords++;
        walkedDistance++;
        System.out.printf("%sУспешно направих стъпка напред.%s%n",
                ANSI_BLUE, ANSI_RESET);
    }

    public void moveBackwards() {
        yCoords--;
        walkedDistance++;
        System.out.printf("%sУспешно направих стъпка назад.%s%n",
                ANSI_BLUE, ANSI_RESET);
    }

    public void turnLeft() {
        turn90Deg();
        System.out.printf("%sЗавъртях се наляво.%s%n",
                ANSI_BLUE, ANSI_RESET);
    }

    public void turnRight() {
        turn90Deg();
        System.out.printf("%sЗавъртях се надясно.%s%n",
                ANSI_BLUE, ANSI_RESET);
    }

    private void turn90Deg() {
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
        return Math.round(
                (Math.sqrt(
                        Math.pow(this.xCoords, 2) + Math.pow(this.yCoords, 2))
                ) *100 / 100);
    }



    public void menu() {
        System.out.println("\n⦿  М Е Н Ю  ⦿");
        String line = "";
        while (!line.equals("0")) {
            System.out.println("1. Стъпка наляво\n" +
                    "2. Стъпка надясно\n" +
                    "3. Стъпка напред\n" +
                    "4. Стъпка назад\n" +
                    "5. Завърти се наляво\n" +
                    "6. Завърти се надясно\n" +
                    "7. Виж настоящите координати\n" +
                    "8. Виж изминатото разстояние\n" +
                    "9. Виж разстоянието от началото\n" +
                    "0. Изход\n");
            System.out.print("→ Избор: ");
            switch (sc.next().trim()) {
                default:
                    System.out.printf("%sНеразпозната команда. Моля, опитайте отново.%s%n",
                            ANSI_RED, ANSI_RESET);
                    menu();
                    break;
                case "0":
                    System.out.println("Благодаря Ви, че използвахте програмата! :)");
                    System.out.println(this);
                    System.exit(0);
                    break;
                case "1":
                    this.moveLeft();
                    menu();
                    break;
                case "2":
                    this.moveRight();
                    menu();
                    break;
                case "3":
                    this.moveForwards();
                    menu();
                    break;
                case "4":
                    this.moveBackwards();
                    menu();
                    break;
                case "5":
                    turnLeft();
                    menu();
                    break;
                case "6":
                    turnRight();
                    menu();
                    break;
                case "7":
                    System.out.printf("%sНастоящите координати са: %s%n",
                            ANSI_BLUE,
                            (ANSI_RED + getCoords() + ANSI_RESET));
                    menu();
                    break;
                case "8":
                    System.out.printf("%sИзминатото разстояние е %s стъпки.%s%n",
                            ANSI_BLUE,
                            (ANSI_RED + this.walkedDistance + ANSI_BLUE),
                            ANSI_RESET);
                    menu();
                    break;
                case "9":
                    System.out.printf("%sРазстоянието от началото (0; 0) е: %s%.1f%s%n",
                            ANSI_BLUE, ANSI_RED,
                            findDistanceFromHome(),
                            ANSI_RESET);
                    menu();
                    break;
            }
            line = sc.next().trim();
        }
    }

    @Override
    public String toString() {
        return String.format("Роботът %s е изминал %d стъпки досега и вмомента се намира на координати %s.",
                this.name,
                this.walkedDistance,
                this.getCoords());
    }

    // Colours

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

}
