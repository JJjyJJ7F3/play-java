package self.jjjyjj.java8.ch01;

import lombok.Data;

@Data
public class Apple {

    private String color;

    private int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public boolean isGreenApple() {
        return "green".equals(color);
    }

    public boolean isHeavyApple() {
        return weight > 10;
    }
}
