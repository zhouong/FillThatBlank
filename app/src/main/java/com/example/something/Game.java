package com.example.something;

import java.util.ArrayList;
import java.util.List;


public class Game {
    //number of rounds
    private static int rounds = 0;

    //list of players
    private static List<Player> players = new ArrayList<>();

    //setter and getter for rounds
    public void setRounds(int setRounds) {
        rounds = setRounds;
    }

    public int getRounds() {
        return rounds;
    }

    public static List<Player> getPlayers() {
        return players;
    }

    //check if rounds and players are used
    public void proceed() {
        if (rounds < 1 || players.size() == 0) {
            //pop up error
            return;
        }
    }

    public static void setPlayers(List<Player> players) {
        Game.players = players;
    }

    public Player getWinner() {
        Player winner = new Player();
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPoints() > winner.getPoints()) {
                winner = players.get(i);
            }
        }

        return winner;
    }
}
