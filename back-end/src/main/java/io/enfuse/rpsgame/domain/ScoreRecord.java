package io.enfuse.rpsgame.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ScoreRecord {

    @Id
    private String player;
    private int ties;
    private int firstPlayerWin;
    private int secondPlayeWin;

    public ScoreRecord() {
    }

    public ScoreRecord(String player, int ties, int firstPlayerWin, int secondPlayeWin) {
        this.player = player;
        this.ties = ties;
        this.firstPlayerWin = firstPlayerWin;
        this.secondPlayeWin = secondPlayeWin;
    }

    public String getPlayer() {
        return player;
    }

    public int getTies() {
        return ties;
    }

    public int getFirstPlayerWin() {
        return firstPlayerWin;
    }

    public int getSecondPlayeWin() {
        return secondPlayeWin;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public void setFirstPlayerWin(int firstPlayerWin) {
        this.firstPlayerWin = firstPlayerWin;
    }

    public void setSecondPlayeWin(int secondPlayeWin) {
        this.secondPlayeWin = secondPlayeWin;
    }
}
