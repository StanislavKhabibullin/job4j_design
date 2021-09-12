package solid.lsp;

import solid.lsp.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    List<Food> goodsInTrashBucket = new ArrayList<>();

    public void addTrash(Food food) {
        goodsInTrashBucket.add(food);
    }

    @Override
    public boolean accept(Food food) {
        LocalDate now = LocalDate.now();
        var duration = (double) ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        var durationFromNow = (double) ChronoUnit.DAYS.between(now, food.getExpiryDate());
        int res = Integer.valueOf((int) (100 - (durationFromNow / duration) * 100));
        if ((res < 0) || (res > 100)) {
           return true;
        }
        return false;
    }
}

