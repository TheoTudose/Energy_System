package utils;

import work.Distribuitori;

import java.util.List;

public final class EndGame {
    private int s = 0;

    public int getS() {
        return s;
    }

    /**
     *
     * @param distribuitori
     */
    public void check(List<Distribuitori> distribuitori) {
        for (Distribuitori distribuitori1 : distribuitori) {
            if (distribuitori1.getBankrupt()) {
                s++;
            }
        }

    }
}
