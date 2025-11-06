package bartasevichtests;

import allclasses.bartasevich.Complex;
import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.sqrt;

public class ComplexAbsTests {
    @Test
    public void AbsMethodReturnsSqrt2(){

        Complex complex = new Complex(1,1);
        double expected = sqrt(2);
        double actual = complex.Abs();
        Assert.assertEquals(expected, actual,0.00001);
    }
}
