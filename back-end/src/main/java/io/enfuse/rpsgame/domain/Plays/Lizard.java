package io.enfuse.rpsgame.domain.Plays;

import io.enfuse.rpsgame.domain.RPSOptions;

import java.util.Arrays;

public class Lizard extends Hand {
    public Lizard(){
        super.beatables = Arrays.asList(
                RPSOptions.PAPER,
                RPSOptions.SPOCK
        );
    }
}
