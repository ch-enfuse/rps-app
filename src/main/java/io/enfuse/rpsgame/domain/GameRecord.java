package io.enfuse.rpsgame.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GameRecord {
    @Id @GeneratedValue
    private int id;
//    private String first_player;
    private GameResult gameResult;

    public GameRecord(){

    }
    public GameRecord(GameResponse response){
        this.gameResult = response.getGameResult();
    }

    public int getId() {
        return id;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
