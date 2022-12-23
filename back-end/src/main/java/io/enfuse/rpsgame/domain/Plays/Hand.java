package io.enfuse.rpsgame.domain.Plays;

import io.enfuse.rpsgame.domain.RPSOptions;

import java.util.List;

public abstract class Hand {
    protected List<RPSOptions> beatables;

    public boolean beats(RPSOptions play) {
        return beatables.contains(play);
    }

}
