package solid.lsp;

import java.time.LocalDate;

public class Kreker extends Food {
    public Kreker(String name, LocalDate expiryDate, LocalDate createDate, float price, float discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
