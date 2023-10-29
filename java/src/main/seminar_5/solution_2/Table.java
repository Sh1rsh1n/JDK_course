package src.main.seminar_5.solution_2;


import src.main.seminar_5.solution_2.model.Fork;
import src.main.seminar_5.solution_2.model.Philosopher;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Класс, Table выполняет инициализацию философов и вилок
 * метод init() - определяет порядок расположения вилок между философами
 * метод start() - запускает приложение
 */
public class Table {

    private Philosopher[] philosophers = new Philosopher[5];
    private Fork[] forks = new Fork[5];

    public Table() {
        init();
    }

    /**
     * Запуск потоков с философами, у которых вызываем метод eat()
     */
    public void start() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; i < 5; i++) {
                int finalI = j;
                new Thread(philosophers[finalI]).start();
            }
        }
    }

    /**
     * Метод инициализации, "рассаживаем философов за стол и раскладываем вилки между ними"
     */
    private void init() {
        // forks init
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork();
        }

        System.out.println("Вилки разложены");

        // philosophers init
        philosophers[0] = new Philosopher("Платон", forks[4], forks[0]);
        philosophers[1] = new Philosopher("Аристотель", forks[0], forks[1]);
        philosophers[2] = new Philosopher("Гераклит", forks[1], forks[2]);
        philosophers[3] = new Philosopher("Демокрит", forks[2], forks[3]);
        philosophers[4] = new Philosopher("Гиппократ", forks[3], forks[4]);

        System.out.println("Философы уселись за стол");
    }


}



