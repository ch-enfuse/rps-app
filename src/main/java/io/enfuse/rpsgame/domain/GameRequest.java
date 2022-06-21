package io.enfuse.rpsgame.domain;


import io.enfuse.rpsgame.rps.GameRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;


public class GameRequest {
    private RPSOptions playerOption;

    public GameRequest(){

    }
    public GameRequest(RPSOptions option){
        this.playerOption = option;
    }

    public RPSOptions getPlayerOption() {
        return playerOption;
    }
}
