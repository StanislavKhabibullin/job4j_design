package solid.lsp.example3;

public class TripCostOnTaxi extends TripCost {
    public TripCostOnTaxi(int pathLength, boolean benefit, float priceForkm) {
        super(pathLength, benefit, priceForkm);
    }

    @Override
    float tripPrice() {
        /**
         * // пропущено условие льготного проезда
         */
        float price = priceForkm;
        price = price * pathLength;
        return price;
    }
}
