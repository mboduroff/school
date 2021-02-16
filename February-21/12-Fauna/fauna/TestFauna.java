package fauna;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class TestFauna {
    public static void main(String[] args) {
        Cat cat1 = new Cat();

        System.out.println("\tInfo about my first cat:");
        cat1.printInfo();

        Cat cat2 = new Cat(4, 40, false, "China",
                "Dolly", "Persian");

        cat2.setSizeInCm(23.5);
        cat2.setAge(6);
        System.out.println("\tInfo about my second cat: \n" + cat2.getInfo());

        printBreedOfBiggerCat(cat1, cat2);

        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human(18, 180,
                false, "Bulgaria",
                "Ivan", "blue"));
        humanList.add(new Human(40, 160,
                false, "Bulgaria",
                "Petur", "brown"));
        humanList.add(new Human(21, 175,
                false, "Bulgaria",
                "Petya", "green"));
        humanList.add(new Human(66, 188,
                false, "Bulgaria",
                "Georgi", "brown"));
        humanList.add(new Human(31, 168,
                false, "Bulgaria",
                "Gergana", "blue"));


        System.out.println("\n\tInformation about all humans: ");
        humanList.forEach(Human::printInfo);

        System.out.println("\n\tInformation about all humans with blue eyes: ");
        humanList.stream()
                .filter(h -> h.getEyeColour().equals("blue"))
                .forEach(Human::printInfo);


        List<Bird> birdList = new ArrayList<>();
        birdList.add(new Bird(2, 25, ActiveTime.DAY, false));
        birdList.add(new Bird(4, 30, ActiveTime.NIGHT, true));

        System.out.println("\n\tInformation about all birds: ");
        birdList.forEach(Bird::printInfo);
    }

    public static void printBreedOfBiggerCat(Cat c1, Cat c2) {
        System.out.println("\tComparing two cats:\n" +
                "Cat 1: " + c1 + "\nCat 2: " + c2);
        String temp;
        if (c1.getSizeInCm() > c2.getSizeInCm())
            temp = c1.getBreed();
        else
            temp = c2.getBreed();

        System.out.printf("The breed of the bigger cat is '%s'.%n", temp);
    }
}
