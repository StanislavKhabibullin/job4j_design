package solid.dip.example2;

public class WebShop {
    private GoodsFilter goodsFilter;
    private Delivery delivery;

    public void goodsBucket(GoodsFilter sed, Delivery del) {

    }

    /*
    Опять же нарушение в том, что при добавлении функциональности необходимо будет лезть в код класса и не ошибиться
    в зависимостях
    Решение - реализация через интерфейсы
     */

}
