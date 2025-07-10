//Создайте 2 ветки: Lesson_7_junit_5 и Lesson_7_testng.
//
//Напишите 4 программы:
//позволяющую вычислить факториал числа;
//позволяющую найти площадь треугольника;
//совершающую арифметические действия с двумя целыми числами (сложение, вычитание, деление и умножение);
//сравнивающую два целых числа.
//Эти программы должны быть в каждой ветке
//
//
//В ветке Lesson_7_junit_5 напишите юнит-тесты для этих программ, используя Junit 5.
//
//
//В ветке Lesson_7_testng  напишите юнит-тесты для этих программ, используя TestNG.

public class TriangleAreaCalculator {
    public static double calculateArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be > 0");
        }
        return 0.5 * base * height;
    }
}