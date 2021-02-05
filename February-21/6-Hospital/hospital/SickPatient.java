package hospital;

public class SickPatient extends Patient {
    private PatientCaseHistory patientCaseHistory;

    public SickPatient(String name, String address, String egn, PatientCaseHistory patientCaseHistory) {
        super(name, address, egn);
        this.patientCaseHistory = patientCaseHistory;
        System.out.println("[ВЪВЕДЕН НОВ БОЛЕН ПАЦИЕНТ] " + this);
    }

    public SickPatient() {
        System.out.println("===< Нов болен пациент >===");
        this.patientCaseHistory = new PatientCaseHistory();
        System.out.println("[ВЪВЕДЕН НОВ БОЛЕН ПАЦИЕНТ] " + this);
    }

    void cure() {
        this.patientCaseHistory.setStatus(PatientStatus.HEALTHY);
        System.out.println("\nИзлекувах пациента.");
    }

    void printListOfMeds() {
        System.out.println("Списъкът с лекарства за този пациент е:");
        this.patientCaseHistory.getMedicineList().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Болен пациент: " + super.toString() + this.patientCaseHistory;
    }
}
