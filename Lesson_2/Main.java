import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords();//1
        checkSumSign();//2
        printColor();//3
        compareNumbers();//4
        System.out.println(sumRange(1000,2));//5
        checkNumber(-23);//6
        System.out.println(isNegative(-2));//7
        printStringNTimes("Hello", 4);//8
        System.out.println(checkYear(4));//9
        //10.Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        //С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] binaryArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < binaryArray.length; i++) {
            if (binaryArray[i] == 0) {
                binaryArray[i] = 1;
            } else binaryArray[i] = 0;
        }
        System.out.println(Arrays.toString(binaryArray));
        //11.Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
        int[] sequenceArray = new int[100];
        for (int i = 0; i <100; i++) {
            sequenceArray[i] = i + 1;
        }
        System.out.println(Arrays.toString(sequenceArray));
        //12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] modArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < modArray.length; i++){
            if (modArray[i] < 6) {
                modArray[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(modArray));
        //13.Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        //и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
        //Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
        //то есть [0][0], [1][1], [2][2], ..., [n][n];
        int[][] matrixArray = new int[5][5];
        for (int i = 0; i < 5; i++) {
            matrixArray[i][i] = 1;
            matrixArray[i][matrixArray[i].length -1 -i] = 1;
        }
        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < matrixArray[i].length; j++) {
                System.out.print(matrixArray[i][j] + " ");
            }
            System.out.println();
        }
        int[] arr = createIntArray(4,5);//14
        System.out.println(Arrays.toString(arr));//14
    }
    /*1.Создайте метод printThreeWords(), который при вызове должен
    отпечатать в столбец три слова: Orange, Banana, Apple*/
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    //2.Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте
    //их любыми значениями, которыми захотите.Далее метод должен просуммировать эти переменные,
    //и если их сумма больше или равна 0,то вывести в консоль сообщение “Сумма положительная”,
    //в противном случае - “Сумма отрицательная”.
    public static void checkSumSign() {
        int a = 1;
        int b = 2;
        if ((a + b) >= 0) {
                System.out.println("Сумма положительная");
        } else {
                System.out.println("Сумма отрицательная");
        }
    }//3.Создайте метод printColor() в теле которого задайте int переменную value
    // и инициализируйте ее любым значением. Если value меньше 0 (0 включительно),
    // то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах
    // от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
    // если больше 100 (100 исключительно) - “Зеленый”.
    public static void printColor() {
        int value = 1;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 &&  value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    //4.Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
    // и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b,
    // то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”.
    public static void compareNumbers() {
        int a = 1;
        int b = 2;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    //5.Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
    //в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    public static boolean sumRange(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }
    //6.Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    //положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }
    //7.Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если
    //число отрицательное, и вернуть false если положительное.Замечание: ноль считаем положительным числом.
    public static boolean isNegative(int num) {
        return num < 0;
    }
    //8.Напишите метод, которому в качестве аргументов передается строка и число,
    //метод должен отпечатать в консоль указанную строку, указанное количество раз
    public static void printStringNTimes(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
    //9.Напишите метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true,
    //не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean checkYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    //14.Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий
    //одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
    public static int[] createIntArray(int len, int initialValue) {
        int[] result = new int[len];
        for( int i = 0; i < len; i++) {
            result[i] = initialValue;
        }
        return result;
    }
}
