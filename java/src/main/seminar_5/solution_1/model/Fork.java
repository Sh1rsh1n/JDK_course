package src.main.seminar_5.solution_1.model;

/**
 * Класс, вилка
 * параметры:
 * @available - доступность вилки
 * @forkNo - номер вилки
 */
public class Fork {

    private static int counter = 1;
    private boolean available;
    private final int forkNo;

    public Fork() {
        available = true;
        forkNo = counter++;
    }

    public int getForkNo() {
        return forkNo;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}