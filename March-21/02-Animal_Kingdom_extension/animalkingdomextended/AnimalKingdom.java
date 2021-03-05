package animalkingdomextended;

class AnimalKingdom {
    public static void main(String[] args) {
        Animal dog = new Dog("Puppy", 1);
        Cat cat = new Cat("Felix", 6);

        System.out.println("==< Dog >==");
        Trainer trainer = new Trainer(dog);
        trainer.train();

        System.out.println("==< Cat >==");
        trainer.setAnimal(cat);
        trainer.train();
    }
}
