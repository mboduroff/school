package workers;

public class BlueCollarWorker extends Worker {

    public BlueCollarWorker(String name, double wage, String workType, int workedHours) {
        super(name, wage, workType, workedHours, "щатен работник");
    }

    @Override
    double calculateWeeklySalary() {
        if(this.getWorkedHours() < 40) {
            return this.getWorkedHours() * this.getWage();
        } else {
            throw new IllegalArgumentException("Щатният работник не може да работи повече от 40 часа на седмица!");
        }
    }
}
