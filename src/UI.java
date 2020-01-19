import java.util.ArrayList;
import java.util.Arrays;

public class UI {
    private final CardDistributor cardDistributor;

    public UI() throws Exception{
        cardDistributor= new CardDistributor();
        ArrayList cards = cardDistributor.generateCards();
        System.out.println(Arrays.toString(cards.toArray()));
    }

    public static void generateGame() throws Exception{
        UI userInterface = new UI();
    }

    public static void main(String[] args) throws Exception{
            generateGame();
    }
}
