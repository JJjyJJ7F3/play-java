package self.jjjyjj.oop.example.solid.dip;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import self.jjjyjj.oop.example.solid.dip.mock.MockOutput;
import self.jjjyjj.oop.example.solid.dip.mock.StubInput;

import static org.assertj.core.api.Assertions.assertThat;

class TextConversionTest {
    @Mock
    private Input input;

    @Mock
    private Output output;

    @BeforeEach
    public void beforeEachTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void displaysUpperCasedInputWithHandRolledMock() {
        // Arrange
        var in = new StubInput("abc123");
        var out = new MockOutput();

        var tc = new TextConversion(in, out);

        // Act
        tc.showInputInUppercase();

        // Assert
        assertThat(out.getActual()).isEqualTo("ABC123");
    }

    @Test
    public void displayUpperCasedInputWithMockito() {
        // Arrange
        Mockito.when(input.fetch()).thenReturn("abc123");
        var tc = new TextConversion(input, output);

        // Act
        tc.showInputInUppercase();

        // Assert
        Mockito.verify(output).display("ABC123");
    }


}