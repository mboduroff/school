package figures;

public class Figures {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        Pentagon p = new Pentagon(5);
        Triangle t = new Triangle(3);

        System.out.println(c + "\n" + p + "\n" + t);
    }
}