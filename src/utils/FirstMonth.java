package utils;

import entities.Constants;
import sortare.ChooseContract;
import work.Consumatori;
import work.Producatori;
import work.Distribuitori;
import work.Contracts;

import java.util.ArrayList;
import java.util.List;

public final class FirstMonth {
    private ChooseStrategy chooseStrategy = new ChooseStrategy();
    private ChooseContract chooseContract = new ChooseContract();

    public ChooseStrategy getChooseStrategy() {
        return chooseStrategy;
    }

    public ChooseContract getChooseContract() {
        return chooseContract;
    }

    /**
     *
     * @param consumatori
     * @param distribuitori
     * @param producatori
     */
    public void update(List<Consumatori> consumatori, List<Distribuitori> distribuitori,
                       List<Producatori> producatori) {
        List<Distribuitori> distribuitoriCopy = new ArrayList<>(distribuitori);
        for (Distribuitori distribuitor : distribuitoriCopy) {
            List<Producatori> workProducatori = new ArrayList<>(producatori);
            double cost = 0;
            long profit;

//Strategii
            cost = chooseStrategy.strategyChooser(distribuitor, workProducatori);

//Setare Cost Prodiuctie, Profit si Pretul initial al contractului
            distribuitor.setProductionCost(Math.round(Math.floor(
                    cost / Constants.DIV)));

            profit = Math.round(Math.floor(Constants.PROFIT
                    * distribuitor.getProductionCost()));
            distribuitor.setContractPrice((int)
                    (distribuitor.getInfrastructureCost()
                            + distribuitor.getProductionCost() + profit));
        }
        for (Consumatori consumator : consumatori) {

            List<Distribuitori> workDistribuitori = new ArrayList<>(distribuitori);
            chooseContract.sortare(workDistribuitori);
            consumator.setDistribuitor(workDistribuitori.get(0));
            consumator.setRemainedContractMonths(
                    workDistribuitori.get(0).getContractLength());
            workDistribuitori.get(0).getContracte().add(
                    consumator.getId(), new Contracts(consumator.getId(),
                            workDistribuitori.get(0).getContractPrice(),
                            consumator.getRemainedContractMonths()));
            consumator.setBudget(consumator.getBudget()
                    + consumator.getMonthlyIncome());
            consumator.setMonthlyPayment(
                    consumator.getDistribuitor().getContractPrice());
            if (consumator.getBudget()
                    < workDistribuitori.get(0).getContractPrice()) {
                consumator.setInDebt(consumator.getInDebt() + 1);
                consumator.setRemainedContractMonths(
                        consumator.getRemainedContractMonths() - 1);
                for (Contracts contracte
                        : consumator.getDistribuitor().getContracte()) {
                    if (contracte.getConsumerId() == consumator.getId()) {
                        contracte.setRemainedContractMonths(
                                consumator.getRemainedContractMonths());
                    }
                }

            } else {
                consumator.setBudget(consumator.getBudget()
                        - workDistribuitori.get(0).getContractPrice());
                workDistribuitori.get(0).setBudget(
                        workDistribuitori.get(0).getBudget()
                                + workDistribuitori.get(0).getContractPrice());
                consumator.setRemainedContractMonths(
                        consumator.getRemainedContractMonths() - 1);
                for (Contracts contracte
                        : consumator.getDistribuitor().getContracte()) {
                    if (contracte.getConsumerId() == consumator.getId()) {
                        contracte.setRemainedContractMonths(
                                consumator.getRemainedContractMonths());
                    }
                }
            }
        }
        for (Distribuitori distribuitori1 : distribuitori) {
            distribuitori1.setBudget((int) (distribuitori1.getBudget()
                    - distribuitori1.getInfrastructureCost()
                    - distribuitori1.getProductionCost()
                    * distribuitori1.getContracte().size()));
            if (distribuitori1.getBudget() <= 0) {
                distribuitori1.setBankrupt(true);
            }
        }
    }
}

