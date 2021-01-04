package Gift;

import java.util.ArrayList;

public class TestGift {
    public static void main(String[] args) {
        ArrayList<Gift> list = new ArrayList<>();
        Gift g = new Gift("Кола", "Иван",
                "Коледа", 500, 100);
        list.add(g);

        System.out.println(list.get(0).getPrice());

        Gift g1 = new Gift("Телефон", "Петър",
                "Сватба", 50, 0.5);

        list.add(g1);
        System.out.println(list.get(0).getPrice());
        System.out.println(list.get(1).getPrice());
        System.out.println("=========");
        g.sortGiftsByPrice(list);
    }
}
