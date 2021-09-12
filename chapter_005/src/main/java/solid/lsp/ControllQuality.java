package solid.lsp;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ControllQuality {
    Warehouse warehouse;
    Shop shop;
    Trash trash;

    public ControllQuality(Warehouse warehouse, Shop shop, Trash trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public Food handler(Food goods) {
        LocalDate now = LocalDate.now();
        var duration = (double) ChronoUnit.DAYS.between(goods.getCreateDate(), goods.getExpiryDate());
        var durationFromNow = (double) ChronoUnit.DAYS.between(now, goods.getExpiryDate());
        int res = Integer.valueOf((int) (100 - (durationFromNow / duration) * 100));
        System.out.println(res);
        if ((res <= 25) & (res > 0)) {
            warehouse.addWarehouse(goods);
        } else if ((res > 25) & (res <= 75)) {
            shop.addShop(goods);
        } else if ((res > 75) & (res < 100)) {
            goods.setDiscount((float) 0.5);
            shop.addShop(goods);
        } else {
            trash.addTrash(goods);
        }
        return goods;
    }

    public static void main(String[] args) {
        Warehouse warehouse1 = new Warehouse();
        Shop shop1 = new Shop();
        Trash trash1 = new Trash();
        System.out.println(LocalDate.now());
        Bread blackBread = new Bread("Bojole", LocalDate.of(2021, 10, 22),
                LocalDate.of(2021, 9, 10), 100, 0 );
        Bread whiteBread = new Bread("Baguette", LocalDate.of(2021, 9, 11),
                LocalDate.of(2021, 9, 10), 150, 0 );
        Bread bunBread = new Bread("Bun", LocalDate.of(2021, 9, 13),
                LocalDate.of(2021, 9, 10), 120, 0 );
        ControllQuality rez = new ControllQuality(warehouse1, shop1, trash1);
        rez.handler(blackBread);
        rez.handler(whiteBread);
        rez.handler(bunBread);
        for (Food shopFood:
             rez.shop.getGoodsOnShelves()) {
            System.out.println("on the shop shelves - " + shopFood);
        }

        for (Food trashFood:
                rez.trash.goodsInTrashBucket) {
            System.out.println("in the trash bucket - " + trashFood);
        }

        for (Food warehouseFood:
        rez.warehouse.goodsInStock) {
            System.out.println("in to warehouse - " + warehouseFood);
        }
    }
}
