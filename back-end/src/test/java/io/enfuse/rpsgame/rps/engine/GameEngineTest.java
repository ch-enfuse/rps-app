package io.enfuse.rpsgame.rps.engine;

import io.enfuse.rpsgame.domain.GameResponse;
import io.enfuse.rpsgame.domain.GameResult;
import io.enfuse.rpsgame.domain.RPSOptions;
import io.enfuse.rpsgame.rps.engine.GameEngine;
import io.enfuse.rpsgame.rps.engine.GameEngineImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GameEngineTest {
    GameEngine gameEngine = new GameEngineImpl();
    @Test
    public void tiedGame(){
        GameResponse response = gameEngine.generateResult(RPSOptions.PAPER,RPSOptions.PAPER);
        assertEquals(response.getPlayerOption(),RPSOptions.PAPER);
        assertEquals(response.getGameResult(), GameResult.TIE);
    }
    @Test
    public void lossGame(){
        GameResponse response = gameEngine.generateResult(RPSOptions.PAPER,RPSOptions.SCISSORS);
        assertEquals(response.getPlayerOption(),RPSOptions.PAPER);
        assertEquals(response.getGameResult(), GameResult.FIRST_PLAYER_LOSS);
    }
    @Test
    public void winGame(){
        GameResponse response = gameEngine.generateResult(RPSOptions.PAPER,RPSOptions.ROCK);
        assertEquals(response.getPlayerOption(),RPSOptions.PAPER);
        assertEquals(response.getGameResult(), GameResult.FIRST_PLAYER_WIN);
    }

}
