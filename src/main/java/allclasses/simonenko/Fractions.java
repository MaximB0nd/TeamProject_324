package allclasses.simonenko;

public class Fractions {
    private int num, den;

    public Fractions(int n, int d) {
        if (d == 0) throw new IllegalArgumentException("Знаменатель не может быть = 0");
        this.num = n;
        this.den = d;
        simplify();
    }

    public Fractions(int n) { this(n, 1); }

    private void simplify() {
        int gcd = gcd(Math.abs(num), Math.abs(den));
        num /= gcd;
        den /= gcd;
        if (den < 0) { num = -num; den = -den; }
    }

    private int gcd(int a, int b) {
        while (b != 0) { int t = b; b = a % b; a = t; }
        return a;
    }

    public Fractions add(Fractions other) {
        return new Fractions(
                num * other.den + other.num * den,
                den * other.den
        );
    }

    public Fractions subtract(Fractions other) {
        return new Fractions(
                num * other.den - other.num * den,
                den * other.den
        );
    }

    public String toString() {
        return den == 1 ? Integer.toString(num) : num + "/" + den;
    }
}

