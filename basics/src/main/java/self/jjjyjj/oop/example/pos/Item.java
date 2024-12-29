package self.jjjyjj.oop.example.pos;

/**
 * An item that can print itself. Right now, the item only knows what should be printed on the receipt
 * and not how to print it. When an item print something, it will collaborate with a Print object.
 */
public class Item {
    private final String description;
    private final Money price;

    public Item(String description, Money price) {
        this.description = description;
        this.price = price;
    }

    /**
     * delegate print to ItemFormat
     */
    public void print(Printer p) {
        new ItemFormat(description, price).print(p);
    }
}
