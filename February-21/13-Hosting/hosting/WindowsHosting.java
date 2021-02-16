package hosting;

public class WindowsHosting extends Hosting {
    private boolean usesExchange;

    public WindowsHosting(int emailsSentCount,
                          double usedDiskSpaceInMB, double cpuTimeInSeconds) {

        super(ServerOS.WINDOWS, emailsSentCount,
                usedDiskSpaceInMB, cpuTimeInSeconds);
        this.usesExchange = false;
    }

    @Override
    double calculateUsage() {
        return this.getUsedDiskSpaceInMB() * 2
                + (double) this.getEmailsSentCount() / 100
                + this.getCpuTimeInSeconds();
    }

    @Override
    double calculateFees() {
        return this.calculateUsage() / 500;
    }

    public boolean usesExchange() {
        return usesExchange;
    }

    public void setUsesExchange(boolean usesExchange) {
        this.usesExchange = usesExchange;
    }
}
