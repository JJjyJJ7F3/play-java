package self.jjjyjj.oop.example.solid.dip;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SelfShuntTextConversionTest implements Input, Output {
    private final Input input = this;
    private final Output output = this;

    private String actual;

    @Override
    public String fetch() {
        return "abc123";
    }

    @Override
    public void display(String toDisplay) {
        this.actual = toDisplay;
    }

    @Test
    public void displayUpperCasedInput() {
        // Arrange
        var tc = new TextConversion(input, output);

        // Act
        tc.showInputInUppercase();

        // Assert
        assertThat(actual).isEqualTo("ABC123");
    }
}
