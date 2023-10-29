package src.main.seminar_5.solution_2.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс, вилка
 * параметры:
 * @lock - блокировка по вызову из другого класса или метода
 * @forkNo - номер вилки
 */
public class Fork {

    private static int counter = 1;
    private final Lock lock;
    private final int forkNo;

    public Fork() {
        lock = new ReentrantLock();
        forkNo = counter++;
    }

    public int getForkNo() {
        return forkNo;
    }

    public Lock getLock() {
        return lock;
    }
}