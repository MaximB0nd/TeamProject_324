package volkovatests;

import allclasses.volkova.House;
import org.junit.Test;
import static org.junit.Assert.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

public class HouseTests {

    @Test
    @DisplayName("Создание объекта House")
    @Description("Проверка корректного создания объекта House с указанием всех параметров")
    public void testHouseCreation() {
        House house = new House("ул. Ленина, 10", 2, 85.5, "белый");

        assertEquals("ул. Ленина, 10", house.getAddress());
        assertEquals(2, house.getFloors());
        assertEquals(85.5, house.getArea(), 0.01);
        assertEquals("белый", house.getColor());
    }

    @Test
    @DisplayName("Получение информации о доме")
    @Description("Проверка метода getInfo() на корректное формирование строки информации")
    public void testGetInfo() {
        House house = new House("ул. Центральная, 25", 3, 120.8, "желтый");
        String info = house.getInfo();

        assertEquals("Дом по адресу: ул. Центральная, 25, этажей: 3, площадь: 120.8 м², цвет: желтый", info);
    }

    @Test
    @DisplayName("Строительство дома")
    @Description("Проверка метода build() на возвращение корректного сообщения о строительстве")
    public void testBuild() {
        House house = new House("ул. Новая, 5", 1, 65.0, "серый");
        assertEquals("Строится дом по адресу: ул. Новая, 5", house.build());
    }

    @Test
    @DisplayName("Ремонт дома")
    @Description("Проверка метода renovate() на возвращение корректного сообщения о ремонте")
    public void testRenovate() {
        House house = new House("ул. Старая, 15", 2, 95.3, "зеленый");
        assertEquals("Ремонтируется дом по адресу: ул. Старая, 15", house.renovate());
    }

    @Test
    @DisplayName("Изменение площади дома")
    @Description("Проверка метода setArea() на корректное изменение площади дома")
    public void testSetArea() {
        House house = new House("ул. Горная, 8", 2, 80.0, "коричневый");
        house.setArea(95.5);
        assertEquals(95.5, house.getArea(), 0.01);
    }

    @Test
    @DisplayName("Определение размера дома")
    @Description("Проверка метода isBig() на корректное определение больших и маленьких домов")
    public void testIsBig() {
        House bigHouse = new House("ул. Большая, 50", 3, 150.0, "красный");
        House smallHouse = new House("ул. Малая, 3", 1, 75.5, "синий");

        assertTrue(bigHouse.isBig());
        assertFalse(smallHouse.isBig());
    }

    @Test
    @DisplayName("Получение информации о цвете дома")
    @Description("Проверка метода getColorInfo() на корректное формирование информации о цвете")
    public void testGetColorInfo() {
        House house = new House("ул. Солнечная, 12", 2, 90.2, "оранжевый");
        assertEquals("Дом по адресу ул. Солнечная, 12 имеет оранжевый цвет", house.getColorInfo());
    }
}