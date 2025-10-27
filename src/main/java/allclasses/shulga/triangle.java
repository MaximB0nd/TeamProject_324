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

    public bool IsExist(){
        if (a+b <= c) return False;
        if (a+c <= b) return False;
        if (b+c <= a) return False;

        return True;
    }

    public double GetPerimetr(){
        return a+b+c;
    }

    public double GetSquare(){
        dobule half_p = (a+b+c)/2;

        return Math.sqrt(half_p * (half_p - a) * (half_p - b) * (half_p - c));
    }


}
