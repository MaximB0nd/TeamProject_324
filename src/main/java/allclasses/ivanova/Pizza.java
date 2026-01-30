package allclasses.ivanova;

public class Pizza {
    private String size;          // small, medium, large
    private int toppings;         // количество топпингов
    private boolean cheeseCrust;  // сырный бортик

    public Pizza(String size, int toppings, boolean cheeseCrust) {
        this.size = size;
        this.toppings = Math.max(0, toppings);
        this.cheeseCrust = cheeseCrust;
    }

    // Добавить топпинг
    public void addTopping() {
        toppings++;
    }

    // Расчёт калорий пиццы
    public int getCalories() {
        int calories = 0;

        switch(size.toLowerCase()) {
            case "small":
                calories = 600;
                break;
            case "medium":
                calories = 900;
                break;
            case "large":
                calories = 1200;
                break;
        }

        calories += toppings * 80;

        if (cheeseCrust) {
            calories += 150;
        }
        return calories;
    }

    public String getSize() {
        return size;
    }

    public int getToppings() {
        return toppings;
    }

    public boolean hasCheeseCrust() {
        return cheeseCrust;
    }
}
