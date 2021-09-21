package com.blackjack;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PlayerList playerList = new PlayerList();
        Player player = new Player("Geoff");
        Player dealer = new Player("Dealer");
        playerList.addToPlayerList(player);
        playerList.addToPlayerList(dealer);
        Deck deck = new Deck(1);
        Deck.shuffleDeck(deck);
        Deck.dealCards(deck, playerList);
        System.out.println(dealer.getName());
        System.out.println(Player.dealerCard(dealer));
        System.out.println(player.getName());
        System.out.println(Player.displayHand(player));
        Player.updateHandTotal(player);
        do {
            int input = Integer.parseInt(takeInput("1 for Hit, 2 for Stand"));
            switch(input) {
                case 1:
                    Player.hitMe(deck, player);
                    break;
                case 2:
                    Player.standMe(player);
                    break;
                default:
                    System.out.println("Unexpected input, please enter 1 or 2");
                    break;
            }
        }
        while(!player.getBustStatus() && !player.getStandStatus());
        if(player.getBustStatus()) {
            System.out.println(dealer.getName() + " wins");
        }
        else if(player.getHandTotal() <= dealer.getHandTotal()) {
            System.out.println(dealer.getName() + " wins");
        }
        else {
            System.out.println("\nDealer's turn");
            Player.dealerRules(deck, dealer);
            if(dealer.getBustStatus())
                System.out.println(player.getName() + " wins");
            else if(player.getHandTotal() > dealer.getHandTotal())
                System.out.println(player.getName() + " wins");
            else
                System.out.println(dealer.getName() + " wins");
        }

    }


    public static String takeInput(String inputRequest) {
        System.out.println("Enter " + inputRequest + " :");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }
}
