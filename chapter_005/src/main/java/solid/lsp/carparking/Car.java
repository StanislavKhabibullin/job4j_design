package solid.lsp.carparking;

public class Car implements Auto {
    private int carSize;

    public Car(int carSize) {
        this.carSize = carSize;
    }

    @Override
    public int size() {
        return carSize;
    }
}
