package workers;

public class PartTimeWorker extends Worker {

    public PartTimeWorker(String name, double wage, String workType, int workedHours) {
        super(name, wage, workType, workedHours, "почасов работник");
    }

    @Override
    double calculateWeeklySalary() {
        int workedHours = this.getWorkedHours();
        if (workedHours > 40) {
            return 40 * this.getWage()
                    + ((workedHours - 40) * this.getWage() * 1.5);
        }
        return workedHours * this.getWage();
    }
}
