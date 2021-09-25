package solid.lsp;

import java.util.List;

public class Handler implements FoodHandler {
    public Handler() {
    }

    @Override
    public Food handler(List<Store> storeList, Food food) {
        for (Store storrr
                :storeList) {
            if (storrr.accept(food)) {
                storrr.addStore(food);
            }
        }
        return food;
        }
}
