package com.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    @DisplayName("initDeck test")
    void initDeck() {
        Deck deck = new Deck(1);
        assertEquals(52, deck.getDeckContents().size(), "initDeck failure: expected 52, actual: "
                + deck.getDeckContents().size());
        assertNotNull(deck.getDeckContents().peek(), "initDeck failure: expected NotNull, actual: "
                + deck.getDeckContents().peek());
    }

    @Test
    @DisplayName("shuffleDeck test")
    void shuffleDeck() {
        Deck deck = new Deck(1);
        Deck deckShuffled = deck;
        Deck.shuffleDeck(deckShuffled);
        Object[] deckA = deck.getDeckContents().toArray();
        Object[] deck2A = deckShuffled.getDeckContents().toArray();
        assertNotEquals(deckA, deck2A, "shuffleDeck failure: deck not shuffled");
    }

    @Test
    @DisplayName("dealCards test")
    void dealCards() {
        Deck deck = new Deck(1);
        Player player = new Player("Geoff");
        PlayerList players = new PlayerList();
        players.addToPlayerList(player);
        Deck.dealCards(deck, players);
        for(Player p : players.getCurrentPlayers()) {
            assertEquals(2, p.getHand().size(), "dealCards failure: expected: 2, actual: "
                    + p.getHand().size());
        }
    }

    @Test
    @DisplayName("reclaimCards test")
    void reclaimCards() {
        Deck deck = new Deck(1);
        Player player = new Player("Geoff");
        PlayerList players = new PlayerList();
        players.addToPlayerList(player);
        Deck.dealCards(deck, players);
        Deck.reclaimCards(deck, players);
        for(Player p : players.getCurrentPlayers()) {
            assertEquals(0, p.getHand().size(), "reclaimCards test failure: expected 0, actual: " +
                    p.getHand().size());
        }
        assertEquals(52, deck.getDeckContents().size(),
                "reclaimCards test failure: expected 52, actual: " + deck.getDeckContents().size());
    }

    @Test
    @DisplayName("get/set numberOfDecks test")
    void SetGetNumberOfDecks() {
        Deck deck = new Deck(1);
        deck.setNumberOfDecks(2);
        assertEquals(2, deck.getNumberOfDecks(), "get/set numberOfDecks failure");
    }
}
