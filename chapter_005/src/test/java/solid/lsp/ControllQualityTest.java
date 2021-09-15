package solid.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ControllQualityTest {

    @Test
    public void handlerTestTrash() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        List<Store> storeList1 = new ArrayList<>();
        storeList1.add(warehouse);
        storeList1.add(shop);
        storeList1.add(trash);
        Bread blackBread = new Bread("Bojole", LocalDate.of(2021, 10, 22),
                LocalDate.of(2021, 9, 10), 100, 0);
        Bread whiteBread = new Bread("Baguette", LocalDate.of(2021, 9, 11),
                LocalDate.of(2021, 9, 10), 150, 0);
        Bread bunBread = new Bread("Bun", LocalDate.of(2021, 9, 14),
                LocalDate.of(2021, 9, 10), 120, 0);
        ControllQuality rez = new ControllQuality(storeList1);
        rez.handler(blackBread);
        rez.handler(whiteBread);
        rez.handler(bunBread);
        Food res1 = trash.getFromStore().get(0);
        Integer equal = trash.getFromStore().size();
        assertThat(res1, is(whiteBread));
        assertThat(equal, is(2));
        Food res = warehouse.getFromStore().get(0);
        assertThat(res, is(blackBread));
    }

    @Test
    public void handlerTestWarehouse() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        List<Store> storeList1 = new ArrayList<>();
        storeList1.add(warehouse);
        storeList1.add(shop);
        storeList1.add(trash);
        LocalDate now = LocalDate.now();
        Bread blackBread = new Bread("Bojole", LocalDate.of(2021, 10, 22),
                LocalDate.of(2021, 9, 10), 100, 0);
        Bread whiteBread = new Bread("Baguette", now.plusDays(2),
                now.minusDays(1), 150, 0);
        Bread bunBread = new Bread("Bun", LocalDate.of(2021, 9, 10),
                LocalDate.of(2021, 9, 10), 120, 0);
        ControllQuality rez = new ControllQuality(storeList1);
        rez.handler(blackBread);
        rez.handler(whiteBread);
        rez.handler(bunBread);
        Food res = warehouse.getFromStore().get(0);
        Food resShop = shop.getFromStore().get(0);
        Food resTrash = trash.getFromStore().get(0);
        assertThat(res, is(blackBread));
        assertThat(resShop, is(whiteBread));
        assertThat(resTrash, is(bunBread));
    }
}