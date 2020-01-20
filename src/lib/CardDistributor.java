package lib;

import java.util.ArrayList;
import java.util.Collections;

public class CardDistributor {

    private final ArrayList<String> cards;

    public CardDistributor(){
        cards = new ArrayList<>();
    }

    public void initializeCards(){
        for(String card: utils.CARDS){
            cards.add(card);
        }
    }

    public ArrayList<ArrayList<String>> generateCards(ArrayList<String> player1,ArrayList<String> player2,ArrayList<String> player3,ArrayList<String> player4) throws Exception{
        initializeCards();
        if(cards.size()!=52){
            throw new Exception("Not enough cards");
        }
        Collections.shuffle(cards);
        for(int i=0;i<13;i++){
            double shuffler = getShuffler();
            player1.add(cards.remove(((int)(shuffler*cards.size()*Math.random()))%cards.size()));
            player2.add(cards.remove(((int)(shuffler*cards.size()*Math.random()))%cards.size()));
            player3.add(cards.remove(((int)(shuffler*cards.size()*Math.random()))%cards.size()));
            player4.add(cards.remove(((int)(shuffler*cards.size()*Math.random()))%cards.size()));
        }

        //TODO sort cards according to suits?
        ArrayList<ArrayList<String>> distributedCards = new ArrayList<>(4);
        distributedCards.add(player1);
        distributedCards.add(player2);
        distributedCards.add(player3);
        distributedCards.add(player4);
        return distributedCards;
    }

    private void sortCards(ArrayList player){
        //TODO
    }

    private double getShuffler(){
        return utils.SHUFFLERS[((int)(Math.random()*11))% utils.SHUFFLERS.length];
    }
}
