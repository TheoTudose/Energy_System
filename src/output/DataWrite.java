package output;

import work.Consumatori;
import work.Distribuitori;
import work.Producatori;

import java.util.List;

public final class DataWrite {
    /**
     * Metoda copiaza Lista consumatorilor pe lista de output.
     * */
    public void writeConsumers(List<Consumatori> consumatori, OutputClass outputClass) {
        for (Consumatori consumatori1 : consumatori) {
            outputClass.getConsumers().add(new output.Consumers(consumatori1.getId(),
                    consumatori1.getBankrupt(), consumatori1.getBudget()));
        }
    }
    /**
     * Metoda copiaza Lista distribuitorilor pe lista de output.
     * */
    public void writeDistributors(List<Distribuitori> distribuitori, OutputClass outputClass) {
        for (Distribuitori distribuitori1 : distribuitori) {
            outputClass.getDistributors().add(
                    new output.Distributors(distribuitori1.getId(),
                            distribuitori1.getEnergyNeededKW(), distribuitori1.getContractPrice(),
                            distribuitori1.getBudget(), distribuitori1.getProducerStrategy(),
                            distribuitori1.getBankrupt(), distribuitori1.getContracte()));
        }
    }
    /**
     * Metoda copiaza lista distribuitorilor pe lista de output.
     * */
    public void writeProducers(List<Producatori> producatori, OutputClass outputClass) {
        for (Producatori producatori1 : producatori) {
            outputClass.getEnergyProducers().add(new EnergyProducers(producatori1.getId(),
                    producatori1.getMaxDistributors(), producatori1.getPriceKW(),
                    producatori1.getEnergyType(), producatori1.getEnergyPerDistributor(),
                    producatori1.getMonthlyStats()));
        }
    }
}
