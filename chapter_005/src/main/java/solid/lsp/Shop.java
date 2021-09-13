package solid.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
   private List<Food> goodsOnShelves = new ArrayList<>();

   @Override
   public void addStore(Food food) {
       goodsOnShelves.add(food);
   }

    @Override
    public boolean accept(Food food) {
        LocalDate now = LocalDate.now();
        var duration = (double) ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        var durationFromNow = (double) ChronoUnit.DAYS.between(now, food.getExpiryDate());
        int res = Integer.valueOf((int) (100 - (durationFromNow / duration) * 100));
        if ((res > 25) & (res <= 75)) {
            return true;
        } else if ((res > 75) & (res < 100)) {
            food.setDiscount((float) 0.5);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> getFromStore() {
        return goodsOnShelves;
    }

    @Override
    public void print() {
        for (Food shopFood:
                goodsOnShelves) {
            System.out.println("on the shop shelves - " + shopFood);
        }
    }

    public void setGoodsOnShelves(List<Food> goodsOnShelves) {
        this.goodsOnShelves = goodsOnShelves;
    }
}
