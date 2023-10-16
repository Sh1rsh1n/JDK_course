package src.main.seminar_3;

/**
 * Task 1
 */
public class Calculator {

    public static <First extends Number, Second extends Number> double sum(First value1, Second value2) {
        return value1.doubleValue() + value2.doubleValue();
    }
    public static <First extends Number, Second extends Number> double subtract(First value1, Second value2) {
        return value1.doubleValue() - value2.doubleValue();
    }

    public static <First extends Number, Second extends Number> double multiply(First value1, Second value2) {
        return value1.doubleValue() * value2.doubleValue();
    }

    public static <First extends Number, Second extends Number> double division(First value1, Second value2) {
        if ((value2 instanceof Integer || value2 instanceof Long) && value2.intValue() == 0) {
            throw new RuntimeException("Incorrect value, division by zero.");
        }
        return value1.doubleValue() / value2.doubleValue();
    }

}
