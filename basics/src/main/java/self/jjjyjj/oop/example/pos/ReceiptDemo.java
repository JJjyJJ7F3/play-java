package self.jjjyjj.oop.example.pos;

public class ReceiptDemo {
    public static void main(String[] args) {
        Money applePrice = new Money("10.56", "CNY");
        Money bananaPrice = new Money("20", "GBP");
        Money orangePrice = new Money("30.5", "JPY");

        Receipt receipt = new Receipt(new Printer());

        receipt.add("apple", applePrice);
        receipt.add("banana", bananaPrice);
        receipt.add("orange", orangePrice);

        receipt.print();
    }
}
