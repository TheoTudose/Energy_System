package work;

import entities.EnergyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public final class Producatori extends Observable {
    private int id;
    private EnergyType energyType;
    private int maxDistributors;
    private int noOfDistributors = 0;
    private List<Integer> distribuitori = new ArrayList<>();
    private double priceKW;
    private int energyPerDistributor;
    private Boolean wasModified = false;
    private List<MonthlyStats> monthlyStats = new ArrayList<>();

    public int getMaxDistributors() {
        return maxDistributors;
    }

    public void setMaxDistributors(int maxDistributors) {
        this.maxDistributors = maxDistributors;
    }

    public List<MonthlyStats> getMonthlyStats() {
        return monthlyStats;
    }

    public void setMonthlyStats(List<MonthlyStats> monthlyStats) {
        this.monthlyStats = monthlyStats;
    }

    public Boolean getWasModified() {
        return wasModified;
    }

    public void setWasModified(Boolean wasModified) {
        this.wasModified = wasModified;
    }

    public int getNoOfDistributors() {
        return noOfDistributors;
    }

    public void setNoOfDistributors(int noOfDistributors) {
        this.noOfDistributors = noOfDistributors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
    }

    public List<Integer> getDistribuitori() {
        return distribuitori;
    }

    public double getPriceKW() {
        return priceKW;
    }

    public void setPriceKW(double priceKW) {
        this.priceKW = priceKW;
    }

    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    public void setEnergyPerDistributor(int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    public Producatori(int id, EnergyType energyType, int maxDistributors, double priceKW,
                       int energyPerDistributor) {
        this.id = id;
        this.energyType = energyType;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyPerDistributor = energyPerDistributor;
    }

    /**
     * Metoda notifica observatorul ca getWasModified a fost schimbat
     */
    public void notification() {
        if (getWasModified()) {
            setChanged();
            notifyObservers(getWasModified());
        }
    }
}
