package com.blackjack;
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class Player {

    private List<Card> hand = new ArrayList<>();
    private boolean standStatus = false;
    private int handTotal = 0;
    private boolean bustStatus = false;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public boolean getStandStatus() {
        return standStatus;
    }

    public void setStandStatus(boolean standStatus) {
        this.standStatus = standStatus;
    }

    public int getHandTotal() {
        return handTotal;
    }

    public void setHandTotal(int handTotal) {
        this.handTotal = handTotal;
    }

    public boolean getBustStatus() {
        return bustStatus;
    }

    public void setBustStatus(boolean bustStatus) {
        this.bustStatus = bustStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void hitMe(Deck deck, Player player) {
        System.out.println("||||||||||HIT ME!||||||||||");
        Stack<Card> tempDeck = deck.getDeckContents();
        player.addToHand(tempDeck.pop());
        deck.setDeckContents(tempDeck);
        System.out.println(displayHand(player));
        updateHandTotal(player);

    }

    public static void standMe(Player player) {
        player.setStandStatus(true);
        System.out.println("||||||||||STAND||||||||||");
    }

    public static void updateHandTotal(Player player) {
        int tempHandTotal = 0;
        for (Card c : player.getHand()) {
            int value = c.getCardValue();
            tempHandTotal += value;
        }
        player.setHandTotal(tempHandTotal);
        if (player.getHandTotal() > 21) {
            player.setBustStatus(true);
            System.out.println("||||||||||BUST||||||||||");
        }
    }

    public static void dealerRules(Deck deck, Player player) {
        Player.updateHandTotal(player);
        while (player.getHandTotal() < 17 && !player.getBustStatus()) {
            hitMe(deck, player);
        }
        if(!player.getBustStatus())
            standMe(player);
    }

    public static boolean blackjackCheck(Player player) {
        Card card1 = player.getHand().get(0);
        Card card2 = player.getHand().get(1);
        return (card1.isFaceCard() && card2.getCardValue() == 1) || (card2.isFaceCard() && card1.getCardValue() == 1);
    }

    public static String displayHand(Player player) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Card c : player.getHand()) {
            String suit;
            switch (c.getCardSuit()) {
                case "hearts":
                    suit = "♥";
                    break;
                case "diamonds":
                    suit = "♦";
                    break;
                case "clubs":
                    suit = "♣";
                    break;
                case "spades":
                    suit = "♠";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + c.getCardSuit());
            }
            if (c.isFaceCard()) {
                stringBuilder.append("[").append(c.getFaceCardType()).append(suit).append("] ");
            } else {
                stringBuilder.append("[").append(c.getCardValue()).append(suit).append("] ");
            }
        }
        return stringBuilder.toString();
    }

    public static String dealerCard(Player player) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Card> playerHand = player.getHand();
        Card card = playerHand.get(0);
        String suit;
        switch (card.getCardSuit()) {
            case "hearts":
                suit = "♥";
                break;
            case "diamonds":
                suit = "♦";
                break;
            case "clubs":
                suit = "♣";
                break;
            case "spades":
                suit = "♠";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + card.getCardSuit());
        }
        if (card.isFaceCard()) {
            stringBuilder.append("[").append(card.getFaceCardType()).append(suit).append("] ");
        } else {
            stringBuilder.append("[").append(card.getCardValue()).append(suit).append("] ");
        }
        return stringBuilder.toString();
    }
}