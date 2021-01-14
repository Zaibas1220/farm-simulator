package farmsimulator;

public class MilkingRobot {
    private BulkTank bulkTank;

    public MilkingRobot() {

    }

    public BulkTank getBulkTank() {
        return this.bulkTank;
    }

    public void setBulkTank(BulkTank tank) {
        this.bulkTank = tank;
    }

    public void milk(Milkable milkable){
        if (this.bulkTank == null){
            throw new IllegalStateException("No tank connected to the milking robot");
        }
        this.bulkTank.addToTank(milkable.milk());
    }
}
