package src.main.seminar_5;

import model.Fork;
import model.Philosopher;

public class Table implements Runnable{

    private Philosopher[] philosophers;
    private Fork[] forks;

    public Table() {
        philosophers = new Philosopher[5];
        forks = new Fork[6];
    }


    private void initPhilosophers() {
        philosophers[0] = new Philosopher(forks[0], forks[1]);
        philosophers[0] = new Philosopher(forks[1], forks[2]);
        philosophers[0] = new Philosopher(forks[2], forks[3]);
        philosophers[0] = new Philosopher(forks[3], forks[4]);
        philosophers[0] = new Philosopher(forks[5], forks[6]);
    }

    private void initForks() {
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork();
        }
    }
}



