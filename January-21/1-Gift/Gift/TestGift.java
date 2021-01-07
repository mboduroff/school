package Gift;

import java.util.ArrayList;

import static Gift.Gift.sortGiftsByPrice;

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

        Gift g2 = new Gift("Таблет", "Тодор",
                "Великден", 800, 1);
        list.add(g2);

        Gift g3 = new Gift("Ябълка", "Петьо",
                "Рожден ден", 2, 4);
        list.add(g3);

        Gift g4 = new Gift();
        list.add(g4);

        System.out.println(g.findHeavier(g1));

        sortGiftsByPrice(list);

        System.out.println("\nИнформация за подаръка: ");
        g2.getInfo();

        if(g2.isPhone())
            System.out.println("Подарък №2 (" + g2.getGiftContent() + ") е телефон.");
    }
}
