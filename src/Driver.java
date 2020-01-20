import java.util.ArrayList;

public class Driver {
    private static CardDistributor cardDistributor;
    private static ArrayList cardsPlayed;
    private static ArrayList player1;
    private static ArrayList player2;
    private static ArrayList player3;
    private static ArrayList player4;
    private static int team1Score;
    private static int team2Score;
    private static int team1GlobalScore;
    private static int team2GlobalScore;
    private static UserInterface userInterface;
    private static int trump;


    public static void generateCurrentBoard() throws Exception{
        player1 = new ArrayList(13);
        player2 = new ArrayList(13);
        player3 = new ArrayList(13);
        player4 = new ArrayList(13);
        cardDistributor.generateCards(player1,player2,player3,player4);
        team1Score = 0;
        team2Score = 0;
    }

    public static void generateGameWithUser() throws Exception{
        cardDistributor= new CardDistributor();
        team1GlobalScore = 0;
        team2GlobalScore = 0;
        userInterface = new UserInterface();
        boolean continuePlay = true;
        while(continuePlay && Math.max(team1GlobalScore,team2GlobalScore)<utils.MAX_SCORE){
            generateCurrentBoard();
            int move = (int)(Math.random()*4);
            if(move==0) {
                userInterface.displayCards(player1.subList(0, 5));
                userInterface.getTrump();
            }else{
                //TODO generate trump for bot
            }
            //TODO if window is closed then exception handling
            userInterface.displayCards(player1);
            for(int i=0;i<13;i++){
                for(int j=0;j<4;move++){
                    if(move%4==0){
                        userInterface.userMove();
                    }else if(move%4==1){
                        //TODO get next move of bot
                    }else if(move%4==2){
                        //TODO get next move of bot
                    }else if(move%4==3){
                        //TODO get next move of bot
                    }
                }
            }
        }
    }



    public static void main(String[] args) throws Exception{
            generateGameWithUser();
    }
}
