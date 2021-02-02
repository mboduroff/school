package animals;

public class Lion extends Animal {

    public Lion(String name, int age, char sex) {
        super(name, age, sex);
    }

    @Override
    void sing() {
        System.out.printf("Лъвът %s на %d г. реве!%n",
                this.getName(),
                this.getAge());
    }

    @Override
    void eat() {
        System.out.printf("Лъвът %s на %d г. яде месо!%n",
                this.getName(),
                this.getAge());
    }

    @Override
    public String toString() {
        return "Лъвът" + super.toString();
    }
}
