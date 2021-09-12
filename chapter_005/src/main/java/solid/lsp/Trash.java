package solid.lsp;

import solid.lsp.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash {
    List<Food> goodsInTrashBucket = new ArrayList<>();

    public void addTrash(Food food) {
        goodsInTrashBucket.add(food);
    }
}

