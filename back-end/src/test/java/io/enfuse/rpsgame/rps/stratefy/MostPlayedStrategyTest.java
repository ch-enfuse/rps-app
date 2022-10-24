package io.enfuse.rpsgame.rps.stratefy;

import io.enfuse.rpsgame.domain.RPSOptions;
import io.enfuse.rpsgame.rps.strategy.ComputerStrategy;
import io.enfuse.rpsgame.rps.strategy.MostPlayedStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MostPlayedStrategyTest {

    static ComputerStrategy computerStrategy;

    @BeforeAll()
    public static void setup(){
        computerStrategy = new MostPlayedStrategy();
    }

    @Test
    public void playMultiple_shouldPlayMostPlayed(){
        computerStrategy.resetStrategy(RPSOptions.PAPER);
        int numberOfPlayTimes = 5;
        for(RPSOptions play : RPSOptions.values()){
            for(int i =0; i <numberOfPlayTimes; i++){
                computerStrategy.getComputerPlay(play);
            }
            assertEquals(play, computerStrategy.getCurrentPlay());
            numberOfPlayTimes += 5;
        }
    }

    @Test
    public void reset_shouldResetStrategy(){
        for(int i = 0; i<5; i++){
            computerStrategy.getComputerPlay(RPSOptions.values()[0]);
        }
        computerStrategy.resetStrategy(RPSOptions.PAPER);
        RPSOptions actual = computerStrategy.getCurrentPlay();
        assertEquals(actual, RPSOptions.PAPER);
    }


}
