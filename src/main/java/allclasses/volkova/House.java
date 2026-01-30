package allclasses.volkova;

public class House {
    protected String address;
    protected int floors;
    protected double area;
    protected String color;

    public House(String address, int floors, double area, String color) {
        this.address = address;
        this.floors = floors;
        this.area = area;
        this.color = color;
    }

    public String getAddress() {
        return address;
    }

    public int getFloors() {
        return floors;
    }

    public double getArea() {
        return area;
    }

    public String getColor() {
        return color;
    }

    public String getInfo() {
        return "Дом по адресу: " + address + ", этажей: " + floors + ", площадь: " + area + " м², цвет: " + color;
    }

    // Простые методы
    public String build() {
        return "Строится дом по адресу: " + address;
    }

    public String renovate() {
        return "Ремонтируется дом по адресу: " + address;
    }

    public void setArea(double newArea) {
        this.area = newArea;
    }

    public boolean isBig() {
        return area > 100.0;
    }

    public String getColorInfo() {
        return "Дом по адресу " + address + " имеет " + color + " цвет";
    }
}
