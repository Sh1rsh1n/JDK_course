package main.java.gitnub.sh1rsh1n.entitys;

import java.util.Random;

public class BoxBroker {
    
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    private Box[] boxs;

    public BoxBroker(Player player) {
        this.player = player;
        this.player.setBoxBroker(this);
    }

    public boolean start() {
        setPrize();
        return player.choiceBox();
    }

    public boolean answer(int boxNumber) {
        if (boxs[boxNumber] != null ){
            boxs = null;
            System.out.println("Угадал");
            return true;
        }
        boxs = null;
        System.out.println("Неугадал");
        return false;
    }

    private void setPrize(){
        boxs = new Box[3];
        int number = new Random().nextInt(3);
        boxs[number] = new Box("Приз");
        System.out.printf("Приз лежит в коробке № %d\n", number);
    }
}