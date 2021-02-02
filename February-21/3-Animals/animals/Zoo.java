package animals;

public class Zoo {
    public static void main(String[] args) {
        Bird b = new Bird("Иван", 1, 'M', false);
        Lion l = new Lion("Петър", 5, 'M');

        b.eat();
        l.sing();

        System.out.println();

        System.out.println(b);
        System.out.println(l);
    }
}