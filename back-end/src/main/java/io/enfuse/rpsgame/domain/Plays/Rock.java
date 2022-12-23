package io.enfuse.rpsgame.domain.Plays;

import io.enfuse.rpsgame.domain.RPSOptions;

import java.util.Arrays;

public class Rock extends Hand {
    public Rock(){
        beatables = Arrays.asList(
                RPSOptions.SCISSORS,
                RPSOptions.LIZARD
        );
    }
}
