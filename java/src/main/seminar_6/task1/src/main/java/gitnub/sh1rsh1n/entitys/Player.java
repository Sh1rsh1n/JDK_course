package main.java.gitnub.sh1rsh1n.entitys;

import java.util.Random;

public class Player {
    
    private BoxBroker broker;

    public Player(BoxBroker broker) {
        this.broker = broker;
    }
    public Player() {}

    public void setBoxBroker(BoxBroker broker) {
        this.broker = broker;
    }

    public boolean choiceBox(){
        int value = new Random().nextInt(3);
        System.out.printf("Выбрана коробка %d\n", value);
        return broker.answer(value);
    }

    public boolean openBox(){
        return new Random().nextBoolean();
    }
}
