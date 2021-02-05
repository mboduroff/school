package workers;

public class BlueCollarWorker extends Worker {

    public BlueCollarWorker(String name, double hourlyWage, String workType, int workedHours) {
        super(name, hourlyWage, workType, workedHours, "щатен работник");
    }

    @Override
    double calculateWeeklySalary() {
        if(this.getWorkedHours() < 40) {
            return this.getWorkedHours() * this.getHourlyWage();
        } else {
            throw new IllegalArgumentException("Щатният работник не може да работи повече от 40 часа на седмица!");
        }
    }
}
