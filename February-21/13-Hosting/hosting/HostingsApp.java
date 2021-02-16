package hosting;

import java.util.ArrayList;
import java.util.List;

public class HostingsApp {
    static List<Hosting> hostingList = new ArrayList<>();

    public static void main(String[] args) {
        hostingList.add(new LinuxHosting(450, 1024,
                2.3, 4.1));
        hostingList.add(new LinuxHosting(280, 768,
                1.9, 3.6));
        hostingList.add(new WindowsHostingWithExchange(400, 900,
                8));
        hostingList.add(new WindowsHosting(340, 768,
                5.1));
        hostingList.add(new WindowsHosting(900, 2048,
                14.3));


        Hosting.printAllData();
    }
}
