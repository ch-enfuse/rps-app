package io.enfuse.rpsgame.rps;

import io.enfuse.rpsgame.domain.GameRequest;
import io.enfuse.rpsgame.domain.GameResponse;
import io.enfuse.rpsgame.domain.GameResult;
import io.enfuse.rpsgame.domain.RPSOptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GameEngineTest {


    GameEngine gameEngine = new GameEngineImpl();



    @Test
    public void tiedGame(){
        GameRequest request = new GameRequest(RPSOptions.ROCK);
        GameResponse response = gameEngine.generateResult(request);
        assertEquals(response.getPlayerOption(),RPSOptions.ROCK);
        assertEquals(response.getGameResult(), GameResult.TIE);
    }
    @Test
    public void lossGame(){
        GameRequest request = new GameRequest(RPSOptions.SCISSORS);
        GameResponse response = gameEngine.generateResult(request);
        assertEquals(response.getPlayerOption(),RPSOptions.SCISSORS);
        assertEquals(response.getGameResult(), GameResult.FIRST_PLAYER_LOSS);
    }
    @Test
    public void winGame(){
        GameRequest request = new GameRequest(RPSOptions.PAPER);
        GameResponse response = gameEngine.generateResult(request);
        assertEquals(response.getPlayerOption(),RPSOptions.PAPER);
        assertEquals(response.getGameResult(), GameResult.FIRST_PLAYER_WIN);
    }
}
