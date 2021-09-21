package com.blackjack;
import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    private List<Player> currentPlayers = new ArrayList<>();

    public List<Player> getCurrentPlayers() {
        return currentPlayers;
    }
    public void setCurrentPlayers(List<Player> currentPlayers) {
        this.currentPlayers = currentPlayers;
    }
    public void addToPlayerList(Player player) {
        currentPlayers.add(player);
    }
}
