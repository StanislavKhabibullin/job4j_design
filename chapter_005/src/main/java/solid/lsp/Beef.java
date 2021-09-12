package solid.lsp;

import java.time.LocalDate;

public class Beef extends Food {
    public Beef(String name, LocalDate expiryDate, LocalDate createDate, float price, float discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
