package lib;

public class cardUtilFunc {

    // method to compare 2 cards
    // card1 => current card
    // card2 => winning card till now
    // @return card1 > card2 => true   card2 > card1 => false
    public static boolean cardComparator(String card1, String card2, char trump) {

        char suit1 = card1.charAt(utils.SUIT_INDEX);
        char suit2 = card2.charAt(utils.SUIT_INDEX);
        int value1 = cardValue(card1);
        int value2 = cardValue(card2);

        if(suit1 == suit2 && value1 > value2){
           return true;
        }
        else if(suit1 == trump) {
            return true;
        }
        else{
            return false;
        }
    }

    public static int cardValue(String card){
        switch (card.charAt(utils.FACE_INDEX)) {
            case 'A':
                return 13;
            case 'K':
                return 12;
            case 'Q':
                return 11;
            case 'J': 
                return 10;
            default:
                return Character.getNumericValue(card.charAt(utils.FACE_INDEX));
        }
    }
}