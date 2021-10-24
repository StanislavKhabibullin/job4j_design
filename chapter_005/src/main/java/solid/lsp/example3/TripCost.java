package solid.lsp.example3;

public class TripCost {
    /**
     *  длина пути
     *  льгота на поездку
     * стоимость за км
     */
    int pathLength;
    boolean benefit;
    float priceForkm;

    public TripCost(int pathLength, boolean benefit, float priceForkm) {
        this.pathLength = pathLength;
        this.benefit = benefit;
        this.priceForkm = priceForkm;
    }

    float tripPrice() {
        float price = priceForkm;
        if (benefit) {
            price = price / 2;
        }
        price = price * pathLength;
        return price;
    }
}
