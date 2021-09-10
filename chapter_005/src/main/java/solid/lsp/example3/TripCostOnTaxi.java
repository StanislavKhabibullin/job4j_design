package solid.lsp.example3;

public class TripCostOnTaxi extends TripCost {
    public TripCostOnTaxi(int pathLength, boolean benefit, float priceForkm) {
        super(pathLength, benefit, priceForkm);
    }

    @Override
    float tripPrice() {
        float price = priceForkm; // пропущено условие льготного проезда
        price = price * pathLength;
        return price;
    }
}
