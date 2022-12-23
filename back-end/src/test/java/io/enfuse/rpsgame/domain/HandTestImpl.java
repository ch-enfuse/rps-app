package io.enfuse.rpsgame.domain;

import io.enfuse.rpsgame.domain.Plays.Hand;

import java.util.List;

public class HandTestImpl extends Hand {

    public int calls;
    public HandTestImpl(List<RPSOptions> beatables){
        super.beatables = beatables;
        calls = 0;

    }

    @Override
    public boolean beats(RPSOptions option){
        calls++;
        return super.beats(option);
    }

}
