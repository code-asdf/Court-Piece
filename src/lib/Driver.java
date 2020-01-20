package lib;

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
    //trump 0-S, 1-C, 2-H, 3-D
    private static char trump;


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
        int move = (int)(Math.random()*4);
        boolean continuePlay = true;
        while(continuePlay && Math.max(team1GlobalScore,team2GlobalScore)< utils.MAX_SCORE){
            generateCurrentBoard();
            if(move==0) {
                userInterface.displayCards(player1.subList(0, 5));
                trump = userInterface.getTrump();
            }else{
                //TODO generate trump for bot
            }

            userInterface.displayTrump(trump);

            //TODO if window is closed then exception handling
            userInterface.displayCards(player1);
            for(int i=0;i<13;i++){
                String moveP1="";
                String moveP2="";
                String moveP3="";
                String moveP4="";
                int firstMove = move;
                String firstMovePlayed = "";
                for(int j=0;j<4;move++){
                    if(move%4==0){
                        String movePlayed =userInterface.userMove();
                        if(move==firstMove) {
                            if(MoveChecker.isValidMove(player1, movePlayed, firstMovePlayed,cardsPlayed)){
                                firstMovePlayed = movePlayed;
                                moveP1 = movePlayed;
                            }else{
                                throw new Exception("Illegal Move");
                            }
                        }else{
                            if(MoveChecker.isValidMove(player1, movePlayed, firstMovePlayed,cardsPlayed)){
                                moveP1 = movePlayed;
                            }else{
                                throw new Exception("Illegal Move");
                            }
                        }
                        cardsPlayed.add(movePlayed);
                        player1.remove(movePlayed);
                        userInterface.displayCards(player1);
                        userInterface.putCardOnTable(movePlayed);
                    }else if(move%4==1){
                        //TODO get next move of bot
                        String movePlayed = "";
                        if(move==firstMove) {
                            if(MoveChecker.isValidMove(player2, movePlayed, firstMovePlayed,cardsPlayed)){
                                firstMovePlayed = movePlayed;
                                moveP2 = movePlayed;
                            }else{
                                throw new Exception("Illegal Move");
                            }
                        }else{
                            if(MoveChecker.isValidMove(player1, movePlayed, firstMovePlayed,cardsPlayed)){
                                moveP2 = movePlayed;
                            }else{
                                throw new Exception("Illegal Move");
                            }
                        }
                        cardsPlayed.add(movePlayed);
                        userInterface.putCardOnTable(movePlayed);
                        player2.remove(movePlayed);
                    }else if(move%4==2){
                        //TODO get next move of bot
                        String movePlayed = "";
                        if(move==firstMove) {
                            if(MoveChecker.isValidMove(player3, movePlayed, firstMovePlayed,cardsPlayed)){
                                firstMovePlayed = movePlayed;
                                moveP3 = movePlayed;

                            }else{
                                throw new Exception("Illegal Move");
                            }
                        }else{
                            if(MoveChecker.isValidMove(player1, movePlayed, firstMovePlayed,cardsPlayed)){
                                moveP3 = movePlayed;
                            }else{
                                throw new Exception("Illegal Move");
                            }
                        }
                        cardsPlayed.add(movePlayed);
                        userInterface.putCardOnTable(movePlayed);
                        player3.remove(movePlayed);
                    }else if(move%4==3){
                        //TODO get next move of bot
                        String movePlayed = "";
                        if(move==firstMove) {
                            if(MoveChecker.isValidMove(player4, movePlayed, firstMovePlayed,cardsPlayed)){
                                firstMovePlayed = movePlayed;
                                moveP4 = movePlayed;
                            }else{
                                throw new Exception("Illegal Move");
                            }
                        }else{
                            if(MoveChecker.isValidMove(player1, movePlayed, firstMovePlayed,cardsPlayed)){
                                moveP4 = movePlayed;
                            }else{
                                throw new Exception("Illegal Move");
                            }
                        }
                        cardsPlayed.add(movePlayed);
                        userInterface.putCardOnTable(movePlayed);
                        player4.remove(movePlayed);
                    }
                }
                move = MoveChecker.getWinner(moveP1,moveP2,moveP3,moveP4,firstMove,trump);
                userInterface.displayWinner(move);
            }
        }
    }



    public static void main(String[] args) throws Exception{
            generateGameWithUser();
    }
}
