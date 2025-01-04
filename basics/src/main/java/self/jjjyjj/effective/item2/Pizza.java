package self.jjjyjj.effective.item2;

import java.util.EnumSet;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPERONI, SAUSAGE
    }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(topping);
            return self();
        }

        public abstract Pizza build();

        /**
         * Subclasses must override this method to return "this".
         * allows method chaining to work properly in subclasses, without the need for casts
         * @return the builder instance
         */
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
