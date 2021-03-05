package animalkingdom;

abstract class Animal implements MakesNoise, DoesATrick {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String makeNoise() {
        return String.format("My name is %s. I am %d years old.",
                this.getName(),
                this.getAge());
    }

    @Override
    public String doATrick() {
        return "Look at my trick!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
