package self.jjjyjj.oop.example.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BillCalculatorTest {

    @Test
    public void totalStartsAtZero() {
        // Arrange
        var calculator = new BillCalculator();

        // Act
        double total = calculator.getTotal();

        // Assert
        assertThat(total).isZero();
    }

    @Test
    public void correctTotalForOneItem() {
        // Arrange
        var calculator = new BillCalculator();

        // Act
        calculator.add(12.75);
        double total = calculator.getTotal();

        // Assert
        assertThat(total).isEqualTo(12.75);
    }
}
