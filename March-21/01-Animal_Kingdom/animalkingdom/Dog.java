package animalkingdom;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeNoise() {
        return "Woof! " + super.makeNoise();
    }

    @Override
    public String doATrick() {
        return "Hold my paw, human!";
    }
}
