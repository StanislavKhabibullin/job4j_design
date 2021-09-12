package solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<Food> goodsInStock = new ArrayList<>();

    public void addWarehouse(Food food) {
        goodsInStock.add(food);
    }
}
