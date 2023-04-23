import java.util.Random;

/**
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
 * каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
 * Если длины массивов не равны, необходимо как-то оповестить пользователя.
 * * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
 * и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
 * Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение,
 * которое пользователь может увидеть - RuntimeException, т.е. ваше.
 */

public class Task {
    public static void main(String[] args) {
        int[] array1 = randomArrayGenerator();
        int[] array2 = randomArrayGenerator();
        System.out.printf("Первый массив:\n%s\nВторой массив:\n%s\n", printer(array1), printer(array2));

        // Нахождение суммы двух массивов

        int[] resultSum = sumArrays(array1, array2);
        System.out.println("Сумма массивов:");
        for (int i : resultSum) {
            System.out.printf("%d\t", i);
        }
        System.out.println();

        // Нахождение частного двух массивов

        double[] resultDiv = divArrays(array1, array2);
        System.out.println("Частное массивов:");
        for (double i : resultDiv) {
            System.out.printf("%s\t", i);
        }
        System.out.println();
    }

    /**
     * Метод складывания двух массивов
     *
     * @param a Первый массив
     * @param b Второй массив
     * @return Результирующий массив
     */
    private static int[] sumArrays(int[] a, int[] b) {
        if (a == null || b == null) {
            throw new RuntimeException("Один или оба массива не инициализированы");
        }
        if (a.length != b.length) {
            throw new RuntimeException("Размеры массивов не равны");
        }
        int[] sumArray = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            sumArray[i] = a[i] + b[i];
        }
        return sumArray;
    }

    /**
     * Метод генерации случайного массива (может вернуть null с шансом 10%)
     *
     * @return Случайный массив
     */
    private static int[] randomArrayGenerator() {
        Random r = new Random();
        int[] array = new int[r.nextInt(4, 6)];
        if (r.nextInt(10) == 0) {
            array = null; // Шанс 10%, что массив заменится на null
        } else {
            for (int i = 0; i < array.length; i++) {
                array[i] = r.nextInt(5);
            }
        }
        return array;
    }

    /**
     * Метод распечатывает массив
     *
     * @param a Массив для распечатки
     * @return Массив в виде строки готовый для печати
     */
    private static String printer(int[] a) {
        if (a == null) {
            return "null";
        }
        StringBuilder result = new StringBuilder();
        for (int i : a) {
            result.append(i).append("\t");
        }
        System.out.println();
        return result.toString();
    }

    private static double[] divArrays(int[] a, int[] b) {
        if (a == null || b == null) {
            throw new RuntimeException("Один или оба массива не инициализированы");
        }
        if (a.length != b.length) {
            throw new RuntimeException("Размеры массивов не равны");
        }
        double[] divArray = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            if (b[i] != 0) {
                divArray[i] = (double) a[i] / b[i];
            } else {
                throw new RuntimeException("Деление массивов не возможно, так как во втором массиве имеются нули");
            }
        }
        return divArray;
    }
}