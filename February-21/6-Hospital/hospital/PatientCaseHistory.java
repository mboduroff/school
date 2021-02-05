package hospital;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static hospital.Patient.sc;

public class PatientCaseHistory {
    private String disease;
    private PatientStatus status;
    private List<Medicine> medicineList = new ArrayList<>();
    private LocalDate dateDiseaseFound;

    public PatientCaseHistory(String disease, PatientStatus status, LocalDate dateDiseaseFound) {
        this.disease = disease;
        this.status = status;
        this.dateDiseaseFound = dateDiseaseFound;
        System.out.println("[ВЪВЕДЕНА НОВА ЕПИКРИЗА] " + this);
    }

    public PatientCaseHistory() {
        System.out.println("\nСъздавам нова епикриза...");
        System.out.println("Моля, въведете име на заболяването на пациента:");
        sc.nextLine();
        this.disease = sc.nextLine();
        System.out.println("Кога е открито то?");
        setDiseaseFoundOn();
        addMeds();
        System.out.printf("Успешно добавени %d лекарства.%n",
                this.medicineList.size());
        setStatus();
        System.out.println("===< Край на епикризата >===");
        System.out.println("[ВЪВЕДЕНА НОВА ЕПИКРИЗА] " + this);
    }

    public void setDiseaseFoundOn() {
        System.out.print("Ден от месеца: ");
        int dd = sc.nextInt();
        while (dd < 1 || dd > 31) {
            System.out.println("Моля, въведете валидни стойности за ден от месеца (1 - 31): ");
            dd = sc.nextInt();
        }
        System.out.print("Месец: ");
        int mm = sc.nextInt();
        while (mm < 1 || mm > 12) {
            System.out.println("Моля, въведете валиден месец (1 - 12): ");
            mm = sc.nextInt();
        }
        System.out.print("Година: ");
        int yyyy = sc.nextInt();
        int currentYear = LocalDate.now().getYear();
        while (yyyy > currentYear) {
            System.out.println("Моля, въведете валидна година! Не може датата на създаване да бъде в бъдещето.\n" +
                    "Опитайте отново: ");
            yyyy = sc.nextInt();
        }
        this.dateDiseaseFound = LocalDate.of(yyyy, mm, dd);
    }

    public void addMeds(Medicine m) {
        this.medicineList.add(m);
        System.out.println("Нов брой лекарства за тази епикриза: " + this.medicineList.size() + "\n");
    }

    public void addMeds(int count) {
        for (int i = 0; i < count; i++) {
            this.medicineList.add(new Medicine());
        }
        System.out.println("Нов брой лекарства за тази епикриза: " + this.medicineList.size());
    }

    public void addMeds() {
        System.out.println("Въведете лекарства:\n" +
                "Когато приключите с въвеждането, въведете празен ред.");
        System.out.println("(въведете във формат \"лекарство, доза\")");
        sc.nextLine();
        String[] input = sc.nextLine().split(",\\s+");
        medicineList.add(new Medicine(input[0], Double.parseDouble(input[1])));
        while (!input[0].isEmpty()) {
            input = sc.nextLine().split(",\\s+");
            if (!input[0].isBlank()) {
                medicineList.add(new Medicine(input[0], Double.parseDouble(input[1])));
            }
        }
    }

    public PatientStatus getStatus() {
        return status;
    }

    public void setStatus() {
        System.out.println("Какво е състоянието на пациента?\n" +
                "(болен или здрав)");
        System.out.print("→ Избор: ");
        char c = sc.next().trim().toLowerCase().charAt(0);
        while(c != 'б' && c != 'з') {
            System.out.println("Невалиден отговор. Моля, опитайте отново.\n" +
                    "Какво е състоянието на пациента?\n" +
                    "(болен или здрав)");
            System.out.print("→ Избор: ");
            c = sc.next().trim().toLowerCase().charAt(0);
        }
        if (c == 'б')
            this.status = PatientStatus.SICK;
        else
            this.status = PatientStatus.HEALTHY;
    }

    public void setStatus(PatientStatus status) {
        this.status = status;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public LocalDate getDateDiseaseFound() {
        return dateDiseaseFound;
    }

    public void setDateDiseaseFound(LocalDate dateDiseaseFound) {
        this.dateDiseaseFound = dateDiseaseFound;
    }

    @Override
    public String toString() {
        return String.format("Болест: %s / Заболяването е открито на: %s г. /%n" +
                        "Състояние на пациент: %s / Брой приемани лекарства: %d%n",
                this.disease,
                this.dateDiseaseFound.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                this.status == PatientStatus.SICK ? "болен" : "здрав",
                this.getMedicineList().size());
    }
}
