package solid.lsp.carParking;

import java.util.Hashtable;
import java.util.List;

public interface ParkingCapacity {
    int carCapacity(Hashtable<Integer, Boolean> carPlaces);  //возвращает количество мест парковки для легковых авто
    int truckCapacity(Hashtable<Integer, Boolean> carPlaces,
                      Hashtable<Integer, Boolean> truckPlaces); //возвращает количество мест парковки для грузовых авто
}
