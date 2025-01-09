package self.jjjyjj.tdd.ch05;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsernameTest {

    @Test
    public void convertToLowerCase() {
        var username = new Username("HeLLO");

        String actual = username.asLowerCase();

        assertThat(actual).isEqualTo("hello");
    }
}
