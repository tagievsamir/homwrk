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

public class FactorialCalculator {
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is undefined for negative numbers");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Factorials of numbers greater than 20 may cause an overflow");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}