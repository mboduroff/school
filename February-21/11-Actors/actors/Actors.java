package actors;

import java.time.LocalDate;

public class Actors {
    public static void main(String[] args) {
        Actor fullTimeActor = new FullTimeActor("Иван Петров",
                LocalDate.of(1995, 10, 12),
                "кино актьор");

        System.out.println("Заплатата на този актьор на щат е: "
                + fullTimeActor.calculateSalary(12, 40)
                + " лв.");


        Actor partTimeActor = new PartTimeActor("Петър Иванов",
                LocalDate.of(1908, 6, 6),
                LocalDate.of(2019, 12, 6),
                "театрален актьор");

        System.out.println("Заплатата на този почасов актьор е: "
                + partTimeActor.calculateSalary(12, 40)
                + " лв.");


        Actor test = new FullTimeActor();
        double salary = test.calculateSalary();
        System.out.printf("Заплатата на тестовия актьор е %.2f лв.%n",
                salary);

    }
}
