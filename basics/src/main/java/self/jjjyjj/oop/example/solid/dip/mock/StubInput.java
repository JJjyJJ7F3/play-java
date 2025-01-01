package self.jjjyjj.oop.example.solid.dip.mock;

import self.jjjyjj.oop.example.solid.dip.Input;

public class StubInput implements Input {
    private final String stubValue;

    public StubInput(String input) {
        this.stubValue = input;
    }

    @Override
    public String fetch() {
        return stubValue;
    }
}
