package animalkingdom;

class AnimalKingdom {
    public static void main(String[] args) {
        Cat cat = new Cat("Kitty", 4);
        Dog dog = new Dog("Puppy", 1);

        System.out.println("Cat: " + cat.makeNoise());
        System.out.println("Dog: " + dog.makeNoise());
        System.out.println("Cat: " + cat.doATrick());
        System.out.println("Dog: " + dog.doATrick());
    }
}
