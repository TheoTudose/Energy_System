package input;

import java.util.List;


public final class InitialData {
 private List<Consumers> consumers;
 private List<Distributors> distributors;
 private List<Producers> producers;

    public List<Producers> getProducers() {
        return producers;
    }

    public void setProducers(List<Producers> producers) {
        this.producers = producers;
    }

    public List<Consumers> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<Consumers> consumers) {
        this.consumers = consumers;
    }

    public List<Distributors> getDistributors() {
        return distributors;
    }

    public void setDistributors(List<Distributors> distributors) {
        this.distributors = distributors;
    }

    public InitialData(List<Consumers> consumers, List<Distributors> distributors,
                       List<Producers> producers) {
        this.consumers = consumers;
        this.distributors = distributors;
        this.producers = producers;
    }

    public InitialData() {
    }
}
