package io.enfuse.rpsgame.rps.stratefy;

import io.enfuse.rpsgame.domain.RPSOptions;
import io.enfuse.rpsgame.rps.strategy.ComputerStrategy;
import io.enfuse.rpsgame.rps.strategy.SimpleStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SimpleStrategyTest {

    static ComputerStrategy computerStrategy;

    @BeforeAll()
    public static void setup(){
        computerStrategy = new SimpleStrategy();
    }

    @Test
    public void init_shouldSetupStrategy(){
        assertNotNull(computerStrategy);
    }
    @Test
    public void reset_shouldResetStrategy(){
        computerStrategy.resetStrategy(RPSOptions.PAPER);
        assertEquals(computerStrategy.getCurrentPlay(), RPSOptions.PAPER);
    }
    @Test
    public void paperCurrentPlay_getNext(){
        computerStrategy.resetStrategy(RPSOptions.PAPER);
        RPSOptions actual = computerStrategy.getComputerPlay(RPSOptions.ROCK);
        assertEquals(RPSOptions.SCISSORS, actual);
    }

    @Test
    public void rockCurrentPlay_getNext(){
        computerStrategy.resetStrategy(RPSOptions.ROCK);
        RPSOptions actual = computerStrategy.getComputerPlay(RPSOptions.ROCK);
        assertEquals(RPSOptions.PAPER, actual);
    }

    @Test
    public void scissorsCurrentPlay_getNext(){
        computerStrategy.resetStrategy(RPSOptions.SCISSORS);
        RPSOptions actual = computerStrategy.getComputerPlay(RPSOptions.SCISSORS);
        assertEquals(RPSOptions.SPOCK, actual);
    }

    @Test
    public void spockCurrentPlay_getNext(){
        computerStrategy.resetStrategy(RPSOptions.SPOCK);
        RPSOptions actual = computerStrategy.getComputerPlay(RPSOptions.SPOCK);
        assertEquals(RPSOptions.LIZARD, actual);
    }



}
