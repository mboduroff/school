package fauna;

public class TestFauna {
    public static void main(String[] args) {
        Cat cat1 = new Cat();

        System.out.println("Info about my first cat:");
        cat1.printInfo();

        Cat cat2 = new Cat(false, "China",
                "Dolly", "Persian");

        cat2.setSizeInCm(23.5);
        cat2.setAge(6);
        System.out.println("Info about my second cat: \n" + cat2.getInfo());

        printBreedOfBiggerCat(cat1, cat2);
    }

    public static void printBreedOfBiggerCat(Cat c1, Cat c2) {
        System.out.println("Comparing two cats:\n" +
                "Cat 1:" + c1 + "\nCat 2: " + c2);
        String temp;
        if (c1.getSizeInCm() > c2.getSizeInCm())
            temp = c1.getBreed();
        else
            temp = c2.getBreed();

        System.out.println("The breed of the bigger cat is " + temp);
    }
}
