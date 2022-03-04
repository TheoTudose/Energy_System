package sortare;

import java.util.Comparator;
import java.util.List;

public final class SortID {
    /**
     * Clasa sorteaza crescator o lista de tip Integer
     */
    public void sortare(List<Integer> distribuitori) {
        distribuitori.sort(Comparator.comparingInt(o -> o));
    }
}
