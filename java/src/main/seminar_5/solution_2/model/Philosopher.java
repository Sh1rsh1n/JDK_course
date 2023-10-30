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
public class Philosopher extends Thread {

    private final String name;
    private final Lock leftFork;
    private final Lock rightFork;
    private int satiety;
    private Semaphore semaphor;

    public Philosopher(String name, Fork leftFork, Fork rightFork, Semaphore semaphore) {
        this.name = name;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
        this.semafor = semaphore;
    }

    /**
     * Метод имитации процесса приема пищи философом
     * проверяет доступность вилок справа, слева и сытость философа
     * далее, меняет доступность вилок и засыпает на 5 секунд, после вызывает метод размышления(think())
     */
    public void eat() {
        try {
          while (satiny < 3) {
            if (leftFork.tryLock() && semaphor.tryAcquire()) {
              if (rightFork.tryLock()) {

                System.out.printf("Философ %s решил покушать.\nСхватил вилки # %s и # %s\n", name, leftFork.getForkNo(), rightFork.getForkNo());

                Thread.sleep(3000);

                System.out.printf("Философ %s наелся. Он поел уже %d\n", name, ++satiety);

                think();
              } else {
                leftFork.unlock();
                semaphor.release();
              }
            }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
          leftFork.unlock();
          rightFork.unlock();
        }
    }



    /**
     * Метод, размышления
     * меняет состояние вилок на "доступны" (true)
     * засыпает на 5 секунд
     */
    private void think() {
        System.out.printf("Философ %s думает.\n", name);

        semaphor.release();

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