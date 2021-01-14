package farmsimulator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Farm implements Alive {
    private Collection<Cow> cows;
    private String owner;
    private Barn barn;

    public Farm(String owner, Barn barn) {
        cows = new ArrayList<>();
        this.owner = owner;
        this.barn = barn;
    }

    public String getOwner() {
        return owner;
    }

    public Collection<Cow> getCows() {
        return cows;
    }

    public Barn getBarn() {
        return barn;
    }

    @Override
    public String toString() {
        StringBuilder bob = new StringBuilder();
        bob.append("Farm owner: " + owner)
                .append("\nBarn bulk tank: " + barn.toString())
                .append("\n");
        if (cows.isEmpty()) {
            bob.append("No cows.");
        } else {
            bob.append("Animals:\n");
            for (Cow cow : cows) {
                bob.append("  " + cow + "\n");
            }
        }
        return bob.toString();
    }

    public void addCow(Cow cow) {
        cows.add(cow);
    }

    @Override
    public void liveHour() {
        for (Cow cow : cows) {
            cow.liveHour();
        }
    }

    public void manageCows() {
        barn.takeCareOf(cows);
    }

    public void installMilkingRobot(MilkingRobot robot) {
        barn.installMilkingRobot(robot);
    }
}
