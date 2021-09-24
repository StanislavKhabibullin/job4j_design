package solid.lsp.carparking;

public class Car implements Auto {
    private int carSize = 1;

    public Car() {
    }

    @Override
    public int size() {
        return carSize;
    }
}
