package src.main.seminar_5.solution_2.model;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

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
    private final Fork leftFork;
    private final Fork rightFork;
    private int satiety;
    private Semaphore semaphor;

    public Philosopher(String name, Fork leftFork, Fork rightFork, Semaphore semaphore) {
        this.name = name;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
        this.semaphor = semaphore;
    }

    /**
     * Метод имитации процесса приема пищи философом
     * проверяет доступность вилок справа, слева и сытость философа
     * далее, меняет доступность вилок и засыпает на 5 секунд, после вызывает метод размышления(think())
     */
    public void eat() {
        try {
          while (satiety < 3) {
            if (leftFork.tryLock() && semaphor.tryAcquire()) {
              System.out.printf("Философ %s взял левую вилку\n", name);
              if (rightFork.tryLock()) {
                System.out.printf("Философ %s взял правую вилку\n", name);

                System.out.printf("У Философа %s теперь обе вилки # %s и # %s и он может поесть\n", name, leftFork.getForkNo(), rightFork.getForkNo());
                System.out.println(name + "кушает");

                Thread.sleep(3000);

                satiety++;

                System.out.printf("Философ %s наелся. Он поел уже %d\n", name, satiety);

                think();
                
              } else {
                leftFork.unlock();
                semaphor.release();
                System.out.println(name + " положил левую вилку, так как не смог взять правую.");
                try {
                  Thread.sleep(2000);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
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

        leftFork.unlock();
        rightFork.unlock();

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