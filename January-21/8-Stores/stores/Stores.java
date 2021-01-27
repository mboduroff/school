package stores;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Stores {
    public static void main(String[] args) {
        List<String> goods = new LinkedList<>(Arrays.asList(
                "Моркови",
                "Картофи",
                "Брашно",
                "Торта",
                "Яйца"));

        Store s = new Store("Lidl", 40, goods, 16_000);
        Supermarket sm = new Supermarket(s, 8, false);

        s.deliverGoods();
        s.collectCash();

//        Store s1 = new Store();
//        s1.deliverGoods();

        Supermarket sm1 = new Supermarket();
        sm1.deliverGoods();
        sm1.collectCash();

    }
}
