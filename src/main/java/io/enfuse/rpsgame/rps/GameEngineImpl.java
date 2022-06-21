package io.enfuse.rpsgame.rps;

import io.enfuse.rpsgame.domain.GameRequest;
import io.enfuse.rpsgame.domain.GameResponse;
import io.enfuse.rpsgame.domain.GameResult;
import io.enfuse.rpsgame.domain.RPSOptions;
import org.springframework.stereotype.Component;

@Component
public class GameEngineImpl implements GameEngine{
    @Override
    public GameResponse generateResult(GameRequest request) {
        RPSOptions playerOption = request.getPlayerOption();
        RPSOptions computerOption = RPSOptions.ROCK;
        if(playerOption.equals(computerOption)){
            return new GameResponse(playerOption, computerOption, GameResult.TIE);
        }
        else if(playerOption==RPSOptions.SCISSORS && computerOption==RPSOptions.PAPER){
            return new GameResponse(playerOption, computerOption, GameResult.FIRST_PLAYER_WIN);
        }
        else if(playerOption==RPSOptions.SCISSORS && computerOption==RPSOptions.ROCK){
            return new GameResponse(playerOption, computerOption, GameResult.FIRST_PLAYER_LOSS);
        }
        else if(playerOption==RPSOptions.ROCK && computerOption==RPSOptions.SCISSORS){
            return new GameResponse(playerOption, computerOption, GameResult.FIRST_PLAYER_WIN);
        }
        else if(playerOption==RPSOptions.ROCK && computerOption==RPSOptions.PAPER){
            return new GameResponse(playerOption, computerOption, GameResult.FIRST_PLAYER_LOSS);
        }
        else if(playerOption==RPSOptions.PAPER && computerOption==RPSOptions.ROCK){
            return new GameResponse(playerOption, computerOption, GameResult.FIRST_PLAYER_WIN);
        }
        else if(playerOption==RPSOptions.PAPER && computerOption==RPSOptions.SCISSORS){
            return new GameResponse(playerOption, computerOption, GameResult.FIRST_PLAYER_LOSS);
        }
        return null;
    }
}
