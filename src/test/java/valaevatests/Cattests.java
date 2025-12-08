package valaevatests;

import allclasses.valaeva.Cat;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Cattests {

    @Test
    public void testCatCreation() {
        Cat cat = new Cat("Барсик", 3, 4.5, "рыжий");

        assertEquals("Барсик", cat.getName());
        assertEquals(3, cat.getAge());
        assertEquals(4.5, cat.getWeight(), 0.01);
        assertEquals("рыжий", cat.getColor());
    }

    @Test
    public void testGetInfo() {
        Cat cat = new Cat("Мурзик", 2, 3.8, "черный");
        String info = cat.getInfo();

        assertEquals("Кот: Мурзик, возраст: 2 лет, вес: 3.8 кг, цвет: черный", info);
    }

    @Test
    public void testEat() {
        Cat cat = new Cat("Васька", 4, 5.2, "серый");
        assertEquals("Васька кушает", cat.eat());
    }

    @Test
    public void testSleep() {
        Cat cat = new Cat("Пушок", 1, 2.5, "белый");
        assertEquals("Пушок спит", cat.sleep());
    }

    @Test
    public void testSetWeight() {
        Cat cat = new Cat("Толстяк", 5, 6.0, "черный");
        cat.setWeight(7.5);
        assertEquals(7.5, cat.getWeight(), 0.01);
    }

    @Test
    public void testIsFat() {
        Cat fatCat = new Cat("Толстый", 4, 6.5, "серый");
        Cat thinCat = new Cat("Худой", 2, 5.5, "рыжий");

        assertTrue(fatCat.isFat());
        assertFalse(thinCat.isFat());
    }

    @Test
    public void testGetColorInfo() {
        Cat cat = new Cat("Рыжик", 3, 4.1, "рыжий");
        assertEquals("Рыжик имеет рыжий цвет", cat.getColorInfo());
    }


}
