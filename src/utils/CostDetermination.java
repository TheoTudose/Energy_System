package utils;

import work.Distribuitori;
import work.Producatori;

import java.util.List;

public class CostDetermination {
    /**
     * Metoda Care calculeaza cati producatori mai sunt necesari pentru a indeplini nevoia de
     * energie a unui Distribuitor si ii adauga in lista distribuitorului.
     */
    public final double costFind(Distribuitori distribuitor, List<Producatori> producatori) {
        double cost = 0;
        for (Producatori workProducator : producatori) {
            if (workProducator.getNoOfDistributors()
                    == workProducator.getMaxDistributors()) {
                continue;
            }
            if (distribuitor.getEnergyReceived()
                    < distribuitor.getEnergyNeededKW()) {
                distribuitor.getProducatori().add(workProducator);
                distribuitor.setEnergyReceived(
                        distribuitor.getEnergyReceived()
                                + workProducator.getEnergyPerDistributor());
                workProducator.setNoOfDistributors(
                        workProducator.getNoOfDistributors() + 1);
                workProducator.getDistribuitori().add(distribuitor.getId());

                cost += workProducator.getEnergyPerDistributor() * workProducator.getPriceKW();
            }
        }
        return cost;
    }
}
