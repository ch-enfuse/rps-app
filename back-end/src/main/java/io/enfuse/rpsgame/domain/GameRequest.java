package io.enfuse.rpsgame.domain;


public class GameRequest {

    private String playerName;
    private RPSOptions playerOption;

    public GameRequest(){

    }

    public GameRequest(String playerName, RPSOptions playerOption) {
        this.playerName = playerName;
        this.playerOption = playerOption;
    }

    public RPSOptions getPlayerOption() {
        return playerOption;
    }

    public String getPlayerName() {
        return playerName;
    }
}
