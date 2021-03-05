package animalkingdomextended;

public class Cat extends Animal {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String makeNoise() {
        return "Meow!";
    }

    @Override
    public String doATrick() {
        return "No trick for you! I'm too lazy!";
    }

    @Override
    void perform() {
        System.out.println(makeNoise());
        System.out.println(doATrick() + "\n");
    }
}
