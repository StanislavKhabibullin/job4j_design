package solid.lsp;

import java.util.List;

public class SoutClass implements StorePrinter {
    @Override
    public void print(List<Store> storeList) {
        for (Store storrr
                :storeList) {
            storrr.print();
        }
    }
}
