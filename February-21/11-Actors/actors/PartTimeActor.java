package actors;

import java.time.LocalDate;

public class PartTimeActor extends Actor {

    public PartTimeActor(String name, LocalDate born, LocalDate died, String fieldOfWork) {
        super(name, born, died, fieldOfWork, "почасов актьор");
    }

    public PartTimeActor(String name, LocalDate born, String fieldOfWork) {
        super(name, born, fieldOfWork, "почасов актьор");
    }

    public PartTimeActor() {
        super("почасов актьор");
    }

    @Override
    double calculateSalary() {
        System.out.println("Моля, въведете заплатата на час за този актьор: ");
        double hourlyPay = sc.nextDouble();
        System.out.println("Моля, въведете изработените часове (но не повече от 40): ");
        int workedHours = sc.nextInt();
        return hourlyPay * workedHours;
    }

    @Override
    double calculateSalary(double hourlyPay, int workedHours) {
        return hourlyPay * workedHours;
    }
}
