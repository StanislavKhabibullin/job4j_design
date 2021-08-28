package solid.srp;

import java.util.Map;

public interface SeasonalHarvest<T, S> {
    Map<T, S> productivity(String  agriCulture); // урожайность сельскохозяйственной культуры
    void printHarvest(Map<T, S> productivity, Double sowingAreas); // планируемый урожай в зависимости от площадей посева
    /*
    первая ошибка нарушающая принцип SRP
    в данном случае следующая:
    имплементирующий данный интерфейс класс будет иметь сразу две цели:
    1. - заполнение урожайности сельскохозяйственной культуры в зависимости от её наименования
    по прниципу - время сезонность/урожайность(предполагается что за 1 год в данном регионе
    выращиваются несколько урожаев)
    2. - вывод на печать количество планируемого к получению урожая, в зависимости от
    площадей посева данной культуры
    Таким образом нарушается принцип, что класс должен реализовывать только
    одну цель
    Поскольку реализация первого метода задумывалась таким образом что продуктивность не генерируется
    самостоятельно, а будет заполняться из базы данный, то второй принцип SRP-в данном случае не нару-
    шается ни первым ни вторым методом
     */
}