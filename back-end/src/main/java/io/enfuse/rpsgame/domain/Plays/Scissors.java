package io.enfuse.rpsgame.domain.Plays;

import io.enfuse.rpsgame.domain.RPSOptions;

import java.util.Arrays;

public class Scissors extends Hand {
    public Scissors(){
        super.beatables = Arrays.asList(
                RPSOptions.PAPER,
                RPSOptions.LIZARD
        );
    }
}
