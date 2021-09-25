package solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class Resoter implements FoodResort {

    @Override
    public void resort(List<Store> storeList, FoodHandler foodHandler) {
        List<Food> foods = new ArrayList<>();
        for (Store store
                :storeList) {
            foods.addAll(store.getFromStore());
            store.clearStore();
        }
        for (int i = 0; i < foods.size(); i++) {
            System.out.println("Resort product - " + foods.get(i));
            foodHandler.handler(storeList, foods.get(i));
        }
    }
}
