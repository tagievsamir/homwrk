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

public class ArithmeticOperations {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return (double) a / b;
    }
}