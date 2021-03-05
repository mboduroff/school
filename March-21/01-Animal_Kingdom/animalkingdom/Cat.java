package animalkingdom;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeNoise() {
        return "Meow! " + super.makeNoise();
    }

    @Override
    public String doATrick() {
        return "No trick for you! I'm too lazy!";
    }
}
