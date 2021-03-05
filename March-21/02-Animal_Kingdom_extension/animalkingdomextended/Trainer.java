package animalkingdomextended;

public class Trainer {
    Animal animal;

    public Trainer(Animal animal) {
        this.animal = animal;
    }

    void train() {
        animal.perform();
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
