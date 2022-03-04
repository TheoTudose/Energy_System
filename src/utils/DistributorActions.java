package utils;

import work.Distribuitori;
import work.Producatori;
import sortare.SortIDClass;
import entities.Constants;

import java.util.ArrayList;
import java.util.List;

public final class DistributorActions {
    /**
     * Metoda calculeaza noile preturi ale cotractelor in functie de numarul de clienti
     * */
    public void contractPrice(List<Distribuitori> distribuitori) {
        for (Distribuitori distribuitor : distribuitori) {
            if (distribuitor.getContracte().size() > 0) {
                distribuitor.setContractPrice((int) Math.round(Math.floor((float)
                        distribuitor.getInfrastructureCost()
                        / distribuitor.getContracte().size())
                        + distribuitor.getProductionCost()
                        + Math.round(Math.floor(Constants.PROFIT
                        * distribuitor.getProductionCost()))));
            } else if (distribuitor.getContracte().size() == 0) {
                distribuitor.setContractPrice((int) (
                        distribuitor.getInfrastructureCost()
                                + distribuitor.getProductionCost()
                                + Math.round(Math.floor(Constants.PROFIT
                                * distribuitor.getProductionCost()))));

            }
        }
    }
    /**
     * Metoda scade din bugetele distribuitorilor, cheltuielile lunare catre producatori
     * */
    public void pay(List<Distribuitori> distribuitori) {
        for (Distribuitori distribuitori2 : distribuitori) {
            if (!distribuitori2.getBankrupt()) {
                distribuitori2.setBudget((int) (distribuitori2.getBudget()
                        - distribuitori2.getInfrastructureCost()
                        - distribuitori2.getProductionCost()
                        * distribuitori2.getContracte().size()));
                if (distribuitori2.getBudget() <= 0) {
                    distribuitori2.setBankrupt(true);
                }
            }
        }
    }
   private SortIDClass sortIDClass = new SortIDClass();
    private ChooseStrategy chooseStrategy = new ChooseStrategy();

/**Metoda calculeaza costul de productie*/
    public void productionCost(List<Distribuitori> distribuitori, List<Producatori> producatori) {
        List<Distribuitori> changeDistribs = new ArrayList<>();
        List<Distribuitori> distribuitoris = new ArrayList<>(distribuitori);
        for (Distribuitori distribuitori1 : distribuitoris) {
            if (distribuitori1.getBankrupt()) {
                continue;
            }


            for (Producatori producator : distribuitori1.getProducatori()) {
                producator.addObserver(distribuitori1);
                producator.notification();
            }
            if (distribuitori1.isModify()) {
                changeDistribs.add(distribuitori1);
                sortIDClass.sortare(changeDistribs);
            }
        }
        double cost1;
        for (Distribuitori distribuitori1 : changeDistribs) {
            List<Producatori> producatoriList = new ArrayList<>(producatori);
            if (distribuitori1.isModify()) {
                for (Producatori producatori1 : producatoriList) {
                    if (producatori1.getDistribuitori().
                            contains(distribuitori1.getId())) {
                        producatori1.getDistribuitori().
                                remove(distribuitori1.getId());
                        producatori1.deleteObserver(distribuitori1);
                        producatori1.setNoOfDistributors(
                                producatori1.getNoOfDistributors() - 1);
                        distribuitori1.setEnergyReceived(0);
                    }
                }


                cost1 = chooseStrategy.strategyChooser(
                        distribuitori1, producatoriList);
                distribuitori1.setProductionCost(
                        Math.round(Math.floor(cost1 / Constants.DIV)));
                distribuitori1.setModify(false);

            }
        }
        for (Producatori producator : producatori) {
            producator.setWasModified(false);
        }
        changeDistribs.clear();
    }
}
