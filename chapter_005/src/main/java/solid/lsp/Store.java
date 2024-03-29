package solid.lsp;

import java.util.ArrayList;
import java.util.List;

public interface Store {

    boolean accept(Food food);

    void addStore(Food goods);

    void clearStore();

    List<Food> getFromStore();

    void print();
}
