package io.enfuse.rpsgame.domain;

public class GameResponse {
     private RPSOptions playerOption;
     private RPSOptions computerOption;
     private GameResult gameResult;

    public GameResponse(RPSOptions playerOption, RPSOptions computerOption, GameResult gameResult) {
        this.playerOption = playerOption;
        this.computerOption = computerOption;
        this.gameResult = gameResult;
    }

    public RPSOptions getPlayerOption() {
        return playerOption;
    }

    public RPSOptions getComputerOption() {
        return computerOption;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
