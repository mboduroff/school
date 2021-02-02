package figures;

public class Circle extends Figure {
    public Circle(double dimension) {
        super("Кръг", dimension);
    }

    @Override
    double findPerimeter() {
        return (Math.PI * 2 * this.getDimension());
    }

    @Override
    double findSurfaceArea() {
        return (Math.PI * this.getDimension() * this.getDimension());
    }
}
