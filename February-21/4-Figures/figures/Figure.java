package figures;

abstract class Figure {
    private String figureType;
    private double dimension;

    public Figure(String figureType, double dimension) {
        this.figureType = figureType;
        this.dimension = dimension;
    }

    public double getDimension() {
        return dimension;
    }

    public void setDimension(double dimension) {
        this.dimension = dimension;
    }

    abstract double findPerimeter();
    abstract double findSurfaceArea();

    @Override
    public String toString() {
        return String.format("%s има периметър %.2f cm и лице %.2f кв. cm.",
                this.figureType,
                this.findPerimeter(),
                this.findSurfaceArea());
    }
}
