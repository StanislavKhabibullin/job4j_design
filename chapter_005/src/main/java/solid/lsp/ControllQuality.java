package solid.lsp;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

   List<Store> storeList;
   FoodHandler handlerImp = new Handler();
   FoodResort foodResort = new Resoter();
   StorePrinter storePrinter = new SoutClass();


    public ControllQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public Food handler(Food goods) {
        return handlerImp.handler(storeList, goods);
    }

    public void resort() {
        foodResort.resort(storeList, handlerImp);
    }

    public void print() {
        storePrinter.print(storeList);
    }


    public static void main(String[] args) {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        List<Store> storeList1 = new ArrayList<>();
        storeList1.add(warehouse);
        storeList1.add(shop);
        storeList1.add(trash);
        System.out.println(LocalDate.now());
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
        rez.print();
        rez.resort(); //класс, реализующий интерфейс FoodResort
        rez.print();
    }


}
