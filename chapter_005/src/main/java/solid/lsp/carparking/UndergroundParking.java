package solid.lsp.carparking;

public class UndergroundParking implements Parking {
    public Integer vacant = 30;

    @Override
    public boolean parking(Auto auto) {
        if ((vacant - auto.size()) >= 0) {
            vacant = vacant - auto.size();
            return true;
        }
        return false;
    }
}
