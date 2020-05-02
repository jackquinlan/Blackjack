package blackjack;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        // Create and shuffle the deck
        Deck cards = new Deck();
        cards.initDeck();
        cards.shuffle();

        
        // Create a dealer and a player
        Dealer dealer = new Dealer();
        Player player = new Player();

        // Players wallet
        double wallet = 500.00;

        // Input scanner
        Scanner input = new Scanner(System.in);

        // Main game loop
        while(wallet > 0) {
            // Ask player for bet
            System.out.println("You currently have $" + wallet + " in your wallet.");
            System.out.print("How much would you like to bet? ");
            double playerBet = input.nextDouble();
            // If they try to bet more than they have, end game.
            if (playerBet > wallet) {
                System.out.println("You cannot bet more than you have.");
                break;
            }

            // Deal dealer 
            dealer.addToHand(cards.deal());
            dealer.addToHand(cards.deal());

            // Deal player
            player.addToHand(cards.deal());
            player.addToHand(cards.deal());

            // Find the hand value
            player.findHandValue();
            dealer.findHandValue();
            
            // Handle player turn
            while(true) {
                // Print hands
                dealer.printHand();
                player.printHand();
                // Get user input
                System.out.print("What would you like to do? (0 stand, 1 hit) ");
                int playerResponse = input.nextInt();
                // Stand
                if (playerResponse == 0 || player.getHandValue() > 21) {
                    break;
                } 
                // Hit
                else if (playerResponse == 1) {
                    // Deal a card
                    player.addToHand(cards.deal());
                    // If the hand value is greater than 21, break out of loop
                    if (player.getHandValue() > 21) {
                        break;
                    }
                } 
                // Invalid input
                else {
                    System.out.println("[ERROR] Invalid input.");
                }
            }

            // Handle dealer turn
            while(true) {
                // If dealers hand is less than 17, hit
                if (dealer.getHandValue() < 17) {
                    dealer.addToHand(cards.deal());
                } else break; // Stand
            }

            // Print final hands
            dealer.printFinalHand();
            player.printHand();

            // Check for winner
            // If dealer hand value is greater than the player hand
            // And if the dealer's hand is less than or equal to 21, the dealer wins
            if (dealer.getHandValue() > player.getHandValue() && dealer.getHandValue() <= 21) { 
                System.out.println("Dealer Wins! You lost: $" + playerBet);
                // Subtract money from the players wallet
                wallet -= playerBet;
            } 
            // If the player hand value is greater than the dealer hand
            // And if the player's hand is less than or equal to 21, the player wins
            else if (player.getHandValue() > dealer.getHandValue() && player.getHandValue() <= 21) { 
                System.out.println("You Win! You won: $" + playerBet);
                // Add money to the players wallet
                wallet += playerBet;
            } 
            // If the dealer's hand is greater than 21
            // And if the player's hand is less than or equal to 21, the player wins
            else if (dealer.getHandValue() > 21 && player.getHandValue() <= 21) {
                System.out.println("You Win! You won: $" + playerBet);
                // Add money to the players wallet
                wallet += playerBet;
            }
            // If the players hand is greater than 21
            // And if the dealer's hand is less than or equal to 21, the dealer wins 
            else if (player.getHandValue() > 21 && dealer.getHandValue() <= 21) {
                System.out.println("Dealer Wins! You lost: $" + playerBet);
                // Subtract money from the players wallet
                wallet -= playerBet;
            }
            // If both the dealers and the players hand are greater thean 21, no one wins 
            else if (player.getHandValue() > 21 && dealer.getHandValue() > 21) {
                System.out.println("Push");
            } 
            // No one wins
            else {
                System.out.println("Push");
            }

            // Move hands back to the deck
            cards.moveAllToDeck(player);
            cards.moveAllToDeck(dealer);
            // Clear the hands
            player.clearHand();
            dealer.clearHand();

            // Reshuffle
            cards.shuffle();
        }

        System.out.println("[GAME OVER] You lost all of your money!");
        input.close();
        
    }
}