package workers;

import java.util.ArrayList;
import java.util.List;

import static workers.Worker.*;

public class Workers {
    static List<Worker> workerList = new ArrayList<>();
    public static void main(String[] args) {
        Worker w = new BlueCollarWorker("Иван Петров", 8,
                "строителен работник", 38);
        workerList.add(w);
        System.out.printf("%nСедмичната заплата на %s е %.2f лв.%n%n",
                w.getName(),
                w.calculateWeeklySalary());

        Worker w1 = new PartTimeWorker("Петър Иванов", 18,
                "front-end developer", 42);
        workerList.add(w1);
        System.out.printf("%nСедмичната заплата на %s е %.2f лв.%n%n",
                w1.getName(),
                w1.calculateWeeklySalary());

        workerList.add(new PartTimeWorker("Ваня Петрова", 15,
                "медицинска сестра", 60));
        workerList.add(new PartTimeWorker("Петя Иванова", 13,
                "freelancer", 8));

        printStatistics();

    }
}
