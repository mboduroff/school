package documents;

public class Documents {
    public static void main(String[] args) {
        Document d = new Document("Директор(a) на ППМГ \"Гео Милев\"",
                "Мартин Бодуров",
                "Уведомително писмо",
                "Моля, да уважите отсъствията ми в периода 29.01 - 29.01 г. по уважителни причини.");
        System.out.println(d);
    }
}
