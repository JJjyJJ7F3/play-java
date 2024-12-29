package self.jjjyjj.oop.example.pos;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * A class that represents the number of money that an Item costs.
 */
public class Money {
    @Getter
    private final BigDecimal amount;
    private final String currency;

    public Money(String amount, String currency) {
        this.amount = new BigDecimal(amount);
        this.currency = currency;
    }

    public void print(Printer p) {
        p.print(currency);
        p.print(amount.toString());
    }

}
