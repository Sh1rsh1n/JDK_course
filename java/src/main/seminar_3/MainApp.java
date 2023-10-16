package src.main.seminar_3;

import java.util.Random;
import static src.main.seminar_3.Calculator.*;
/*
1. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract().
Параметры этих методов – два числа разного типа (но необязательно разного между собой), над которыми должна быть произведена операция.

2. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных,
но должны иметь одинаковую длину и содержать элементы одного типа.

3. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
а также переопределение метода toString(), возвращающее строковое представление пары.
 */
public class MainApp {

    public static void main(String[] args) {
        Random rnd = new Random();

        //region Task1
        int intValue = rnd.nextInt(100);
        double doubleValue = rnd.nextDouble() + rnd.nextInt(100);
        float floatValue = rnd.nextFloat() + rnd.nextInt(100);

        System.out.printf("%d + %f = %f\n", intValue, doubleValue, sum(intValue, doubleValue));
        System.out.printf("%f - %f = %f\n", floatValue, doubleValue, subtract(floatValue, doubleValue));
        System.out.printf("%f * %d = %f\n", floatValue, intValue, multiply(floatValue, intValue));
        System.out.printf("%f / %d = %f\n", doubleValue, intValue, division(doubleValue, intValue));
        //endregion

        //region Task2
        Integer[] array1 = {1,2,5,6,4,3};
        Integer[] array2 = {1,2,5,6,4,3};
        Double[] array3 = {1.0,2.2,5.4,6.6,4.1,3.6};
        Integer[] array4 = {1,2,5,6,4};

        boolean value = new ArraysUtil().compareArrays(array1, array2);
        System.out.println(value ? "Массивы одинаковые\n" : "Массивы не одинаковые\n");

        value = new ArraysUtil().compareArrays(array2, array3);
        System.out.println(value ? "Массивы одинаковые\n" : "Массивы не одинаковые\n");

        value = new ArraysUtil().compareArrays(array1, array4);
        System.out.println(value ? "Массивы одинаковые\n" : "Массивы не одинаковые\n");

        //endregion

        //region Task3
        Pair<Integer, String> pair = new Pair<>(rnd.nextInt(100), "Any String...");

        System.out.println(pair);

        //endregion
    }
}
