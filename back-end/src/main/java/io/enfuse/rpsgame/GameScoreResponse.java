package io.enfuse.rpsgame;

public class GameScoreResponse {

    private int ties, firstPlayerWins, secondPlayerWins;

    public GameScoreResponse() {
        this.ties = 0;
        this.firstPlayerWins = 0;
        this.secondPlayerWins = 0;
    }

    public GameScoreResponse(int ties, int firstPlayerWins, int secondPlayerWins) {
        this.ties = ties;
        this.firstPlayerWins = firstPlayerWins;
        this.secondPlayerWins = secondPlayerWins;
    }

    public int getTies() {
        return ties;
    }

    public int getFirstPlayerWins() {
        return firstPlayerWins;
    }

    public int getSecondPlayerWins() {
        return secondPlayerWins;
    }
}
