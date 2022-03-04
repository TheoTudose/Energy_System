package work;

import strategies.EnergyChoiceStrategyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public final class Distribuitori implements Observer {
    private Integer id;
    private int contractLength;
    private int budget;
    private int infrastructureCost;
    private long productionCost;
    private List<Contracts> contracte = new ArrayList<>();
    private int contractPrice;
    private List<Producatori> producatori = new ArrayList<>();
    private int energyNeededKW;
    private EnergyChoiceStrategyType producerStrategy;
    private boolean isBankrupt = false;
    private int energyReceived = 0;
    private boolean modify = false;

    public boolean isModify() {
        return modify;
    }

    public void setModify(boolean modify) {
        this.modify = modify;
    }

    public int getEnergyReceived() {
        return energyReceived;
    }

    public void setEnergyReceived(int energyReceived) {
        this.energyReceived = energyReceived;
    }

    public boolean getBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public int getEnergyNeededKW() {
        return energyNeededKW;
    }

    public void setEnergyNeededKW(int energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    public EnergyChoiceStrategyType getProducerStrategy() {
        return producerStrategy;
    }

    public void setProducerStrategy(EnergyChoiceStrategyType producerStrategy) {
        this.producerStrategy = producerStrategy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(int contractLength) {
        this.contractLength = contractLength;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getInfrastructureCost() {
        return infrastructureCost;
    }

    public void setInfrastructureCost(int infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    public long getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(long productionCost) {
        this.productionCost = productionCost;
    }

    public List<Contracts> getContracte() {
        return contracte;
    }


    public void setContractPrice(int contractPrice) {
        this.contractPrice = contractPrice;
    }

    public int getContractPrice() {
        return contractPrice;
    }

    public List<Producatori> getProducatori() {
        return producatori;
    }


    public Distribuitori(Integer id, int contractLength, int budget, int infrastructureCost,
                         int energyNeededKW, EnergyChoiceStrategyType producerStrategy) {
        this.id = id;
        this.contractLength = contractLength;
        this.budget = budget;
        this.infrastructureCost = infrastructureCost;
        this.energyNeededKW = energyNeededKW;
        this.producerStrategy = producerStrategy;
    }

    public Distribuitori() {
    }

    @Override
    public void update(Observable o, Object modify) {
        this.setModify((Boolean) modify);
    }
}
