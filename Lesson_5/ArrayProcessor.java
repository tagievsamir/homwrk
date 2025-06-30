//1.Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера
//необходимо бросить исключение MyArraySizeException.
//2.Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе
//массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
//исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

public class ArrayProcessor {
    public int arrayProcessor(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if (arr.length != 4) {
            throw new MyArraySizeException("Неверный размер внешнего массива");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Неверный размер вложенного массива на позиции " + i);
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверный тип данных в ячейке [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }
}
