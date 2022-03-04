package input;

public final class DistributorChanges {
    private int id;
    private int infrastructureCost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfrastructureCost() {
        return infrastructureCost;
    }

    public void setInfrastructureCost(int infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    public DistributorChanges(int id, int infrastructureCost) {
        this.id = id;
        this.infrastructureCost = infrastructureCost;
    }

    public DistributorChanges() {
    }
}
