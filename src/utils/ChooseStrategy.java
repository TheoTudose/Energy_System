package utils;

import strategies.Context;
import strategies.GreenStrategy;
import strategies.PriceStrategy;
import strategies.QuantityStrategy;
import strategies.EnergyChoiceStrategyType;
import work.Distribuitori;
import work.Producatori;

import java.util.List;

public class ChooseStrategy {
   private CostDetermination costDetermination = new CostDetermination();
   private GreenStrategy green = new GreenStrategy();
   private PriceStrategy price = new PriceStrategy();
   private QuantityStrategy quantity = new QuantityStrategy();

    public final CostDetermination getCostDetermination() {
        return costDetermination;
    }

    public final void setCostDetermination(CostDetermination costDetermination) {
        this.costDetermination = costDetermination;
    }

    public final GreenStrategy getGreen() {
        return green;
    }

    public final void setGreen(GreenStrategy green) {
        this.green = green;
    }

    public final PriceStrategy getPrice() {
        return price;
    }

    public final void setPrice(PriceStrategy price) {
        this.price = price;
    }

    public final QuantityStrategy getQuantity() {
        return quantity;
    }

    public final void setQuantity(QuantityStrategy quantity) {
        this.quantity = quantity;
    }
    /**
     * Metoda care alege strategia in functie de EnergyChoiceStrategyType
     */
    public final double strategyChooser(Distribuitori distribuitor, List<Producatori> producatori) {
        if (distribuitor.getProducerStrategy()
                == EnergyChoiceStrategyType.GREEN) {
            Context context = new Context(new GreenStrategy());
            context.executeStrategy(producatori);
            return costDetermination.costFind(distribuitor, producatori);

        } else if (distribuitor.getProducerStrategy()
                == EnergyChoiceStrategyType.PRICE) {
            Context context = new Context(new PriceStrategy());
            context.executeStrategy(producatori);
           return costDetermination.costFind(distribuitor, producatori);

        } else if (distribuitor.getProducerStrategy()
                == EnergyChoiceStrategyType.QUANTITY) {
            Context context = new Context(new QuantityStrategy());
            context.executeStrategy(producatori);
           return costDetermination.costFind(distribuitor, producatori);
        }
        return 0;
    }
}
