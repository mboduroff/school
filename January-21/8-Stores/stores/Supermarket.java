package stores;

import java.util.List;

public class Supermarket extends Store {
    private int cashDeskCount;
    private boolean isNonstop;

    public Supermarket(String name, int employeeCount, List<String> goods, double drawerAmount, int cashDeskCount, boolean isNonstop) {
        super(name, employeeCount, goods, drawerAmount);
        this.cashDeskCount = cashDeskCount;
        this.isNonstop = isNonstop;

        this.printWhenEntered();
    }

    public Supermarket() {
        super(true);
        sc.nextLine();
        setCashDeskCount();
        setNonstop();

        this.printWhenEntered();
    }

    public Supermarket(Store s) {
        super(s.getName(), s.getEmployeeCount(), s.getGoods(), s.getDrawerAmount());
        setCashDeskCount();
        setNonstop();
        this.printWhenEntered();
    }

    public Supermarket(Store s, int cashDeskCount, boolean isNonstop) {
        super(s.getName(), s.getEmployeeCount(), s.getGoods(), s.getDrawerAmount());
        this.cashDeskCount = cashDeskCount;
        this.isNonstop = isNonstop;
    }

    public void deliverGoods() {
        System.out.printf("%n\t%s▶ %sДоставям стоки в супермаркет %s...%n%s",
                ANSI_GREEN, ANSI_RESET,
                super.getName(),
                ANSI_BLUE);
        super.getGoods().forEach(s -> System.out.println("→ " + s));
        if(super.getGoods().isEmpty()) {
            System.out.printf("%sНеуспешна доставка! 0%s доставени стоки.%n",
                    ANSI_RED, ANSI_RESET);
        } else {
            System.out.printf("%s%nУспешна доставка! %s доставени стоки.%n",
                    ANSI_RESET,
                    (ANSI_GREEN + super.getGoods().size() + ANSI_RESET));
            super.getGoods().clear();
        }
    }

    public int getCashDeskCount() {
        return cashDeskCount;
    }

    public void setCashDeskCount(int cashDeskCount) {
        this.cashDeskCount = cashDeskCount;
    }

    public void setCashDeskCount() {
        System.out.print("Брой каси: ");
        int temp = sc.nextInt();
        while (temp < 0) {
            System.out.println("Невалидна стойност! Касите не могат да бъдат отрицателно число.");
            System.out.print("Въведете нов брой каси: ");
            temp = sc.nextInt();
        }
        this.cashDeskCount = temp;
    }

    public boolean isNonstop() {
        return isNonstop;
    }

    public void setNonstop(boolean nonstop) {
        this.isNonstop = nonstop;
    }

    public void setNonstop() {
        sc.nextLine();
        System.out.println("Денонощен ли е магазинът?");
        System.out.printf("%sВъведете \"да\", \"не\", \"yes\" или \"no\":%s ",
                ANSI_BLUE, ANSI_RESET);
        char c = sc.next().trim().charAt(0);
        while (c != 'д' && c != 'd' && c != 'y' && c != 'n' && c != 'н') {
            System.out.println("Невалиден отговор!");
            System.out.print("Въведете \"да\", \"не\", \"yes\" или \"no\": ");
            c = sc.next().charAt(0);
        }
        this.isNonstop = c == 'д' || c == 'd' || c == 'y';
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" / Брой каси: %s / Денонощен: %s",
                (ANSI_BLUE + this.cashDeskCount + ANSI_RESET),
                (ANSI_BLUE + (this.isNonstop ? "да" : "не") + ANSI_RESET));
    }

    @Override
    public void printWhenEntered() {
        System.out.printf("%n%s[ВЪВЕДЕН]%s Супермаркет%s",
                ANSI_RED,
                ANSI_RESET,
                this);
    }
}
