package solid.isp;

public interface Cooking {
    void doughPrepare();
    void fryItAfter();
    void washProduct();
    /*
    нарушение принципа ISP в том, что при приготовлении некоторых продуктов нам не потребуется их обжаривать
    или готовить тесто, но при этом методы эти реализовывать придется
     */
}
