package utils;

import work.MonthlyStats;
import work.Producatori;
import sortare.SortID;

import java.util.ArrayList;
import java.util.List;

public final class MonthStats {
     private SortID sortID = new SortID();

    public SortID getSortID() {
        return sortID;
    }
/**
 * Metoda copiaza sorteaza lista de id-uri de distribuitori a fiecarui producator si o adauga
 * intr-un obiect de tipul MonthlyStats, care la randul lui este adaugat in lista de MonthlyStats
 * a producatorului.*/
    public void print(List<Producatori> producatori, int i) {
        List<Producatori> producatoriFinal = new ArrayList<>(producatori);
        for (Producatori producator : producatoriFinal) {
            sortID.sortare(producator.getDistribuitori());
            List<Integer> copy = new ArrayList<Integer>(
                    producator.getDistribuitori());
            List<Integer> newCopy = new ArrayList<>(copy);

            MonthlyStats monthlyStats = new MonthlyStats(i + 1, newCopy);
            producator.getMonthlyStats().add(monthlyStats);
            producator.setWasModified(false);
        }
    }
}
