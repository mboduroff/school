package hosting;

import java.util.Comparator;

abstract class Hosting {
    private ServerOS serverOS;
    private int emailsSentCount;
    private double usedDiskSpaceInMB;
    private double cpuTimeInSeconds;

    abstract double calculateUsage();
    abstract double calculateFees();

    public Hosting(ServerOS serverOS, int emailsSentCount,
                   double usedDiskSpaceInMB, double cpuTimeInSeconds) {
        this.serverOS = serverOS;
        this.emailsSentCount = emailsSentCount;
        this.usedDiskSpaceInMB = usedDiskSpaceInMB;
        this.cpuTimeInSeconds = cpuTimeInSeconds;
    }

    static Hosting findBiggestClient() {
        return HostingsApp.hostingList.stream()
                .max(Comparator.comparing(Hosting::calculateUsage))
                .get();
    }

    static double calculateTotalRevenue() {
        return HostingsApp.hostingList.stream()
                .mapToDouble(Hosting::calculateFees)
                .sum();
    }

    static void printAllData() {
        System.out.printf("\tВмомента в базата данни присъстват следните %d хостинги:%n",
                HostingsApp.hostingList.size());
        HostingsApp.hostingList.forEach(System.out::println);
        System.out.printf("%n\tОбщите приходи за този месез за нашата фирма са %.2f лв.%n",
                calculateTotalRevenue());
        System.out.println("\n\tНай-добрият ни клиент е:\n" + findBiggestClient());
    }

    public ServerOS getServerOS() {
        return serverOS;
    }

    public void setServerOS(ServerOS serverOS) {
        this.serverOS = serverOS;
    }

    public int getEmailsSentCount() {
        return emailsSentCount;
    }

    public void setEmailsSentCount(int emailsSentCount) {
        this.emailsSentCount = emailsSentCount;
    }

    public double getUsedDiskSpaceInMB() {
        return usedDiskSpaceInMB;
    }

    public void setUsedDiskSpaceInMB(double usedDiskSpaceInMB) {
        this.usedDiskSpaceInMB = usedDiskSpaceInMB;
    }

    public double getCpuTimeInSeconds() {
        return cpuTimeInSeconds;
    }

    public void setCpuTimeInSeconds(double cpuTimeInSeconds) {
        this.cpuTimeInSeconds = cpuTimeInSeconds;
    }

    @Override
    public String toString() {
        String hostingType;
        if (this.getClass() == WindowsHostingWithExchange.class) {
            hostingType = "Windows хостинг, използващ Exchange";
        } else if (this.getClass() == WindowsHosting.class) {
            hostingType = "Windows хостинг";
        } else
            hostingType = "Linux хостинг";

        return String.format("План \"%s\" (с вкл. %d имейла/мес. и %d MB) с цена %.2f лв/месец",
                hostingType,
                this.getEmailsSentCount(),
                (int) this.getUsedDiskSpaceInMB(),
                this.calculateFees());
    }
}
