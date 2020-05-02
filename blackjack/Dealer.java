package blackjack;

public class Dealer extends Hand {

    /*
    * This function prints the dealers hand to the console
    * The hand value and the second card is hidden
    */
    public void printHand() {
        System.out.println("[Dealer's Hand] Value -> unknown");
        System.out.println(getHand().get(0).printCard());
        System.out.println("HIDDEN");
    }

    /*
    * This function prints the dealers hand when the hand is completed
    * Shows the hand value and the second card
    */
    public void printFinalHand() {
        System.out.println("[Dealer's Hand] Value -> " + getHandValue());
        for (int i=0; i<getHand().size(); i++) {
            System.out.println(getHand().get(i).printCard());
        }
    }

}