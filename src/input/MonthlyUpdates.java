package input;

import java.util.List;


public final class MonthlyUpdates {
    private List<Consumers> newConsumers;
    private List<DistributorChanges> distributorChanges;
    private List<ProducerChanges> producerChanges;

    public List<Consumers> getNewConsumers() {
        return newConsumers;
    }

    public void setNewConsumers(List<Consumers> newConsumers) {
        this.newConsumers = newConsumers;
    }

    public List<DistributorChanges> getDistributorChanges() {
        return distributorChanges;
    }

    public void setDistributorChanges(List<DistributorChanges> distributorChanges) {
        this.distributorChanges = distributorChanges;
    }

    public List<ProducerChanges> getProducerChanges() {
        return producerChanges;
    }

    public void setProducerChanges(List<ProducerChanges> producerChanges) {
        this.producerChanges = producerChanges;
    }

    public MonthlyUpdates() {
    }

    public MonthlyUpdates(List<Consumers> newConsumers,
                          List<DistributorChanges> distributorChanges,
                          List<ProducerChanges> producerChanges) {
        this.newConsumers = newConsumers;
        this.distributorChanges = distributorChanges;
        this.producerChanges = producerChanges;
    }
}
