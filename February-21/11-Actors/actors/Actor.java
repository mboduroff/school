package actors;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class Actor {
    private String name;
    private LocalDate born;
    private LocalDate died;
    private String fieldOfWork;
    private String actorType;

    static Scanner sc = new Scanner(System.in);

    abstract double calculateSalary();
    abstract double calculateSalary(double hourlyPay, int workedHours);

    public Actor(String name, LocalDate born, LocalDate died, String fieldOfWork, String actorType) {
        this.name = name;
        this.born = born;
        this.died = died;
        this.fieldOfWork = fieldOfWork;
        this.actorType = actorType;
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public Actor(String name, LocalDate born, String fieldOfWork, String actorType) {
        this.name = name;
        this.born = born;
        this.died = null;
        this.fieldOfWork = fieldOfWork;
        this.actorType = actorType;

        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public Actor(String actorType) {
        this.actorType = actorType;
        System.out.println("===< Нов " + this.actorType + " >===\n" +
                "\tВъведете следните данни за този актьор:");
        System.out.println("Имена: ");
        this.name = sc.nextLine();
        System.out.println("\tДата на раждане:");
        this.born = setDate();
        if (!setAlive()) {
            System.out.println("\tКога е починал "+ this.name + " ?");
            this.died = setDate();
        }
        else this.died = null;
        testDates();
        sc.nextLine();
        System.out.println("Какъв вид актьор е " + this.name + "?");
        this.fieldOfWork = sc.nextLine();
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    LocalDate setDate() {
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
            System.out.println("Моля, въведете валидна година! Не може датата да бъде в бъдещето.\n" +
                    "Опитайте отново: ");
            yyyy = sc.nextInt();
        }
        return LocalDate.of(yyyy, mm, dd);
    }

    void testDates() {
        if(this.died != null) {
            if(this.died.isBefore(this.born)) {
                throw new IllegalArgumentException("Грешка! Не може актьорът датата на смърт да бъде преди датата на раждане!");
            }
        }
    }

    boolean setAlive() {
        System.out.println("Жив ли е този актьор?");
        System.out.print("→ ");
        char c = sc.next().toLowerCase().charAt(0);
        while (c != 'д' && c != 'н' && c != 'y' && c != 'd' && c != 'n') {
            System.out.println("Невалиден отговор. Моля, въведете \"да\" или \"не\":");
            System.out.print("→ ");
            c = sc.next().toLowerCase().charAt(0);
        }
        return c != 'n' && c != 'н';
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

    public LocalDate getDied() {
        return died;
    }

    public void setDied(LocalDate died) {
        this.died = died;
    }

    public String getFieldOfWork() {
        return fieldOfWork;
    }

    public void setFieldOfWork(String fieldOfWork) {
        this.fieldOfWork = fieldOfWork;
    }

    @Override
    public String toString() {
        return String.format("%s %s, роден %s г.%s е %s.",
                (actorType.substring(0, 1).toUpperCase() + actorType.substring(1)),
                this.name,
                this.born.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                String.format("%s",
                        this.died == null ? "" : String.format(" и починал %s г. (на %d г.)",
                                this.died.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                                Period.between(this.born, this.died).getYears())),
                this.fieldOfWork
        );
    }
}
