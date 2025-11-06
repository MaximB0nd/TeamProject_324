package allclasses.bondarev;

public class Mark {

    private float number;

    public float get() {
        return number;
    }

    public Mark() {
        number = 0;
    }

    public Mark(int value) {
        number = value;
        checkCurrentValue();
    }

    private void checkCurrentValue() {
        if (number > 5) {
            number = 5;
        } else if (number < 0) {
            number = 0 ;
        }
    }

    public void plus() {
        number++;
        checkCurrentValue();
    }

    public void minus() {
        number--;
        checkCurrentValue();
    }

    public void plus(int number) {
        this.number += number;
        checkCurrentValue();
    }

    public void minus(int number) {
        this.number -= number;
        checkCurrentValue();
    }

    public void set(int value) {
        number = value;
        checkCurrentValue();
    }
}
