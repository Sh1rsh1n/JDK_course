package main.java.gitnub.sh1rsh1n.entitys;

import java.util.Arrays;
import java.util.Random;

import main.java.gitnub.sh1rsh1n.entitys.cards.CarCard;
import main.java.gitnub.sh1rsh1n.entitys.cards.Card;
import main.java.gitnub.sh1rsh1n.entitys.cards.PigCard;

public class CardBroker {
    
    private Player player;
    private Card[] cards;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CardBroker(Player player) {
        this.player = player;
        cards = new Card[]{
            new CarCard("Машина"), 
            new PigCard("Свинка"), 
            new PigCard("Свинка")};
        mixCards();
    };

    public void answer(int cardIndex) {
        
    }

    private void mixCards(){
        System.out.println("Начинаю перемешивать карты...");
        Card[] temp = new Card[cards.length];
        Random rnd = new Random();
        for (int index = 0; index < temp.length; index++) {
            int cardsIndex;

            do {
                cardsIndex = rnd.nextInt(3) - 1;
            } while(cards[cardsIndex] == null);

            temp[index] = cards[cardsIndex];
            cards[cardsIndex] = null;
        }
        System.arraycopy(temp, 0, cards, 0, temp.length);
        System.out.println("Карты перемешаны.\nУгадай, где машина?");
        player.choiceCard();
    }
}
