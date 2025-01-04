package self.jjjyjj.effective.item2;

import static self.jjjyjj.effective.item2.NyPizza.Size.SMALL;
import static self.jjjyjj.effective.item2.Pizza.Topping.*;

public class PizzaDemo {
    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();

        System.out.println(nyPizza.toString());


        Calzone calzone = new Calzone.Builder()
                .sauceInside()
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();

        System.out.println(calzone.isSauceInside());
    }
}
