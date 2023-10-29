package src.main.seminar_5.solution_2.model;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Класс, Философ
 * Параметры:
 *
 * @name - имя
 * @leftFork - вилка слева от философа
 * @rigthFork - вилка справа от философа
 * @satiety - сытости философа
 */
public class Philosopher implements Runnable{

    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;
    private int satiety;

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }

    public int getSatiety() {
        return satiety;
    }

    /**
     * Метод имитации процесса приема пищи философом
     * проверяет доступность вилок справа, слева и сытость философа
     * далее, меняет доступность вилок и засыпает на 5 секунд, после вызывает метод размышления(think())
     */
    public void eat() {
        try {
            if (leftFork.getLock().tryLock(6L, TimeUnit.SECONDS) && rightFork.getLock().tryLock(6L, TimeUnit.SECONDS) && satiety < 3) {

                System.out.printf("Философ %s решил покушать.\nСхватил вилки # %s и # %s\n", name, leftFork.getForkNo(), rightFork.getForkNo());

                Thread.sleep(3000);

                System.out.printf("Философ %s наелся. Он поел уже %d\n", name, ++satiety);

                think();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    /**
     * Метод, размышления
     * меняет состояние вилок на "доступны" (true)
     * засыпает на 5 секунд
     */
    private void think() {
        System.out.printf("Философ %s думает.\n", name);

        leftFork.getLock().unlock();
        rightFork.getLock().unlock();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        eat();
    }
}