package solid.srp;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public interface SportRes<T> {
    LocalDate getData(File yearOfTheEvent);     //из названия файла получаем дату проведения Триатлона
    List<T> triatlonMembers(File yearOfTheEvent); //получаем список участников триатлона из файла
    void convertToSQL(List<T> triatlonMembers, LocalDate getData); //конвертируем данные в SQL-таблицу
}
