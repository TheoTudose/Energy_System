package strategies;

import work.Producatori;

import java.util.List;

public class Context {
    private Strategy strategy;

    public Context(strategies.Strategy strategy) {
        this.strategy = strategy;
    }
    /**
     * clasa care folosește/execută strategiile
     * implementată pentru Strategy Pattern
     */
    public void executeStrategy(List<Producatori> producatori) {
        strategy.sortare(producatori);
    }
}
