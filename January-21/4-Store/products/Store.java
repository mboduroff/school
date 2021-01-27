package products;

public class Store {
    public static void main(String[] args) {
        System.out.println("Цената на електроенергията в лв е: " +
                ElectricalAppliance.getPriceOfElectricity());
        Product p = new Product("Хладилник", 799.99, 60.2);
        ElectricalAppliance e = new ElectricalAppliance(p, 230, 150);

        e.calculateCosts();
        e.print();

        ElectricalAppliance e1 = new ElectricalAppliance(p);
        e1.print();
        e1.calculateCosts();

    }
}
