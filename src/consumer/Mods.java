package consumer;

import entities.Constants;
import sortare.ChooseContract;
import work.Consumatori;
import work.Contracts;
import work.Distribuitori;

import java.util.List;

public final class Mods {
    private ChooseContract chooseContract = new ChooseContract();

    /**
     * @param consumator
     * @param distribuitoriList
     */
    public void isNull(Consumatori consumator, List<Distribuitori> distribuitoriList) {
        chooseContract.sortare(distribuitoriList);
        consumator.setDistribuitor(distribuitoriList.get(0));
        consumator.setRemainedContractMonths(
                distribuitoriList.get(0).getContractLength());


        consumator.getDistribuitor().getContracte().add(
                new Contracts(consumator.getId(),
                        consumator.getDistribuitor().getContractPrice(),
                        consumator.getRemainedContractMonths()));
        consumator.setBudget(consumator.getBudget()
                + consumator.getMonthlyIncome());
        consumator.setMonthlyPayment(
                consumator.getDistribuitor().getContractPrice());
        if (consumator.getBudget()
                < consumator.getMonthlyPayment()) {
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
                    - consumator.getMonthlyPayment());
            consumator.getDistribuitor().setBudget(
                    consumator.getDistribuitor().getBudget()
                            + consumator.getMonthlyPayment());
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

    /**
     * @param consumator
     */
    public void isNotNull(Consumatori consumator) {
        if (consumator.getInDebt() == 0) {
            consumator.setBudget(consumator.getBudget()
                    + consumator.getMonthlyIncome());
            Contracts aux = null;
            for (Contracts contracte
                    : consumator.getDistribuitor().getContracte()) {
                if (contracte.getConsumerId() == consumator.getId()) {
                    aux = contracte;
                }
            }
            consumator.setMonthlyPayment(aux.getPrice());
            if (consumator.getBudget()
                    < consumator.getMonthlyPayment()) {
                consumator.setInDebt(consumator.getInDebt() + 1);

            } else {
                consumator.setBudget(consumator.getBudget()
                        - consumator.getMonthlyPayment());
                consumator.getDistribuitor().setBudget(
                        consumator.getDistribuitor().getBudget()
                                + consumator.getMonthlyPayment());
            }
            consumator.setRemainedContractMonths(
                    consumator.getRemainedContractMonths() - 1);
            for (Contracts contracte
                    : consumator.getDistribuitor().getContracte()) {
                if (contracte.getConsumerId() == consumator.getId()) {
                    contracte.setRemainedContractMonths(
                            consumator.getRemainedContractMonths());
                }
            }

        } else if (consumator.getInDebt() == 1) {
            consumator.setBudget(consumator.getBudget()
                    + consumator.getMonthlyIncome());
            Contracts aux = null;
            for (Contracts contracte
                    : consumator.getDistribuitor().getContracte()) {
                if (contracte.getConsumerId() == consumator.getId()) {
                    aux = contracte;
                }
            }
            consumator.setMonthlyPayment((int) (
                    Math.round(Math.floor(
                            Constants.PROFIT2
                                    * consumator.getMonthlyPayment()))
                            + aux.getPrice()));
            if (consumator.getBudget()
                    < consumator.getMonthlyPayment()) {
                consumator.setInDebt(consumator.getInDebt() + 1);
            } else {
                consumator.setBudget(consumator.getBudget()
                        - consumator.getMonthlyPayment());
                consumator.getDistribuitor().setBudget(
                        consumator.getDistribuitor().getBudget()
                                + consumator.getMonthlyPayment());
            }
            consumator.setRemainedContractMonths(
                    consumator.getRemainedContractMonths() - 1);
            for (Contracts contracte
                    : consumator.getDistribuitor().getContracte()) {
                if (contracte.getConsumerId() == consumator.getId()) {
                    contracte.setRemainedContractMonths(
                            consumator.getRemainedContractMonths());
                }
            }
        } else if (consumator.getInDebt() == 2) {
            consumator.setBankrupt(true);
            Contracts aux = null;
            for (Contracts contracte
                    : consumator.getDistribuitor().getContracte()) {
                if (consumator.getBankrupt()
                        && contracte.getConsumerId()
                        == consumator.getId()) {
                    aux = contracte;
                }
            }
            consumator.getDistribuitor().getContracte().remove(aux);
        }
    }
}
