package blackjack;

public class Card {

    private Value value;
    private Suit suit;

    /*
    * Constructor
    * Each card contains a value and a suit
    * @param Value value is the value of the card instance (ACE through KING)
    * @param Suit suit is the suit of the card instance (HEARTS, DIAMONDS, CLUBS, SPADES)
    */
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    /*
    * This function returns the card as a string
    */
    public String printCard() {
        return this.value + " of " + this.suit;
    }

    /*
    * This function returns the value of the card instance
    */
    public Value getValue() {
        return this.value;
    }

    /*
    * This function returns the suit of the card instance
    */
    public Suit getSuit() {
        return this.suit;
    }
}