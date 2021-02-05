package hospital;

import java.util.Scanner;

abstract class Patient {
    private String name;
    private String address;
    private String egn;

    static Scanner sc = new Scanner(System.in);

    public Patient(String name, String address, String egn) {
        this.name = name;
        this.address = address;
        setEgn(egn);
    }

    public Patient() {
        System.out.println("\n===< Нов пациент >===");
        System.out.println("Моля, въведете името на пациента: ");
        this.name = sc.nextLine();
        System.out.println("Моля, въведете адреса на пациента: ");
        this.address = sc.nextLine();
        setEgn();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn() {
        System.out.print("Моля, въведете ЕГН: ");
        String temp = sc.next();
        while (temp.length() != 10) {
            System.out.print("Невалиден формат. Моля, въведете ЕГН отново: ");
            temp = sc.next();
        }
        this.egn = temp;
    }

    public void setEgn(String temp) {
        while (temp.length() != 10) {
            System.out.print("Невалиден формат. Моля, въведете ЕГН отново: ");
            temp = sc.next();
        }
        this.egn = temp;
    }

    @Override
    public String toString() {
        return String.format("Пациент %s с ЕГН %s живее в %s%n",
                this.name,
                this.egn,
                this.address);
    }
}
