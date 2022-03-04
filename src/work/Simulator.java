package work;

import input.DataRead;
import input.Database;
import utils.DistributorActions;
import utils.EndGame;
import utils.FirstMonth;
import utils.MonthStats;
import consumer.UpdateConsumerValues;

import java.util.List;

public final class Simulator {
    private DataRead dataInput = new DataRead();

    /**
     * @param database
     * @param consumatori
     * @param distribuitori
     * @param producatori
     */
    public void run(Database database, List<Consumatori> consumatori,
                    List<Distribuitori> distribuitori, List<Producatori> producatori) {
        for (int i = -1; i < database.getNumberOfTurns(); i++) {
            EndGame endGame = new EndGame();
            MonthStats monthStats = new MonthStats();
            UpdateConsumerValues consumerUpdate = new UpdateConsumerValues();
            DistributorActions distributorActions = new DistributorActions();
            FirstMonth firstMonth = new FirstMonth();
//PRIMA RUNDA
            if (i == -1) {
                firstMonth.update(consumatori, distribuitori, producatori);
            }

//END RUNDA 0;

            if (i >= 0) {

                //Citire Actualizari Valori Distribuitori
                dataInput.distributorsUpdate(database, distribuitori, i);

                //Citire Actualizari Valori Consumatori
                dataInput.consumerAdd(database, consumatori, i);

                //Modificare Valori Distribuitori
                distributorActions.contractPrice(distribuitori);

                //Modificare Valori Consumatori
                consumerUpdate.update(consumatori, distribuitori);

                //Plata Costuri Distribuitori \ Verificare Bankrupt
                distributorActions.pay(distribuitori);

                //Actualizare Date Producatori
                dataInput.producersUpdate(database, producatori, i);

                //Actualizare Production Cost
                distributorActions.productionCost(distribuitori, producatori);

                //Adaugare obiecte de tip MonthlyStats
                monthStats.print(producatori, i);

                //Verificare daca toti distribuitorii sunt bankrupt
                int s = 0;
                endGame.check(distribuitori);
                s += endGame.getS();
                if (s == distribuitori.size()) {
                    break;
                }
            }
        }
    }
}
