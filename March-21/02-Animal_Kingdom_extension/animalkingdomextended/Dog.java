package animalkingdomextended;

public class Dog extends Animal {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String makeNoise() {
        return "Woof!";
    }

    @Override
    public String doATrick() {
        return "Hold my paw, human!";
    }

    @Override
    void perform() {
        System.out.println(makeNoise());
        System.out.println(doATrick() + "\n");
    }
}
