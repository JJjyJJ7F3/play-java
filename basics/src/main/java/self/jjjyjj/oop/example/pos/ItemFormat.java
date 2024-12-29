package self.jjjyjj.oop.example.pos;

/**
 * Class that responsible for formatting an Item object for print
 */
public class ItemFormat {
    private final String description;
    private final Money price;

    public ItemFormat(String description, Money price) {
        this.description = description;
        this.price = price;
    }

    public void print(Printer p) {
        p.print(description);
        p.print(" ");
        price.print(p);

        p.newline();
    }
}
