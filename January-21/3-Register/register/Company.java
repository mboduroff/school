package register;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Company {
    private String companyName;
    private LocalDate dateCreated;
    private String bulstat;

    static Scanner sc = new Scanner(System.in);

    public Company(String companyName, LocalDate dateCreated, String bulstat) {
        this.companyName = companyName;
        this.dateCreated = dateCreated;
        setBulstat(bulstat);
    }

    public Company() {
        System.out.println("===: Нова фирма :===");
        System.out.println("Моля, въведете следните данни за фирмата: ");
        System.out.print("Име на фирмата: ");
        this.companyName = sc.nextLine().trim();
        setDateCreated();
        setBulstat();
    }

    public void print() {
        System.out.printf("Фирмата %s с БУЛСТАТ %s е създадена на %s г. ",
                this.getCompanyName(),
                this.getBulstat(),
                this.getDateCreated()
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated() {
        System.out.println("ДАТА НА ОСНОВАВАНЕ:");
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
        this.dateCreated = LocalDate.of(yyyy, mm, dd);
    }

    public void setDateCreated(int dd, int mm, int yyyy) {
        this.dateCreated = LocalDate.of(yyyy, mm, dd);
    }

    public String getBulstat() {
        return bulstat;
    }

    public void setBulstat(String bulstat) {
        if(bulstat.length() == 10)
            this.bulstat = bulstat;
        else
            System.out.println("Булстатът не е от 10 символа!");
    }

    public void setBulstat() {
        System.out.print("\nБулстат: ");
        this.bulstat = sc.next();
        while (bulstat.length() != 10) {
            System.out.println("Невалиден формат! Булстатът трябва да съдържа 10 символа.\n" +
                    "Моля, опитайте отново: ");
            this.bulstat = sc.next();
        }
    }

    @Override
    public String toString() {
        return String.format("%nФирма: %s / Създадена на: %s / БУЛСТАТ: %s /",
                this.getCompanyName(),
                this.getDateCreated().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                this.getBulstat());
    }
}

