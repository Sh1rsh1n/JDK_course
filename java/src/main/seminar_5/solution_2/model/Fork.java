package src.main.seminar_5.solution_2.model;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс, Fork, наследуем от класса ReentrantLock
 * @forkNo - номер вилки
 */
public class Fork extends ReentrantLock{

    private static int counter = 1;
    private final int forkNo;

    public Fork() {
        forkNo = counter++;
    }

    public int getForkNo() {
        return forkNo;
    }
}