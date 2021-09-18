package solid.isp;

public interface CostHotelServise {
    float roomservice();
    float cinemacervise();
    float poolservice();
    float conferenceeroom();
    /*
    нарушение принципа ISP будет в следующем:
    - если у отеля нет бассейна или кинотеатра, то методы все равно придется реализовывать, но в реализации их глушить
     */
}
