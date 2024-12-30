package self.jjjyjj.oop.example.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BillCalculatorTest {

    @Test
    public void totalStartsAtZero() {
        // Arrange
        var bill = new Bill();

        // Act
        double total = bill.getTotal();

        // Assert
        assertThat(total).isZero();
    }

    @Test
    public void correctTotalForOneItem() {
        // Arrange
        var bill = new Bill();

        // Act
        bill.add(12.75);
        double total = bill.getTotal();

        // Assert
        assertThat(total).isEqualTo(12.75);
    }

    @Test
    public void correctTotalForTwoItems() {
        // Arrange
        var bill = new Bill();

        // Act
        bill.add(12.75);
        bill.add(25.5);
        double total = bill.getTotal();

        // Assert
        assertThat(total).isEqualTo(38.25);
    }
}
