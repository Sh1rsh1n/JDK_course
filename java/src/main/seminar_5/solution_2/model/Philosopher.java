package src.main.seminar_5.solution_2.model;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Класс, Философ
 *
 * @name - имя
 * @leftFork - вилка слева от философа
 * @rigthFork - вилка справа от философа
 * @satiety - сытости философа
 * @semaphore
 */
public class Philosopher extends Thread {

    private final String name;
    private final Fork leftFork;
    private final Fork rightFork;
    private int satiety;
    private Semaphore semaphore;

    public Philosopher(String name, Fork leftFork, Fork rightFork, Semaphore semaphore) {
        this.name = name;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
        this.semaphore = semaphore;
    }

    /**
     * Метод имитации процесса приема пищи философом
     * пытается заблокировать вначале левую от себя вилку, а затем правую
     * в случае успеха, меняет значение семафора
     * все это выполняется в цикле, пока философ не наестся (параметр satiety < 3)
     *
     * если правую вилку не получилось захватить, то отпускает левую (чтобы не было взаимной блокировки)
     * так же освобождает семафор
     */
    private void eat() {
        try {
            while (satiety < 3) {
                if (leftFork.tryLock()) {
                    System.out.printf("Философ %s взял левую вилку\n", name);
                    if (rightFork.tryLock()) {
                        semaphore.acquire();
                        System.out.printf("Философ %s взял правую вилку\n", name);

                        System.out.printf("У философа %s теперь обе вилки # %s и # %s и он может поесть\n",
                                name, leftFork.getForkNo(), rightFork.getForkNo());

                        System.out.println(name + " кушает.");

                        Thread.sleep(5000);

                        satiety++;

                        System.out.printf("Философ %s наелся. Он поел уже %d\n", name, satiety);

                        think();

                    } else {
                        leftFork.unlock();
                        semaphore.release();
                        System.out.println(name + " положил левую вилку, так как не смог взять правую.");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод, размышления
     * разблокирует вилки
     * освобождает семафор
     * засыпает на 5 секунд
     */
    private void think() {

        System.out.printf("Философ %s думает.\n", name);

        semaphore.release();

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