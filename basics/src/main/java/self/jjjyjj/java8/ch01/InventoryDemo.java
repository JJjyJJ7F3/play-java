package self.jjjyjj.java8.ch01;

import java.util.ArrayList;
import java.util.List;

public class InventoryDemo {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();

        apples.add(new Apple("green", 12));
        apples.add(new Apple("red", 16));
        apples.add(new Apple("green", 9));

        List<Apple> greenApples = FruitInventory.filterGreenApples(apples);
        List<Apple> heavyApples = FruitInventory.filterHeavyApples(apples);

        System.out.println(greenApples);
        System.out.println(heavyApples);

    }
}
