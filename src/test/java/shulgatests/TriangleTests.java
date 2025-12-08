package shulgatests;

import allclasses.shulga.Triangle;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;

public class TriangleTests {


    @Test
    @DisplayName("Проверка на корректное создание труегольника и на правильное значение сторон")
    public void testCreateTriangle() {
        Triangle triangle = new Triangle(3, 4, 5);
        Assert.assertNotNull(triangle);
        Assert.assertEquals(3.0, triangle.GetA(), 0.001);
        Assert.assertEquals(4.0, triangle.GetB(), 0.001);
        Assert.assertEquals(5.0, triangle.GetC(), 0.001);
    }

    @Test
    @DisplayName("Проверка метода, определяющего сущестыцует треугольник или нет")
    public void testIsExist() {
        Triangle validTriangle = new Triangle(3, 4, 5);
        Triangle invalidTriangle = new Triangle(1, 1, 3);

        Assert.assertTrue(validTriangle.IsExist());
        Assert.assertFalse(invalidTriangle.IsExist());
    }

    @Test
    @DisplayName("Проверка нахождения периметра")
    public void testGetPerimeter() {
        Triangle triangle = new Triangle(3, 4, 5);
        double expected = 12.0;
        Assert.assertEquals(expected, triangle.GetPerimetr(), 0.001);
    }

    @Test
    @DisplayName("Проверка нахождения площади")
    public void testGetSquare() {
        Triangle triangle = new Triangle(3, 4, 5);
        double expected = 6.0;
        Assert.assertEquals(expected, triangle.GetSquare(), 0.001);
    }

    @Test
    @DisplayName("Проверка нахождения площади и периметра у равностороннего треугольника")
    public void testEquilateralTriangle() {
        Triangle equilateral = new Triangle(5, 5, 5);
        Assert.assertTrue(equilateral.IsExist());
        Assert.assertEquals(15.0, equilateral.GetPerimetr(), 0.001);
        Assert.assertEquals(10.825, equilateral.GetSquare(), 0.001);
    }

    @Test
    @DisplayName("Проверка создания труегольника с нулевой стороной")
    public void testZeroSideTriangle() {
        Triangle zeroSide = new Triangle(0, 4, 5);
        Assert.assertFalse(zeroSide.IsExist());
    }

    @Test
    @DisplayName("Проверка создания треугольника с отрицательной стороной")
    public void testNegativeSide() {
        Triangle negativeSide = new Triangle(-3, 4, 5);
        Assert.assertFalse(negativeSide.IsExist());
    }
}