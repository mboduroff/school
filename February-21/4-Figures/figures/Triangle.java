package figures;

public class Triangle extends Figure {
    public Triangle(double dimension) {
        super("Триъгълник", dimension);
    }

    @Override
    double findPerimeter() {
        return (3 * this.getDimension());
    }

    @Override
    double findSurfaceArea() {
        return ((Math.sqrt(3)/4) * (this.getDimension() * this.getDimension()));
    }
}
