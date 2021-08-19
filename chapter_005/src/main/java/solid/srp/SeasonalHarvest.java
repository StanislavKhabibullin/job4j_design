package solid.srp;

import java.util.Map;

public interface SeasonalHarvest<T, S> {
    Map<T, S> productivity(String  agriCulture); // урожайность сельскохозяйственной культуры
    void printHarvest(Map<T, S> productivity, Double sowingAreas); // планируемый урожай в зависимости от площадей посева
}
