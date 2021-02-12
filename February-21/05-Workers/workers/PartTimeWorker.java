package workers;

public class PartTimeWorker extends Worker {

    public PartTimeWorker(String name, double hourlyWage, String workType, int workedHours) {
        super(name, hourlyWage, workType, workedHours, "почасов работник");
    }

    @Override
    double calculateWeeklySalary() {
        int workedHours = this.getWorkedHours();
        if (workedHours > 40) {
            return 40 * this.getHourlyWage()
                    + ((workedHours - 40) * this.getHourlyWage() * 1.5);
        }
        return workedHours * this.getHourlyWage();
    }
}
