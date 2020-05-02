package blackjack;

import java.util.ArrayList;
import util.Helper;

public class Deck {

    private ArrayList<Card> deck;

    /*  
    * Constructor
    * Each deck contains an arraylist of cards containing all 52 playing cards
    * When a new deck is created, a new arraylist of cards gets initialized
    */
    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    /*
    * This function initializes a deck of 52 cards
    * Hearts and Clubs get initialized ACE through KING
    * Diamonds and Spades get initialized KING through ACE
    * This allows for the "kissing kings"
    */
    public void initDeck() {
        // Hearts, Clubs
        for (int i=0; i<2; i++) {
            // Iterate over the values (starting at ACE)
            for (Value value: Value.values()) {
                // Add new card
                this.deck.add(new Card(value, Suit.values()[i]));
            }
        }
        // Diamonds, Spades
        for (int i=2; i<4; i++) {
            // Iterate over the values (starting at KING)
            for (int j=12; j>=0; j--) {
                // Add new card
                this.deck.add(new Card(Value.values()[j], Suit.values()[i]));
            }
        }
    }

    /*
    * This function shuffles the deck of cards
    */
    public void shuffle() {
        // Create a temporary list for new shuffled cards
        ArrayList<Card> shuffled = new ArrayList<Card>();

        // Shuffle all of the cards
        do {
            // Generate a random number
            int random = Helper.nextInt(52);
            // If the number is greater than the deck size, generate a new number.
            if (random >= getDeckSize()) {
                continue;
            } else {
                // Add the card to the shuffled deck and remove the card from original deck
                shuffled.add(this.deck.get(random));
                this.deck.remove(random);
            }
        } while (this.deck.size() != 0);

        // Add the shuffled cards back to the original deck
        for (int i=0; i<shuffled.size(); i++) {
            this.deck.add(shuffled.get(i));
        }
    }
    
    /*
    * This function deals a single card
    * @return the top card of the deck
    */
    public Card deal() {
        Card deal = this.deck.get(0);
        this.deck.remove(0);
        return deal;
    }

    /*
    * This function moves all cards from a Hand back to the deck
    */
    public void moveAllToDeck(Hand hand) {
        ArrayList<Card> handCards = hand.getHand();
        for (int i=0; i<handCards.size(); i++) {
            this.deck.add(handCards.get(i));
        }
    }

    /*
    * This function prints the deck of cards to the console
    * Used for debugging
    */
    public void printDeck() {
        int index = 1;
        for (int i=0; i<deck.size(); i++) {
            System.out.println(index + ": " + deck.get(i).printCard());
            index++;
        }
    }

    /*
    * Returns the current size of the deck
    */
    public int getDeckSize() {
        return this.deck.size();
    }

}