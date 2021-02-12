package animals;

abstract class Animal {
    private String name;
    private int age;
    private char sex;

    public Animal(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    abstract void sing();
    abstract void eat();

    @Override
    public String toString() {
        return String.format(" %s е на %d г. и е от %s пол.",
                this.getName(),
                this.getAge(),
                (this.getSex() == 'M' ? "мъжки" : "женски"));
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
