package Gift;

import java.util.ArrayList;

public class TestGift {
    public static void main(String[] args) {
        ArrayList<Gift> list = new ArrayList<>();
        // Параметри за въвеждане на нов подарък: подарък, получател, повод, цена, тегло
        Gift g = new Gift("Кола", "Иван",
                "Коледа", 5000, 1000);
        list.add(g);

        Gift g1 = new Gift("Телефон", "Петър",
                "Сватба", 499.99, 0.5);
        list.add(g1);

        Gift g2 = new Gift();
        list.add(g2);

        System.out.println(g.findHeavier(g1) + "\n");

        System.out.println("==== Подаръците, сортирани по цена: =====");
        g.sortGiftsByPrice(list).forEach(System.out::println);

        System.out.println("\nИнформация за подаръка: ");
        g2.getInfo();

        if(g2.checkForPhone())
            System.out.println("Подарък №2 (" + g2.getGiftContent() + ") е телефон.");

    }
}
