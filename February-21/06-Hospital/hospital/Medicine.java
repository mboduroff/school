package hospital;

import java.util.ArrayList;
import java.util.List;
import static hospital.Patient.sc;

public class Medicine {
    private String medicineName;
    private double medicineDose; // in mg or mL

    public Medicine(String medicineName, double medicineDose) {
        this.medicineName = medicineName;
        this.medicineDose = medicineDose;
        System.out.println("[ВЪВЕДЕНО] " + this);
    }

    public Medicine() {
        String[] temp = sc.nextLine().split(",\\s+");
        this.medicineName = temp[0];
        this.medicineDose = Double.parseDouble(temp[1]);
    }

    @Override
    public String toString() {
        return String.format("Лекарство %s с доза %.1f mg (mL)",
                this.medicineName,
                this.medicineDose);
    }
}
