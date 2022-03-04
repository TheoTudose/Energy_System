package consumer;

import sortare.ChooseContract;
import work.Consumatori;
import work.Contracts;
import work.Distribuitori;

import java.util.ArrayList;
import java.util.List;

public final class UpdateConsumerValues {
    private ChooseContract chooseContract = new ChooseContract();
    private Mods mods = new Mods();

    /**
     * Metoda modifica toate valorile consumatorilor dintr-o runda.
     * */
    public void update(List<Consumatori> consumatori, List<Distribuitori> distribuitori) {
        for (Consumatori consumator : consumatori) {
            if (consumator.getRemainedContractMonths() == 0
                    || consumator.getDistribuitor().getBankrupt()) {
                Contracts aux = null;
                if (consumator.getDistribuitor() != null) {
                    for (Contracts contracte
                            : consumator.getDistribuitor().getContracte()) {

                        if (contracte.getConsumerId() == consumator.getId()) {
                            aux = contracte;
                            break;
                        }
                    }
                    if (consumator.getDistribuitor().getContracte().contains(aux)) {
                        consumator.getDistribuitor().getContracte().remove(aux);
                    }
                }
                consumator.setDistribuitor(null);
            }
            List<Distribuitori> distribuitoriList
                    = new ArrayList<>(distribuitori);
            if (consumator.getBankrupt()) {
                continue;
            }
            if (consumator.getDistribuitor() == null) {
               mods.isNull(consumator, distribuitoriList);
            } else if (consumator.getDistribuitor() != null) {
               mods.isNotNull(consumator);
            }
        }
    }
}
