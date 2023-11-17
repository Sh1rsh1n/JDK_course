package main.java.gitnub.sh1rsh1n.entitys;

import java.util.Random;

public class BoxBroker {
    
    private Player player;
    private Box[] boxs;

    public BoxBroker() {
        player = new Player(this);
        boxs = new Box[3];
    }

    public boolean start() {
        setPrize();
        return player.choiceBox();
    }

    public boolean answer(int boxNumber) {
        if (boxs[boxNumber] != null ){
            boxs[boxNumber] = null;
            System.out.println("Угадал");
            return true;
        }
        boxs[boxNumber] = null;
        System.out.println("Неугадал");
        return false;
    }

    private void setPrize(){
        int number = new Random().nextInt(3);
        boxs[number] = new Box("Приз");
        System.out.printf("Приз лежит в коробке № %d\n", number);
    }
}