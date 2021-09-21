package com.blackjack;

public class Card {

    private int cardValue;
    private String cardSuit;
    private boolean faceCard;
    private String faceCardType;

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public String getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(String cardSuit) {
        this.cardSuit = cardSuit;
    }

    public boolean isFaceCard() {
        return faceCard;
    }

    public void setFaceCard(boolean faceCard) {
        this.faceCard = faceCard;
    }

    public String getFaceCardType() {
        return faceCardType;
    }

    public void setFaceCardType(String faceCardType) {
        this.faceCardType = faceCardType;
    }
}
