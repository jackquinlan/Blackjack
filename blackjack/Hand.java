package blackjack;

import java.util.ArrayList;

public class Hand {
    
    private ArrayList<Card> hand;
    private int handValue;

    /*
    * Constructor
    * Each hand contains an arraylist of cards and a hand value
    * When a new hand is created, it initializes a new arraylist of cards 
    */
    public Hand() {
        this.hand = new ArrayList<Card>();  
    }

    /*
    * This function calculates the value of a hand
    * The cards TWO through TEN hold there same values
    * JACK, QUEEN, KING all equal 10
    * ACE is determined based on the current hand value (1 or 11) 
    */
    public void findHandValue() {
        // Clear the hand value
        this.handValue = 0;
        
        int numAces = 0;

        // Iterate across the entire hand
        for (int i=0; i<this.hand.size(); i++) {
            // Check for which card and increase the hand value as needed
            switch(hand.get(i).getValue()) {
                case ACE:
                    numAces++;
                    break;
                case TWO:
                    this.handValue += 2;
                    break;
                case THREE:
                    this.handValue += 3;
                    break;
                case FOUR:
                    this.handValue += 4;
                    break;
                case FIVE:
                    this.handValue += 5;
                    break;
                case SIX:
                    this.handValue += 6;
                    break;
                case SEVEN:
                    this.handValue += 7;
                    break;
                case EIGHT:
                    this.handValue += 8;
                    break;
                case NINE:
                    this.handValue += 9;
                    break;
                case TEN:
                    this.handValue += 10;
                    break;
                case JACK:
                    this.handValue += 10;
                    break;
                case QUEEN:
                    this.handValue += 10;
                    break;
                case KING:
                    this.handValue += 10;
                    break;
            }
        }

        // Check for aces and increment the hand value based on the current hand value
        for (int i=0; i<numAces; i++) {
            if (this.handValue > 10) {
                this.handValue += 1;
            } else {
                this.handValue += 11;
            }
        }
    }

    /*
    * This function clears the hand of all cards and resets the hand value for the next hand
    */
    public void clearHand() {
        this.hand.removeAll(hand);
        this.handValue = 0;
    }

    /*
    * This function adds a new card to a hand and determines the new hand value
    * @param Card c is the card being added to the hand
    */
    public void addToHand(Card c) {
        hand.add(c);
        findHandValue();
    }

    /*
    * This function prints the hand to the console
    */
    public void printHand() {
        System.out.println("[HAND]");
        // Print each card
        for (int i=0; i<hand.size(); i++) {
            System.out.println(hand.get(i).printCard());
        }
    }

    /*
    * This function returns the arraylist of cards
    */
    public ArrayList<Card> getHand() {
        return this.hand;
    }

    /*
    * This function returns the hand value
    */
    public int getHandValue() {
        return this.handValue;
    }
    
}
