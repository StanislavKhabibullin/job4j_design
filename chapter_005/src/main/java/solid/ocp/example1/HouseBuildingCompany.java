package solid.ocp.example1;

import java.util.function.Predicate;

public class HouseBuildingCompany implements FoundationConstructor, CorrectFoundationConstructor {
    private Integer numberOfFloorBuilding;
    private BuildingType type;

    public HouseBuildingCompany(Integer numberOfFloorBuilding) {
        this.numberOfFloorBuilding = numberOfFloorBuilding;
    }

    /**
     * данный метод рассчитывает количество
     * бетона для фундамента только в зависимости
     * от количества этажей
     * @param numberOfFloor
     * @return
     */
    @Override
    public Integer concreteQuantity(Integer numberOfFloor) {
        return numberOfFloorBuilding * 1000;
    }

    /**
     * если потребуется строительство здания с подземной стоянкой, то тогда потребуется либо вводить
     * новый метод либо новый интерфейс, решение в данном случае следующее в интерфейсе сразу предус
     * усмотреть условие по Predicate, чтобы в реализации метода был выбор какое здание строить
     * для этого вводим тип здания, которе планируем построить BuildingType
     * реализуем метод в котором передаем предикат по типу планируемого здания
     */

    public static class BuildingType {

    }

    @Override
    public Integer correctConcreteQuantity(Predicate<BuildingType> buildingTypePredicate, Integer numberOfFloor) {
       if (buildingTypePredicate.test(type)) {
           return numberOfFloorBuilding * 2000;
       }
        return numberOfFloorBuilding * 1000;
    }
}
