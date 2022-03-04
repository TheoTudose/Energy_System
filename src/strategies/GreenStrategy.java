package strategies;

import work.Producatori;

import java.util.List;

public final class GreenStrategy implements Strategy {

    @Override
    public void sortare(List<Producatori> producatori) {
        producatori.sort((o1, o2) -> {
            if (o1.getEnergyType().isRenewable()
                    && !o2.getEnergyType().isRenewable()) {
            return -1;
        } else if (!o1.getEnergyType().isRenewable() && o2.getEnergyType().isRenewable()) {
            return 1;
        } else if (o1.getPriceKW() - o2.getPriceKW() == 0) {
            if (o2.getEnergyPerDistributor() - o1.getEnergyPerDistributor() == 0) {
                return o1.getId() - o2.getId();
            } else {
                return o2.getEnergyPerDistributor() - o1.getEnergyPerDistributor();
            }
        } else {
                return Double.compare(o1.getPriceKW(), o2.getPriceKW());
            }
        }
        );
    }

}
