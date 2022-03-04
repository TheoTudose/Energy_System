package strategies;

import work.Producatori;


import java.util.List;

public final class QuantityStrategy implements Strategy {

        @Override
        public void sortare(List<Producatori> producatori) {
            producatori.sort((o1, o2) -> {
                if (o2.getEnergyPerDistributor()
                        - o1.getEnergyPerDistributor() == 0) {
                return o2.getId() - o1.getId();
            } else {
                    return  o2.getEnergyPerDistributor() - o1.getEnergyPerDistributor();
                }
            }
            );
        }
}
