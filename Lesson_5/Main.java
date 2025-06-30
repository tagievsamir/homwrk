//В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
//и вывести результат расчета

public class Main {
    public static void main(String[] args) {
        String[][] table = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        ArrayProcessor processor = new ArrayProcessor();

        try {
            int result = processor.arrayProcessor(table);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
