package solid.lsp.carparking;

import java.util.List;

public interface Parking {
    boolean parking(Auto auto);
    //вводится информация о парковке - на входе 2 массива с перечнем мест для легковых и грузовых авто
    //данный метод должен будет заполнить две таблицы Hashtable<Integer, Boolean> carPlaces/truckPlaces
    //которые в свою очередь будт являться полями класса парковки


}
