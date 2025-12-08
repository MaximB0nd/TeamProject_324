package ivanovatests;

import allclasses.ivanova.Pizza;
import org.junit.Test;
import static org.junit.Assert.*;

public class PizzaTests {

    @Test
    public void testCaloriesSmallPizza() {
        Pizza pizza = new Pizza("small", 2, false);
        assertEquals(760, pizza.getCalories());
    }

    @Test
    public void testCaloriesMediumPizzaWithCheeseCrust() {
        Pizza pizza = new Pizza("medium", 1, true);
        assertEquals(1130, pizza.getCalories());
    }

    @Test
    public void testCaloriesLargePizzaManyToppings() {
        Pizza pizza = new Pizza("large", 5, false);
        assertEquals(1600, pizza.getCalories());
    }

    @Test
    public void testAddTopping() {
        Pizza pizza = new Pizza("medium", 0, false);
        pizza.addTopping();
        pizza.addTopping();
        assertEquals(2, pizza.getToppings());
    }

    @Test
    public void testNegativeToppingsProtected() {
        Pizza pizza = new Pizza("small", -3, false);
        assertEquals(0, pizza.getToppings());
    }

    @Test
    public void testCheeseCrustFlag() {
        Pizza pizza = new Pizza("large", 2, true);
        assertTrue(pizza.hasCheeseCrust());
    }

    @Test
    public void testGetSize() {
        Pizza pizza = new Pizza("medium", 1, false);
        assertEquals("medium", pizza.getSize());
    }
}
