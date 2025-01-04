package self.jjjyjj.effective.item2;

public class NutritionFactsDemo {
    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts(240, 100, 20,
                10, 10, 12);


        NutritionFactsBuilder nutritionFactsBuilder = new NutritionFactsBuilder
                .Builder(1, 2)
                .calories(3)
                .fat(4)
                .sodium(5)
                .carbohydrate(6)
                .build();
    }
}
