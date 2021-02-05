package workers;

import static workers.Workers.workerList;

public abstract class Worker {
    private String name;
    private double wage; // BGN per hour
    private String workType;
    private int workedHours; // per week
    private String workerType;

    public Worker(String name, double wage, String workType, int workedHours, String workerType) {
        this.name = name;
        this.wage = wage;
        this.workType = workType;
        this.workedHours = workedHours;
        this.workerType = workerType;
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    abstract double calculateWeeklySalary();

    public static void printStatistics() {
        System.out.printf("%nОбщият брой изработени часове от всички работници е: %d ч.%n",
                workerList.stream()
                        .mapToInt(Worker::getWorkedHours)
                        .sum());
        System.out.printf("Средният брой изработени часове от всички работници е: %.1f ч.%n",
                workerList.stream()
                        .mapToInt(Worker::getWorkedHours)
                        .average()
                        .getAsDouble());

        System.out.printf("Сумата от изплатени заплати на всички работници е: %.2f лв.%n",
                workerList.stream()
                        .mapToDouble(Worker::calculateWeeklySalary)
                        .sum());
        System.out.printf("Средната седмична заплата за всички работници е: %.2f лв.%n",
                workerList.stream()
                        .mapToDouble(Worker::calculateWeeklySalary)
                        .average()
                        .getAsDouble());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    @Override
    public String toString() {
        return String.format("%s е %s (%s) на заплата %.2f лв/час, работещ по %d часа на седмица.",
                this.name,
                this.workType,
                this.workerType,
                this.wage,
                this.workedHours);
    }
}
