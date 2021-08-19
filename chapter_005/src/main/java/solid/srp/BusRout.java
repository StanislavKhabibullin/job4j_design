package solid.srp;

import java.util.List;
import java.util.Map;

public interface BusRout<T, S> {
    Map<T, S> schedule(int routDuration);               // формируем расписание автобуса в зависимости от длины маршрута
    List<Double> costOfTravel(Map<T, S> schedule);      // формируем стоимость поездки до каждой остановки продолжительность поездки-разная цена
}
