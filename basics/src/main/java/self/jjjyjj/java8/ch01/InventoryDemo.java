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

        List<Apple> greenAppleAgain = FruitInventory.filterApples(apples, Apple::isGreenApple);
        List<Apple> greenHeavyApples = FruitInventory.filterApples(apples,
                (Apple a) -> a.getColor().equals("green") && a.getWeight() > 10);

        List<Apple> greenApplesByStream = apples.stream().filter(Apple::isGreenApple).toList();
        List<Apple> greenApplesByParallelStream = apples.parallelStream().filter(Apple::isGreenApple).toList();

        System.out.println(greenApples);
        System.out.println(heavyApples);
        System.out.println(greenAppleAgain);
        System.out.println(greenHeavyApples);
        System.out.println(greenApplesByStream);
        System.out.println(greenApplesByParallelStream);

    }
}
