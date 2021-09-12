package solid.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
   private List<Food> goodsOnShelves = new ArrayList<>();

   public void addShop(Food food) {
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

    public List<Food> getGoodsOnShelves() {
        return goodsOnShelves;
    }

    public void setGoodsOnShelves(List<Food> goodsOnShelves) {
        this.goodsOnShelves = goodsOnShelves;
    }
}
