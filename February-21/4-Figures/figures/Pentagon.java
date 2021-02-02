package figures;

public class Pentagon extends Figure {
    public Pentagon(double dimension) {
        super("Петоъгълник", dimension);
    }

    @Override
    double findPerimeter() {
        return 5 * this.getDimension();
    }

    @Override
    double findSurfaceArea() {
        return (0.25 * Math.sqrt(5 * (5 + 2*Math.sqrt(5))) *
                this.getDimension()*this.getDimension());
    }
}
