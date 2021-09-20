package solid.lsp.carparking;

public class Truck implements Auto {
    private int truckSize;

    public Truck(int truckSize) {
        this.truckSize = truckSize;
    }

    @Override
    public int size() {
        return truckSize;
    }
}
