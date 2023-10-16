package src.main.seminar_3;

/**
 * Task 2
 */
public class ArraysUtil {

    public <FirstArray, SecondArray> boolean compareArrays(FirstArray[] firstArrays, SecondArray[] secondArrays) {

        if (!firstArrays.getClass().isInstance(secondArrays)) {
            System.out.println("разные типы массивов");
            return false;
        }
        if (firstArrays.length != secondArrays.length) {
            System.out.println("разная длина массивов");
            return false;
        }
        return true;
    }
}
