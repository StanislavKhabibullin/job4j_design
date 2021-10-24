package solid.lsp.carparking;

import java.util.Hashtable;

public interface FilingCarParking {
    /**
     * //заполняет машиноместа при въезде легкового авто
     * //возвращает информацию с перечнем мест для легковых авто
     * //выбрасывает исключение если место занято
     * @param carPlaceNumber
     * @return
     */
    Hashtable<Integer, Boolean> carInput(Integer carPlaceNumber);

    /**
     * //заполняет машиноместа при въезде грузового авто
     * //возвращает информацию с перечнем мест для легковых авто
     * //выбрасывает исключение если место занято
     * @param truckPlaceNumber
     * @return
     */
    Hashtable<Integer, Boolean> truckInput(Integer truckPlaceNumber);

    /**
     *  //освобождает машиноместо при выезде авто
     *  //возвращает информацию с перечнем мест для легковых авто
     *  //выбрасывает исключение если место занято
     * @param carPlaceNumber
     * @return
     */
    Hashtable<Integer, Boolean> carOutput(Integer carPlaceNumber);

    /**
     *  //освобождает машиноместа при въезде грузового авто
     *  //возвращает информацию с перечнем мест для легковых авто
     *  //выбрасывает исключение если место занято
     * @param truckPlaceNumber
     * @return
     */
    Hashtable<Integer, Boolean> truckOutput(Integer truckPlaceNumber);
}
