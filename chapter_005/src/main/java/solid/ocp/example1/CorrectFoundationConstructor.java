package solid.ocp.example1;

import java.util.function.Predicate;

public interface CorrectFoundationConstructor {
    Integer correctConcreteQuantity(Predicate<HouseBuildingCompany.BuildingType> buildingTypePredicate, Integer numberOfFloor);
}
