package solid.srp;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

/**
 * ошибка нарушающая принцип SRP
 *     в данном случае следующая:
 *     имплементирующий данный интерфейс класс будет иметь сразу три цели:
 *     1. - получает дату проведения триатлона путем парсинга названия файла, который содержит
 *     список список участников триатлона(предполагается что данные упорядоченые в нескольких
 *     файлах где название файла - это дата проведения триатлона, а сам файл содержит список
 *     участников)
 *     2. - получение списка участников триатлона из файла и упаковка их имен в коллекцию
 *     3. - конвертация полученной коллекции и даты проведения триатлона в формат таблицы SQL
 *     Таким образом нарушается принцип, что класс должен реализовывать только
 *     одну цель
 *     Создание новых объектов подразумевается в данном случае во всех методах, однако ни один из
 *     трех методов не генерирует данные объекты путем какой-либо сложной логики, а используется
 *     простое заполнение, то, на мой взгляд, второй принцип SRP-в данном случае не нару-
 *     шается ни одним из вышеперечисленных методов
 *
 * @param <T>
 */
public interface SportRes<T> {
    /**
     * из названия файла получаем дату проведения Триатлона
     * @param yearOfTheEvent
     * @return
     */
    LocalDate getData(File yearOfTheEvent);

    /**
     * получаем список участников триатлона из файла
     * @param yearOfTheEvent
     * @return
     */
    List<T> triatlonMembers(File yearOfTheEvent);

    /**
     * конвертируем данные в SQL-таблицу
     * @param triatlonMembers
     * @param getData
     */
    void convertToSQL(List<T> triatlonMembers, LocalDate getData);

}
