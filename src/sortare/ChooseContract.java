package sortare;

import work.Distribuitori;

import java.util.List;

public final class ChooseContract {
    /**
     * Clasa gandita sa sorteze distribuitorii , crescator, in functie de pretul contractului,
     * iar apoi dupa id.
     */
    public void sortare(List<Distribuitori> distribuitori) {
        distribuitori.sort((o1, o2) -> {
            if (o2.getContractPrice() - o1.getContractPrice() == 0) {
            return o1.getId() - o2.getId();
        } else {
                return o1.getContractPrice() - o2.getContractPrice();
            }
        }
        );
    }
}
