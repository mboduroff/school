package electronics;

public class Laptop extends ElectronicDevice {
    private int ramSize;
    private int storageSize;

    public Laptop(int powerSupplyVoltage, String CPUmodel) {
        super(powerSupplyVoltage, CPUmodel);
        emptyConstructor();
    }

    public Laptop(ElectronicDevice e) {
        super(e.getPowerSupplyVoltage(), e.getCPUmodel());
        emptyConstructor();
    }

    public Laptop() {
        emptyConstructor();
    }

    public Laptop(int powerSupplyVoltage, String CPUmodel, int ramSize, int storageSize) {
        super(powerSupplyVoltage, CPUmodel);
        this.ramSize = ramSize;
        this.storageSize = storageSize;
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public Laptop(ElectronicDevice e, int ramSize, int storageSize) {
        super(e.getPowerSupplyVoltage(), e.getCPUmodel());
        this.ramSize = ramSize;
        this.storageSize = storageSize;
        System.out.println("[ВЪВЕДЕН] " + this);
    }

    private void emptyConstructor() {
        System.out.println("---< Нов лаптоп >---");
        System.out.println("Моля, въведете следните свойства за този лаптоп:");
        System.out.print("RAM (GB): ");
        this.ramSize = sc.nextInt();
        System.out.print("Размер на storage (GB): ");
        this.storageSize = sc.nextInt();

        System.out.println("[ВЪВЕДЕН] " + this);
    }

    public boolean checkIfBetter(Laptop l) {
        if (this.storageSize < l.storageSize)
            return false;
        else return this.ramSize > l.ramSize;
    }

    // Getters and setters below this line

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("/ Лаптоп: размер на постоянната памет: %d GB / RAM: %d GB",
                        this.storageSize,
                        this.ramSize);
    }
}
