package realestate;

public class House extends Home {
    private double yardArea;

    public House(double area, double yardArea) {
        super(area);
        this.yardArea = yardArea;
    }

    public House() {
        super();
        System.out.print("Въведете площта на двора (в кв. m): ");
        this.yardArea = sc.nextDouble();

        System.out.println("Въведено: " + this);
    }

    public House(double yardArea) {
        this.yardArea = yardArea;
    }

    public House(Home home, double yardArea) {
        super(home.getArea());
        this.yardArea = yardArea;
    }

    @Override
    public double calculatePrice(double priceInEUR) {
        return super.calculatePrice(priceInEUR) + this.yardArea * priceInEUR;
    }

    @Override
    public double calculatePrice() {
        System.out.print("Въведете цена за кв. m в EUR: ");
        double priceInEUR = sc.nextDouble();
        return super.calculatePrice(priceInEUR) + this.yardArea * priceInEUR;
    }

    @Override
    public String toString() {
        return super.toString() + " / двор: " + this.yardArea + " кв. m";
    }
}
