package allclasses.karenin;

///
//        * Класс KareninRectangle представляет прямоугольник
// * Автор: Karenin
// */
public class KareninRectangle{
    private double width;
    private double height;

//    /
//            * Конструктор прямоугольника
//     *
//             * @param width  ширина прямоугольника (должна быть > 0)
//     * @param height высота прямоугольника (должна быть > 0)
//     * @throws IllegalArgumentException если ширина или высота <= 0
//            */
    public KareninRectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Ширина и высота должны быть больше 0");
        }
        this.width = width;
        this.height = height;
    }

    // Геттеры
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

//    /
//            * Метод 1: Вычисление площади прямоугольника
//     *
//             * @return площадь прямоугольника
//     */
    public double getArea() {
        return width * height;
    }

//    /
//            * Метод 2: Вычисление периметра прямоугольника
//     *
//             * @return периметр прямоугольника
//     */
    public double getPerimeter() {
        return 2 * (width + height);
    }

//    /
//            * Метод 3: Проверка, является ли прямоугольник квадратом
//     *
//             * @return true если прямоугольник является квадратом
//     */
    public boolean isSquare() {
        return Math.abs(width - height) < 0.000001; // учтем погрешность double
    }

//    /
//            * Метод 4: Вычисление диагонали прямоугольника
//     *
//             * @return длина диагонали
//     */
    public double getDiagonal() {
        return Math.sqrt(width * width + height * height);
    }

    /**
     * Метод 5: Увеличение размеров прямоугольника
     *
     * @param factor коэффициент увеличения (должен быть > 0)
     * @return новый увеличенный прямоугольник
     */
    public KareninRectangle scale(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Коэффициент масштабирования должен быть больше 0");
        }
        return new KareninRectangle(width * factor, height * factor);
    }

    @Override
    public String toString() {
        return String.format("KareninRectangle[width=%.2f, height=%.2f]", width, height);
    }
}