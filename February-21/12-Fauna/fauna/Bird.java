package fauna;

public class Bird extends Creature {
    private ActiveTime activeTime;
    private boolean migrates;

    public Bird(int age, double sizeInCm, ActiveTime activeTime, boolean migrates) {
        super(age, sizeInCm);
        this.activeTime = activeTime;
        this.migrates = migrates;
    }

    public Bird(ActiveTime activeTime, boolean migrates) {
        super();
        this.activeTime = activeTime;
        this.migrates = migrates;
    }

    public Bird() {
        super();
        System.out.println("\n===< New bird >===");
        setMigrates();
        setActiveTime();
    }


    public ActiveTime getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(ActiveTime activeTime) {
        this.activeTime = activeTime;
    }

    public void setActiveTime() {
        System.out.println("When is this bird active?");
        System.out.println("(Enter: 'day' or 'night')");
        System.out.print("→ ");
        char c = sc.next().charAt(0);
        while (c != 'd' && c != 'n') {
            System.out.println("Invalid response!");
            System.out.println("When is the bird active?");
            System.out.println("(Enter: \"day\" or \"night\")");
            System.out.print("→ ");
            c = sc.next().charAt(0);
        }

        if (c == 'd') {
            this.activeTime = ActiveTime.DAY;
        } else {
            this.activeTime = ActiveTime.NIGHT;
        }
    }

    public boolean migrates() {
        return migrates;
    }

    public void setMigrates(boolean migrates) {
        this.migrates = migrates;
    }

    public void setMigrates() {
        System.out.println("Does this bird migrate?");
        System.out.print("→ ");
        char c = sc.next().charAt(0);
        while(c != 't' && c != 'f' && c != 'y' && c != 'n') {
            System.out.println("Invalid answer. Please try again, using one of these words:\n" +
                    "'yes', 'no', 'true' or 'false'\n");
            System.out.print("→ ");
            c = sc.next().charAt(0);
        }

        setMigrates(c == 't' || c == 'y');

    }


    @Override
    String getInfo() {
        return String.format("Age: %d y. | Size: %.1f cm%n" +
                        "Active time: %s | Migrates: %s%n",
                super.getAge(),
                super.getSizeInCm(),
                this.getActiveTime().equals(ActiveTime.DAY) ? "day" : "night",
                this.migrates() ? "yes" : "no");
    }
}
