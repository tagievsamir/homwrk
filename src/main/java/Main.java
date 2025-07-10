public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Factorial: " + FactorialCalculator.factorial(0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Area: " + TriangleAreaCalculator.calculateArea(2, 5));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Divide: " + ArithmeticOperations.divide(1, 5));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Add: " + ArithmeticOperations.add(1, 2));
        System.out.println("Subtract: " + ArithmeticOperations.subtract(5, 6));
        System.out.println("Multiply: " + ArithmeticOperations.multiply(3, 4));
        System.out.println("Compare: " + NumberComparator.compare(-8, 4));
    }
}