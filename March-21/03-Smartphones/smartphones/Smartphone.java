package smartphones;

public class Smartphone implements CanCall, CanBrowse {

    public Smartphone() {
        System.out.println("Създадох нов смартфон.");
    }

    @Override
    public void browse(String URL) {
        if (URL.matches(".*\\d+.*")) {
            System.out.println("Invalid URL!");
        } else {
            System.out.println("Browsing: " + URL);
        }
    }

    @Override
    public void call(String number) {
        boolean successful = true;
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            successful = false;
        } finally {
            if (successful && number.length() == 10) {
                System.out.println("Calling... " + number);
            } else {
                System.out.println("Invalid number!");
            }

        }
    }
}
