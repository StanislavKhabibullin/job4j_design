package solid.lsp.carParking;

import java.util.Hashtable;
import java.util.List;

public interface FilingCarParking {
    Hashtable<Integer, Boolean> carInput(Integer carPlaceNumber); //заполняет машиноместа при въезде легкового авто
                                                                  //возвращает информацию с перечнем мест для легковых авто
                                                                  //выбрасывает исключение если место занято
    Hashtable<Integer, Boolean> truckInput(Integer truckPlaceNumber); //заполняет машиноместа при въезде грузового авто
                                                                      //возвращает информацию с перечнем мест для легковых авто
                                                                      //выбрасывает исключение если место занято
    Hashtable<Integer, Boolean> carOutput(Integer carPlaceNumber); //освобождает машиноместо при выезде авто
                                                                   //возвращает информацию с перечнем мест для легковых авто
                                                                    //выбрасывает исключение если место занято
    Hashtable<Integer, Boolean> truckOutput(Integer truckPlaceNumber); //освобождает машиноместа при въезде грузового авто
                                                                        //возвращает информацию с перечнем мест для легковых авто
                                                                        //выбрасывает исключение если место занято

}
