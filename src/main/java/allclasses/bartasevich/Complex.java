package allclasses.bartasevich;

import static java.lang.Math.sqrt;

public class Complex {
    private double im;
    private double re;
    public Complex(){
        im=0;
        re=0;
    }
    public Complex(double re, double im){
        this.re = re;
        this.im = im;
    }
public double Arg(){
        return im/re;
}
public double Abs(){
    return sqrt(re*re + im*im);


}
}
