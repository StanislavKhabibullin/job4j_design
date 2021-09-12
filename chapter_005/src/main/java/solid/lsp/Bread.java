package solid.lsp;

import java.time.LocalDate;

public class Bread extends Food {
    public Bread(String name, LocalDate expiryDate, LocalDate createDate, float price, float discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
