package io.enfuse.rpsgame.domain;

import io.enfuse.rpsgame.domain.Plays.Hand;
import io.enfuse.rpsgame.domain.Plays.Lizard;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HandTest {


    @Test
    public void beats_shouldBeatHands(){
        List<RPSOptions> testBeatables = Arrays.asList(
                RPSOptions.SCISSORS,
                RPSOptions.ROCK
        );
        List<RPSOptions> beatBy = Arrays.asList(
                RPSOptions.SPOCK,
                RPSOptions.LIZARD
        );
        Hand handTest = new HandTestImpl(testBeatables);

        for(RPSOptions option : testBeatables){
            assertTrue(handTest.beats(option));
        }
        for(RPSOptions option : beatBy){
            assertFalse(handTest.beats(option));
        }
    }
    @Test
    public void testLizard(){
        Hand lizard = new Lizard();
        assertTrue(lizard.beats(RPSOptions.PAPER));
        assertTrue(lizard.beats(RPSOptions.SPOCK));
        assertFalse(lizard.beats(RPSOptions.SCISSORS));
        assertFalse(lizard.beats(RPSOptions.ROCK));
    }
}
