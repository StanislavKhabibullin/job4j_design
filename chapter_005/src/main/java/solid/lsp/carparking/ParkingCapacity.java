package solid.lsp.carparking;

import java.util.Hashtable;

public interface ParkingCapacity {
    /**
     *  возвращает количество мест парковки для легковых авто
     * @param carPlaces
     * @return
     */
    int carCapacity(Hashtable<Integer, Boolean> carPlaces);

    /**
     * возвращает количество мест парковки для грузовых авто
     * @param carPlaces
     * @param truckPlaces
     * @return
     */
    int truckCapacity(Hashtable<Integer, Boolean> carPlaces,
                      Hashtable<Integer, Boolean> truckPlaces);
}
