package com.blackjack;
import java.util.List;
import java.util.Stack;
import java.util.Collections;
import java.util.ArrayList;

public class Deck {

    private Stack<Card> deckContents;
    private int numberOfDecks;

    public Stack<Card> getDeckContents() {
        return deckContents;
    }
    public void setDeckContents(Stack<Card> deckContents) {
        this.deckContents = deckContents;
    }
    public int getNumberOfDecks() {
        return numberOfDecks;
    }
    public void setNumberOfDecks(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
    }

    public Deck(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
        Stack<Card> deck = new Stack<>();
        String[] suits = new String[]{"hearts", "diamonds", "clubs", "spades"};
        for(int j = 0; j < numberOfDecks; j++) {
            for (String s : suits) {
                for (int i = 1; i < 14; i++) {
                    Card card = new Card();
                    card.setCardSuit(s);
                    card.setCardValue(i);
                    switch (i) {
                        case 11:
                            card.setFaceCardType("jack");
                            card.setCardValue(10);
                            card.setFaceCard(true);
                            break;
                        case 12:
                            card.setFaceCardType("queen");
                            card.setCardValue(10);
                            card.setFaceCard(true);
                            break;
                        case 13:
                            card.setFaceCardType("king");
                            card.setCardValue(10);
                            card.setFaceCard(true);
                            break;
                        default:
                            break;
                    }
                    deck.push(card);
                }
            }
        }
        this.deckContents = deck;
    }


    public static void shuffleDeck(Deck deck) {
        Stack<Card> tempDeck = deck.getDeckContents();
        Collections.shuffle(tempDeck);
        deck.setDeckContents(tempDeck);
    }

    public static void dealCards(Deck deck, PlayerList playerList) {
        for(Player p: playerList.getCurrentPlayers()) {
            Stack<Card> tempDeck = deck.getDeckContents();
            p.addToHand(tempDeck.pop());
            p.addToHand(tempDeck.pop());
            deck.setDeckContents(tempDeck);
        }
    }

    public static void reclaimCards(Deck deck, PlayerList playerList) {
        Stack<Card> tempDeck = deck.getDeckContents();
        for(Player p : playerList.getCurrentPlayers()) {
            for(Card c : p.getHand()) {
                tempDeck.push(c);
            }
            List<Card> hand = new ArrayList<>();
            p.setHand(hand);
        }
        deck.setDeckContents(tempDeck);
    }
}
