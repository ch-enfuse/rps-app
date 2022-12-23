package io.enfuse.rpsgame.domain.Plays;

import io.enfuse.rpsgame.domain.RPSOptions;

import java.util.Arrays;

public class Spock extends Hand {
    public Spock(){
        super.beatables = Arrays.asList(
                RPSOptions.SCISSORS,
                RPSOptions.ROCK
        );
    }
}
