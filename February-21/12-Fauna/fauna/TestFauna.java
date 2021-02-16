package fauna;

public class TestFauna {
    public static void main(String[] args) {
        Creature cat1 = new Cat();

        System.out.println("Info about my first cat:");
        cat1.printInfo();

        Cat cat2 = new Cat(false, "China",
                "Dolly", "Persian");

        cat2.setSizeInCm(23.5);
        cat2.setAge(6);
        System.out.println("Info about my second cat: \n" + cat2.getInfo());


    }
}
