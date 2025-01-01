package self.jjjyjj.oop.example.solid.dip.mock;

import lombok.Getter;
import self.jjjyjj.oop.example.solid.dip.Output;

@Getter
public class MockOutput implements Output {
    private String actual;

    @Override
    public void display(String toDisplay) {
        this.actual = toDisplay;
    }

}
