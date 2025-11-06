package allclasses.shulga;

public class triangle {

    private double a;
    private double b;
    private double c;

    public triangle (int _a, int _b, int _c){
        a = _a;
        b = _b;
        c = _c;
    }

    public boolean IsExist(){
        if (a+b <= c) return false;
        if (a+c <= b) return false;
        if (b+c <= a) return false;

        return true;
    }

    public double GetPerimetr(){
        return a+b+c;
    }

    public double GetSquare(){
        double half_p = (a+b+c)/2;

        return Math.sqrt(half_p * (half_p - a) * (half_p - b) * (half_p - c));
    }


}
