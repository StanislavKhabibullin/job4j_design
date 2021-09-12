package solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop {
   private List<Food> goodsOnShelves = new ArrayList<>();

   public void addShop(Food food) {
       goodsOnShelves.add(food);
   }

    public List<Food> getGoodsOnShelves() {
        return goodsOnShelves;
    }

    public void setGoodsOnShelves(List<Food> goodsOnShelves) {
        this.goodsOnShelves = goodsOnShelves;
    }
}
