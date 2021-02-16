package hosting;

public class LinuxHosting extends Hosting {
    private double phpTime;
    private double mySqlTime;

    public LinuxHosting(int emailsSentCount, double usedDiskSpaceInMB, double phpTime, double mySqlTime) {
        super(ServerOS.LINUX, emailsSentCount, usedDiskSpaceInMB, 0);
        this.phpTime = phpTime;
        this.mySqlTime = mySqlTime;
        super.setCpuTimeInSeconds(this.getPhpTime() + this.getMySqlTime());
    }

    @Override
    double calculateUsage() {
        return this.getUsedDiskSpaceInMB() * 2
                + (double) this.getEmailsSentCount() / 100
                + this.phpTime + mySqlTime * 1.5;
    }

    @Override
    double calculateFees() {
        return this.calculateUsage() / 1000;
    }

    public double getPhpTime() {
        return phpTime;
    }

    public void setPhpTime(double phpTime) {
        this.phpTime = phpTime;
    }

    public double getMySqlTime() {
        return mySqlTime;
    }

    public void setMySqlTime(double mySqlTime) {
        this.mySqlTime = mySqlTime;
    }
}
