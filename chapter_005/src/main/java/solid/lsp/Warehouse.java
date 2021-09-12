package solid.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {
    List<Food> goodsInStock = new ArrayList<>();

    public void addWarehouse(Food food) {
        goodsInStock.add(food);
    }

    @Override
    public boolean accept(Food food) {
        LocalDate now = LocalDate.now();
        var duration = (double) ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        var durationFromNow = (double) ChronoUnit.DAYS.between(now, food.getExpiryDate());
        int res = Integer.valueOf((int) (100 - (durationFromNow / duration) * 100));
        if ((res <= 25) & (res > 0)) {
            return true;
        }
        return false;
    }
}
