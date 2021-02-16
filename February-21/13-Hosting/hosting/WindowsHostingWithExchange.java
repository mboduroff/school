package hosting;

public class WindowsHostingWithExchange extends WindowsHosting {
    public WindowsHostingWithExchange(int emailsSentCount,
                                      double usedDiskSpaceInMB, double cpuTimeInSeconds) {

        super(emailsSentCount, usedDiskSpaceInMB, cpuTimeInSeconds);
        this.setUsesExchange(false);
    }

    @Override
    double calculateUsage() {
        return this.getUsedDiskSpaceInMB() * 2
                + (double) this.getEmailsSentCount() / 100
                + this.getCpuTimeInSeconds() * 1.5;
    }
}
