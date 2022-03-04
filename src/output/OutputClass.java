package output;

import java.util.List;

public final class OutputClass {
    private List<Consumers> consumers;
    private List<Distributors> distributors;
    private List<EnergyProducers> energyProducers;

    public List<output.Consumers> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<output.Consumers> consumers) {
        this.consumers = consumers;
    }

    public List<output.Distributors> getDistributors() {
        return distributors;
    }

    public void setDistributors(List<output.Distributors> distributors) {
        this.distributors = distributors;
    }

    public List<output.EnergyProducers> getEnergyProducers() {
        return energyProducers;
    }

    public void setEnergyProducers(List<output.EnergyProducers> energyProducers) {
        this.energyProducers = energyProducers;
    }

    public OutputClass(List<output.Consumers> consumers, List<output.Distributors> distributors,
                       List<output.EnergyProducers> energyProducers) {
        this.consumers = consumers;
        this.distributors = distributors;
        this.energyProducers = energyProducers;
    }
}
