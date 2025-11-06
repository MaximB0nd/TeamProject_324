package bartasevichtests;

import allclasses.bartasevich.Complex;
import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.atan;

public class ComplexArgTests {
    @Test
    public void AddMethodOneAndTwoReturnsThree(){

        Complex complex = new Complex(1,1);
        double expected = atan(1);
        double actual = complex.Arg();
        Assert.assertEquals(expected, actual,0.00001);
    }
}
