package blackjack;

public class Player extends Hand {

    /*
    * This function prints the players hand to the console
    * Unlike the dealers hand, the hand value and all cards are shown
    */
    public void printHand() {
        System.out.println("[Your Hand] Value -> " + getHandValue());
        for (int i=0; i<getHand().size(); i++) {
            System.out.println(getHand().get(i).printCard());
        }
    }

}