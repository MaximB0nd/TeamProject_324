package bartasevichtests;

import allclasses.bartasevich.Complex;
import org.junit.Assert;
import org.junit.Test;

public class ComplexAddTests {
    @Test
    public void AddMethodOneAndTwoReturnsThree(){

        Complex complex = new Complex(1,1);
        double expected = 3.0;
        complex.AddComplex(2,2);
        Assert.assertEquals(expected, complex.getRe(),0.00001);
    }
    @Test
    public void AddMethodFiveAndTwoReturnsSeven(){

        Complex complex = new Complex(5,1);
        double expected = 7.0;
        complex.AddComplex(2,2);
        Assert.assertEquals(expected, complex.getRe(),0.00001);
    }
}
