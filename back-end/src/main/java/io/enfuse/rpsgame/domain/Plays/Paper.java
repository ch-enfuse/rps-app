package io.enfuse.rpsgame.domain.Plays;

import io.enfuse.rpsgame.domain.RPSOptions;

import java.util.Arrays;

public class Paper extends Hand {
    public Paper(){
        super.beatables = Arrays.asList(
                RPSOptions.ROCK,
                RPSOptions.SPOCK
        );
    }
}
