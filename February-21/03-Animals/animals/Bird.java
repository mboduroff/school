package animals;

public class Bird extends Animal {
    private boolean migrates;

    public Bird(String name, int age, char sex, boolean migrates) {
        super(name, age, sex);
        this.migrates = migrates;
    }

    @Override
    void sing() {
        System.out.printf("Птичката %s на %d г. чурулика!%n",
                this.getName(),
                this.getAge());
    }

    @Override
    void eat() {
        System.out.printf("Птичката %s на %d г. яде зрънца!%n",
                this.getName(),
                this.getAge());
    }

    @Override
    public String toString() {
        return "Птичката" + super.toString() + String.format(" Тя %s мигрира.",
                this.migrates ? "" : "не");
    }
}
