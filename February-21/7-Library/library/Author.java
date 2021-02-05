package library;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Author {
    private String name;
    private LocalDate born;
    private boolean alive;
    private LocalDate died;

    static Scanner sc = new Scanner(System.in);

    public Author(String name, LocalDate born, boolean alive, LocalDate died) {
        this.name = name;
        this.born = born;
        this.alive = alive;
        if(!alive) {
            this.died = died;
        } else
            this.died = null;
    }

    public Author() {
        System.out.println("===< Нов автор >===");
        System.out.println("Име:");
        this.name = sc.nextLine();
        System.out.println("Роден:");
        this.born = this.setDate();
        setAlive();
        if(!alive) {
            System.out.println("Починал: ");
            this.died = this.setDate();
        } else
            this.died = null;
    }

    public LocalDate setDate() {
        System.out.print("Ден от месеца: ");
        int dd = sc.nextInt();
        while (dd < 1 || dd > 31) {
            System.out.println("Моля, въведете валидни стойности за ден от месеца (1 - 31): ");
            dd = sc.nextInt();
        }
        System.out.print("Месец: ");
        int mm = sc.nextInt();
        while (mm < 1 || mm > 12) {
            System.out.println("Моля, въведете валиден месец (1 - 12): ");
            mm = sc.nextInt();
        }
        System.out.print("Година: ");
        int yyyy = sc.nextInt();
        int currentYear = LocalDate.now().getYear();
        while (yyyy > currentYear) {
            System.out.println("Моля, въведете валидна година! Не може датата на създаване да бъде в бъдещето.\n" +
                    "Опитайте отново: ");
            yyyy = sc.nextInt();
        }
        return LocalDate.of(yyyy, mm, dd);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setAlive() {
        boolean temp;
        char c = sc.next().toLowerCase().charAt(0);
        while (c != 'д' && c != 'н' && c != 'y' && c != 'd' && c != 'n') {
            System.out.print("Невалиден отговор. Моля, въведете \"да\" или \"не\": ");
            c = sc.next().toLowerCase().charAt(0);
        }
        this.alive = c != 'n' && c != 'н';
    }

    public LocalDate getDied() {
        return died;
    }

    public void setDied(LocalDate died) {
        this.died = died;
    }

    @Override
    public String toString() {
        return String.format("Автор %s, роден %s г.%s",
                this.name,
                this.born.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                String.format("%s",
                        this.alive ? "" : String.format(", починал %s г. (на %d г.)",
                                this.died.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                                Period.between(this.born, this.died).getYears()))
                        );
    }
}
