package work;

public final class Consumatori {
    private int id;
    private int budget;
    private int monthlyIncome;
    private boolean isBankrupt = false;
    private Distribuitori distribuitor;
    private int monthlyPayment;
    private int inDebt = 0;

    public int getRemainedContractMonths() {
        return remainedContractMonths;
    }

    public void setRemainedContractMonths(int remainedContractMonths) {
        this.remainedContractMonths = remainedContractMonths;
    }

    private int remainedContractMonths;

    public int getInDebt() {
        return inDebt;
    }

    public void setInDebt(int inDebt) {
        this.inDebt = inDebt;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public boolean getBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public Distribuitori getDistribuitor() {
        return distribuitor;
    }

    public void setDistribuitor(Distribuitori distribuitor) {
        this.distribuitor = distribuitor;
    }

    public Consumatori(int id, int budget, int monthlyIncome) {
        this.id = id;
        this.budget = budget;
        this.monthlyIncome = monthlyIncome;
    }
}
