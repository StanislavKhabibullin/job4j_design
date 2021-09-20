package solid.lsp.carparking;

public class UndergroundParking implements Parking {
    public Integer vacantCarPlaces;
    public Integer vacantTruckPlaces;

    public UndergroundParking(Integer vacantCarPlaces, Integer vacantTruckPlaces) {
        this.vacantCarPlaces = vacantCarPlaces;
        this.vacantTruckPlaces = vacantTruckPlaces;
    }

    @Override
    public boolean parking(Auto auto) {
       if (auto.size() == 1) {
           if ((vacantCarPlaces - 1) >= 0) {
               vacantCarPlaces--;
               return  true;
           } else {
               System.out.println("There is no vacant car places on the parking");
           }
       } else {
           Integer res = vacantTruckPlaces - 1;
           Integer carRes = vacantCarPlaces - auto.size();
           if (res >= 0) {
               vacantTruckPlaces = res;
               return true;
           } else if (carRes >= 0) {
               vacantCarPlaces = carRes;
               return true;
           } else {
               System.out.println("There is no vacant truck places on the parking");
           }
       }
        return false;
    }
}
