package rectangle;

public class RectangleMain {
    public static void main(String[] args) {

        Rectangle r = new Rectangle(5, 6);
        System.out.println("Лицето на r e: " + r.findArea() + " кв. cm");

        Rectangle r1 = new Rectangle(r);
        System.out.println("Лицето на r1 e: " + r1.findArea() + " кв. cm");

        Rectangle r2 = new Rectangle();
        System.out.println("Лицето на r2 e: " + r2.findArea() + " кв. cm");

    }
}
