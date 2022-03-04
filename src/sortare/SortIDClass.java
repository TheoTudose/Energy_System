package sortare;

import work.Distribuitori;

import java.util.Comparator;
import java.util.List;

public final class SortIDClass {
    /**
     * Clasa sorteaza crescator o lista de tipul clasei Distribuitori
     */
    public void sortare(List<Distribuitori> distribuitori) {
        distribuitori.sort(Comparator.comparingInt(Distribuitori::getId));
    }
}
