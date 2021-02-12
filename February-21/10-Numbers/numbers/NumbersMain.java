package numbers;

public class NumbersMain {
    public static void main(String[] args) {
        System.out.println("Събиране на две числа от подаден текст: "
                + Numbers.add("7.3", "4"));
        System.out.println("Събиране на две числа при подаване на цели числа"
                + Numbers.add(2, 2));
    }
}
