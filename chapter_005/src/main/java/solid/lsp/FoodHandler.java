package solid.lsp;

import java.util.List;

public interface FoodHandler {
    Food handler(List<Store> storeList, Food food);
}
