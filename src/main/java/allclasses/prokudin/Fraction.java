package allclasses.prokudin;

import java.nio.file.AccessDeniedException;

public class Fraction {

    public int Numerator;
    public int Denominator;

    public Fraction(int numerator, int denominator) {
        Numerator =  numerator;
        Denominator = denominator;
    };

    public Fraction() {
        Numerator = 0;
        Denominator = 0;
    };

    private int GCD(int numerator, int denominator) {
        int result = 0;
        if (numerator != 0 && denominator != 0) {
            if (numerator > denominator) {
                numerator = numerator % denominator;
            }
            else {
                denominator = denominator % numerator;
            }
            return GCD(Math.abs(numerator), Math.abs(denominator));
        }
        else {
            return numerator + denominator;
        }
    };

    public void Reduction() {
        int greatestCommonDivisor = GCD(Numerator, Denominator);
        Numerator /= greatestCommonDivisor;
        Denominator /= greatestCommonDivisor;
    };

    static public Fraction Sum(Fraction fraction_a, Fraction fraction_b) {
        int numerator = 0;
        int denominator = 0;

        if (fraction_a.Denominator == fraction_b.Denominator) {
            numerator = fraction_a.Numerator + fraction_b.Numerator;
            denominator = fraction_a.Denominator;
        }
        else {
            numerator = fraction_a.Numerator * fraction_b.Denominator +
                        fraction_b.Numerator * fraction_a.Denominator;
            denominator = fraction_a.Denominator * fraction_b.Denominator;
        }
        Fraction result = new Fraction(numerator, denominator);
        result.Reduction();
        return result;
    };

    static public Fraction Substraction(Fraction fraction_a, Fraction fraction_b) {
        int numerator = 0;
        int denominator = 0;

        if (fraction_a.Denominator == fraction_b.Denominator) {
            numerator = fraction_a.Numerator - fraction_b.Numerator;
            denominator = fraction_a.Denominator;
        }
        else {
            numerator = fraction_a.Numerator * fraction_b.Denominator -
                        fraction_b.Numerator * fraction_a.Denominator;
            denominator = fraction_a.Denominator * fraction_b.Denominator;
        }
        Fraction result = new Fraction(numerator, denominator);
        result.Reduction();
        return result;
    };

    static public Fraction Multi(Fraction fraction_a, Fraction fraction_b) {
        int numerator = 0;
        int denominator = 0;

        numerator = fraction_a.Numerator * fraction_b.Numerator;
        denominator = fraction_a.Denominator * fraction_b.Denominator;
        Fraction result = new Fraction(numerator, denominator);
        result.Reduction();
        return result;
    };

    static public Fraction Div(Fraction fraction_a, Fraction fraction_b) {
        int numerator = 0;
        int denominator = 0;

        numerator = fraction_a.Numerator * fraction_b.Denominator;
        denominator = fraction_a.Denominator * fraction_b.Numerator;
        Fraction result = new Fraction(numerator, denominator);
        result.Reduction();
        return result;
    };

}
