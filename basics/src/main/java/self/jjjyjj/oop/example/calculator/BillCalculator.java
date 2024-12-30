package self.jjjyjj.oop.example.calculator;

import lombok.Getter;

@Getter
public class BillCalculator {
    private double total;

    public void add(double itemPrice) {
        total = itemPrice;
    }
}
