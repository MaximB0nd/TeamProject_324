package shulgatests;

import allclasses.shulga.Triangle;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTests {

    @Test
    public void testCreateTriangle() {
        Triangle triangle = new Triangle(3, 4, 5);
        Assert.assertNotNull(triangle);
        Assert.assertEquals(3.0, triangle.GetA(), 0.001);
        Assert.assertEquals(4.0, triangle.GetB(), 0.001);
        Assert.assertEquals(5.0, triangle.GetC(), 0.001);
    }

    @Test
    public void testIsExist() {
        Triangle validTriangle = new Triangle(3, 4, 5);
        Triangle invalidTriangle = new Triangle(1, 1, 3);

        Assert.assertTrue(validTriangle.IsExist());
        Assert.assertFalse(invalidTriangle.IsExist());
    }

    @Test
    public void testGetPerimeter() {
        Triangle triangle = new Triangle(3, 4, 5);
        double expected = 12.0;
        Assert.assertEquals(expected, triangle.GetPerimetr(), 0.001);
    }

    @Test
    public void testGetSquare() {
        Triangle triangle = new Triangle(3, 4, 5);
        double expected = 6.0;
        Assert.assertEquals(expected, triangle.GetSquare(), 0.001);
    }

    @Test
    public void testEquilateralTriangle() {
        Triangle equilateral = new Triangle(5, 5, 5);
        Assert.assertTrue(equilateral.IsExist());
        Assert.assertEquals(15.0, equilateral.GetPerimetr(), 0.001);
        Assert.assertEquals(10.825, equilateral.GetSquare(), 0.001);
    }

    @Test
    public void testZeroSideTriangle() {
        Triangle zeroSide = new Triangle(0, 4, 5);
        Assert.assertFalse(zeroSide.IsExist());
    }

    @Test
    public void testNegativeSide() {
        Triangle negativeSide = new Triangle(-3, 4, 5);
        Assert.assertFalse(negativeSide.IsExist());
    }
}