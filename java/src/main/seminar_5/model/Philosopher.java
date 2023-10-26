package src.main.seminar_5.model;


public class Philosopher implements PhilosopherAction{

    private static int philosopherCounter = 1;
    private Fork leftFork;
    private Fork rightFork;
    private int philosopherNo;
    private int eaterCounter;

    {
        philosopherNo = philosopherCounter++;
    }

    public Philosopher(Fork leftFork, Fork rightFork) {
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }

    public int getEaterCounter() {
        return eaterCounter;
    }

    @Override
    public void eat() {
        System.out.printf("Философ №%d кушает.", philosopherNo);
        eaterCounter++;

        leftFork.setAvaliable(false);
        rightFork.setAvaliable(false);
        Thread.sleep(5000);
        leftFork.setAvaliable(true);
        rightFork.setAvaliable(true);

    }

    @Override
    public void think() {
        System.out.println("Филосов №%d думает.", philosopherNo);
    }
}