package hospital;

import java.time.LocalDate;

public class Hospital {
    public static void main(String[] args) {
        PatientCaseHistory epicrisis = new PatientCaseHistory(
                "COVID-19",
                PatientStatus.SICK,
                LocalDate.of(2020, 12, 14));

        epicrisis.addMeds(new Medicine("Aspirin", 100));
        epicrisis.addMeds(new Medicine("Vitamin C", 200));

        SickPatient sickPatient1 = new SickPatient("Иван Петров",
                "ул. Първа 2",
                "9901017587",
                epicrisis);

        sickPatient1.printListOfMeds();
        sickPatient1.cure();

        SickPatient sickPatient = new SickPatient();
        sickPatient.printListOfMeds();
        sickPatient.cure();
    }
}
