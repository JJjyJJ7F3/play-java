package self.jjjyjj.oop.example.pos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * An aggregate class that represents the full receipt. Note the same print object is used to
 * print out the entire receipt.
 * Receipt does not know anything about how Item objects look nor handle printing. It only knows that there are zero
 * or more Item objects and that they can be asked to print.
 */
public class Receipt {
    private final Printer printer;
    private final List<Item> items = new ArrayList<>();
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public Receipt(Printer printer) {
        this.printer = printer;
    }

    /**
     * Add new items that will be printed. At present, we pass the description and price parameters to
     * the add method instead of the item class.
     */
    public void add(String description, Money price) {
        items.add(new Item(description, price));
        totalPrice = totalPrice.add(price.getAmount());
    }

    /**
     * Iterate items in the items field and call the print method
     */
    public void print() {
        items.forEach(item -> item.print(printer));

        printer.print("Total: ");
        printer.print(totalPrice.toString());
        printer.newline();
    }
}
