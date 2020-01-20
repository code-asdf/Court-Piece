package lib;

public class cardUtilFunc {

    // method to compare 2 cards
    // card1 > card2 => 1   card2 > card1 => -1   card1=card2 => 0
    public static int cardComparator(String card1, String card2, char trump) {

        if(card1.equalsIgnoreCase(card2)){
            return 0;
        }

        char suit1 = card1.charAt(1), suit2 = card2.charAt(1);
        int value1 = cardValue(card1), value2 = cardValue(card2);

        if(suit1 == suit2){
            if(value1 > value2) return 1;
            else return -1;
        }
        else if(suit1 == trump){
            return 1;
        }
        else if(suit2 == trump){
            return -1;
        }
        else{
            return 1;
        }
    }

    public static int cardValue(String card){
        switch (card.charAt(0)) {
            case 'A':
                return 13;
            case 'K':
                return 12;
            case 'Q':
                return 11;
            case 'J': 
                return 10;
            default:
                return Character.getNumericValue(card.charAt(0));
        }
    }
}