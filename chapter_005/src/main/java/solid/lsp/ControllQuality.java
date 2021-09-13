package solid.lsp;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ControllQuality {

   Store warehouse = new Warehouse();
   Store shop = new Shop();
   Store trash = new Trash();



    public Food handler(Food goods) {
        if (warehouse.accept(goods)) {
            warehouse.addStore(goods);
        }
        if (shop.accept(goods)) {
            shop.addStore(goods);
        }
        if (trash.accept(goods)) {
            trash.addStore(goods);
        }
        return goods;
    }

    public void printer() {
        warehouse.print();
        shop.print();
        trash.print();
    }

    public static void main(String[] args) {

        System.out.println(LocalDate.now());
        Bread blackBread = new Bread("Bojole", LocalDate.of(2021, 10, 22),
                LocalDate.of(2021, 9, 10), 100, 0 );
        Bread whiteBread = new Bread("Baguette", LocalDate.of(2021, 9, 11),
                LocalDate.of(2021, 9, 10), 150, 0 );
        Bread bunBread = new Bread("Bun", LocalDate.of(2021, 9, 14),
                LocalDate.of(2021, 9, 10), 120, 0 );
        ControllQuality rez = new ControllQuality();
        rez.handler(blackBread);
        rez.handler(whiteBread);
        rez.handler(bunBread);
        rez.printer();
    }
}
