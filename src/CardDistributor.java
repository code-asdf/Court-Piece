import java.util.ArrayList;

public class CardDistributor {

    private final ArrayList<String> cards;

    public CardDistributor(){
        cards = new ArrayList<>();
        initializeCards();
    }

    public void initializeCards(){
        for(String card: utils.CARDS){
            cards.add(card);
        }
    }

    public ArrayList<ArrayList<String>> generateCards() throws Exception{
        ArrayList<String> player1 = new ArrayList<>(13);
        ArrayList<String> player2 = new ArrayList<>(13);
        ArrayList<String> player3 = new ArrayList<>(13);
        ArrayList<String> player4 = new ArrayList<>(13);

        if(cards.size()!=52){
            throw new Exception("Not enough cards");
        }
        for(int i=0;i<13;i++){
            double shuffler = getShuffler();
            player1.add(cards.remove(((int)(shuffler*cards.size()*Math.random()))%cards.size()));
            player2.add(cards.remove(((int)(shuffler*cards.size()*Math.random()))%cards.size()));
            player3.add(cards.remove(((int)(shuffler*cards.size()*Math.random()))%cards.size()));
            player4.add(cards.remove(((int)(shuffler*cards.size()*Math.random()))%cards.size()));
        }

        ArrayList<ArrayList<String>> distributedCards = new ArrayList<>(4);
        distributedCards.add(player1);
        distributedCards.add(player2);
        distributedCards.add(player3);
        distributedCards.add(player4);
        return distributedCards;
    }

    private double getShuffler(){
        return utils.SHUFFLERS[((int)(Math.random()*11))%utils.SHUFFLERS.length];
    }
}
