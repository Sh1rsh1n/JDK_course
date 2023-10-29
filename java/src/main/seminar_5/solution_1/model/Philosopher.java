package src.main.seminar_5.solution_1.model;

/**
 * Класс, Философ
 * Параметры:
 * @name - имя
 * @leftFork - вилка слева от философа
 * @rigthFork - вилка справа от философа
 * @satiety - сытости философа
 */
public class Philosopher {

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
        if (leftFork.getAvailable() && rightFork.getAvailable() && satiety < 3) {
            leftFork.setAvailable(false);
            rightFork.setAvailable(false);
            System.out.printf("Философ %s решил покушать.\nСхватил вилки # %s и # %s\n", name, leftFork.getForkNo(), rightFork.getForkNo());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Философ %s наелся. Он поел уже %d\n", name, ++satiety);
            think();
        }
    }

    /**
     * Метод, размышления
     * меняет состояние вилок на "доступны" (true)
     * засыпает на 5 секунд
     */
    private void think() {
        System.out.printf("Философ %s думает.\n", name);
        leftFork.setAvailable(true);
        rightFork.setAvailable(true);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}