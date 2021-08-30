package solid.ocp.example1;

import java.util.function.Predicate;

public interface CorrectFoundationConstructor {
    Integer CorrectConcreteQuantity(Predicate<HouseBuildingCompany.BuildingType> buildingTypePredicate, Integer numberOfFloor);
}
