package electronics;

public class ElectronicsStore {
    public static void main(String[] args) {
        ElectronicDevice e = new ElectronicDevice(230, "Intel Core i7");
        Laptop l = new Laptop(e, 16, 240);
        Laptop l1 = new Laptop(e);

        System.out.println("Лаптоп 1" + (l.checkIfBetter(l1) ? " е " : " не е ") +
                "по-добър от лаптоп 2.\n");
        System.out.println("(Лаптоп 1: " + l + ")");
        System.out.println("(Лаптоп 2: " + l1 + ")");

        l.turnOn();
        l.turnOn();
        l.turnOff();

    }
}
