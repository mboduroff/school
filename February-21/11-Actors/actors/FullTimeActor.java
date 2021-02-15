package actors;

import java.time.LocalDate;
import java.util.List;

public class FullTimeActor extends Actor {

    public FullTimeActor(String name, LocalDate born, LocalDate died, List<Production> appearances, String fieldOfWork) {
        super(name, born, died, fieldOfWork, appearances, "актьор на щат");
    }

    public FullTimeActor(String name, LocalDate born, List<Production> appearances, String fieldOfWork) {
        super(name, born, fieldOfWork, appearances, "актьор на щат");
    }

    public FullTimeActor() {
        super("актьор на щат");
    }

    @Override
    double calculateSalary() {
        System.out.println("Моля, въведете заплатата на час за този актьор: ");
        double hourlyPay = sc.nextDouble();
        System.out.println("Моля, въведете изработените часове (но не повече от 40): ");
        int temp = sc.nextInt();

        while (temp > 40) {
            System.out.println("Моля, въведете изработените часове за тази седмица (но не повече от 40): ");
            temp = sc.nextInt();
        }

        int workedHours = temp;
        return hourlyPay * workedHours;
    }

    @Override
    double calculateSalary(double hourlyPay, int workedHours) {
        if (workedHours > 40)
            throw new IllegalArgumentException("Не може работник на щат " +
                    "да работи повече от 40ч/седмица");
        else
        return hourlyPay * workedHours;
    }
}
