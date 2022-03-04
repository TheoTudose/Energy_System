package input;

import work.Consumatori;
import work.Distribuitori;
import work.Producatori;
import java.util.List;

public final class DataRead {
    /**
     * Metoda citeste Consumatorii si ii adauga in liste
     * */
    public void readConsumers(Database database, List<Consumatori> consumatori) {
        for (input.Consumers consumer : database.getInitialData().getConsumers()) {
            consumatori.add(new Consumatori(consumer.getId(), consumer.getInitialBudget(),
                    consumer.getMonthlyIncome()));
        }
    }
    /**
     * Metoda citeste Distribuitorii si ii adauga in liste
     * */
    public void readDistributors(Database database, List<Distribuitori> distribuitori) {
        for (input.Distributors distributor : database.getInitialData().getDistributors()) {
            distribuitori.add(new Distribuitori(distributor.getId(),
                    distributor.getContractLength(), distributor.getInitialBudget(),
                    distributor.getInitialInfrastructureCost(), distributor.getEnergyNeededKW(),
                    distributor.getProducerStrategy()));
        }
    }
    /**
     * Metoda citeste Producatorii si ii adauga in liste
     * */
    public void readProducers(Database database, List<Producatori> producatori) {
        for (input.Producers producer : database.getInitialData().getProducers()) {
            producatori.add(new Producatori(producer.getId(), producer.getEnergyType(),
                    producer.getMaxDistributors(), producer.getPriceKW(),
                    producer.getEnergyPerDistributor()));
        }
    }
    /**
     * Metoda citeste Update-urile lunare ale distribuitorilor si le modifica in liste
     * */
    public void distributorsUpdate(Database database, List<Distribuitori> distribuitori, int i) {
        if (database.getMonthlyUpdates().get(i).getDistributorChanges().size()
                != 0) {
            for (DistributorChanges change
                    : database.getMonthlyUpdates().
                    get(i).getDistributorChanges()) {
                distribuitori.get(change.getId()).setInfrastructureCost(
                        change.getInfrastructureCost());
            }
        }
    }
    /**
     * Metoda citeste Update-urile lunare si adauga consumatorii noi in lista de consumatori
     * */
    public void consumerAdd(Database database, List<Consumatori> consumatori, int i) {
        if (database.getMonthlyUpdates().get(i).getNewConsumers().size() != 0) {
            for (Consumers consumer
                    : database.getMonthlyUpdates().get(i).getNewConsumers()) {
                consumatori.add(new Consumatori(consumer.getId(),
                        consumer.getInitialBudget(),
                        consumer.getMonthlyIncome()));
            }
        }
    }
    private int k = 0;

    public int getK() {
        return k;
    }

    /**
     * Metoda citeste Update-urile lunare ale producatorilor si le modifica in liste
     * */
    public void producersUpdate(Database database, List<Producatori> producatori, int i) {
        if (database.getMonthlyUpdates().get(i).getProducerChanges().size()
                != 0) {
            for (ProducerChanges producerChanges
                    : database.getMonthlyUpdates().get(i).getProducerChanges()) {
                producatori.get(producerChanges.getId()).
                        setEnergyPerDistributor(
                                producerChanges.getEnergyPerDistributor());
                producatori.get(producerChanges.getId()).setWasModified(true);
                k++;
            }
        }
    }
}
