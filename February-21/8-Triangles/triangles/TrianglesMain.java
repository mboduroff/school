package triangles;

public class TrianglesMain {
    public static void main(String[] args) {
        Triangle t = new Triangle(4, 5, 6);
        System.out.printf("Лицето на този триъгълник е %.2f кв. cm.%n",
                t.findArea());

        System.out.printf("Лицето на равностранния триъгълник е: %.2f кв. cm.%n",
                Triangle.findArea(12));

        System.out.printf("Лицето на триъгълника (с дадени 3 страни) е: %.2f кв. cm.%n",
                Triangle.findArea(3.5, 4.3, 5.1));

        System.out.printf("Лицето на триъгълника (с дадени 2 страни и ъгъл) е: %.2f кв. cm.%n",
                Triangle.findArea(3, 4, 90));

        Triangle triangle = new Triangle();
    }
}
