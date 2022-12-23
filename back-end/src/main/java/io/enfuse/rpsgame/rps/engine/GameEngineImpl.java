package io.enfuse.rpsgame.rps.engine;

import io.enfuse.rpsgame.domain.GameResponse;
import io.enfuse.rpsgame.domain.GameResult;
import io.enfuse.rpsgame.domain.Plays.*;
import io.enfuse.rpsgame.domain.RPSOptions;
import org.springframework.stereotype.Component;

import java.util.Map;

import static java.util.Map.entry;
@Component
public class GameEngineImpl implements GameEngine{

    private Map<RPSOptions, Hand> handsMap;

    public GameEngineImpl(){
        handsMap = Map.ofEntries(
                entry(RPSOptions.ROCK, new Rock()),
                entry(RPSOptions.PAPER, new Paper()),
                entry(RPSOptions.SCISSORS, new Scissors()),
                entry(RPSOptions.SPOCK, new Spock()),
                entry(RPSOptions.LIZARD, new Lizard())
        );
    }
    @Override
    public GameResponse generateResult(RPSOptions playerHand, RPSOptions opponentHand) {
        if(playerHand == opponentHand){
            return new GameResponse(playerHand, opponentHand, GameResult.TIE);
        }
        if(handsMap.get(playerHand).beats(opponentHand)){
            return new GameResponse(playerHand, opponentHand, GameResult.FIRST_PLAYER_WIN);
        } else if (handsMap.get(opponentHand).beats(playerHand)) {
            return new GameResponse(playerHand, opponentHand, GameResult.FIRST_PLAYER_LOSS);
        }

        return null;
    }
}
