package self.jjjyjj.oop.example.calculator;

import lombok.Getter;

@Getter
public class Bill {
    private double total;

    public void add(double itemPrice) {
        total += itemPrice;
    }
}
