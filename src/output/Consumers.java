package output;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Consumers {
    private int id;
    private boolean isBankrupt;
    private int budget;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("isBankrupt")
    public boolean getBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Consumers(int id, boolean isBankrupt, int budget) {
        this.id = id;
        this.isBankrupt = isBankrupt;
        this.budget = budget;
    }





}
