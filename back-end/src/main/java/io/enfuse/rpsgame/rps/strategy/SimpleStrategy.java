package io.enfuse.rpsgame.rps.strategy;

import io.enfuse.rpsgame.domain.RPSOptions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("SIMPLE_STRATEGY")
public class SimpleStrategy implements ComputerStrategy {
    private  int currentPlay;
    private List<RPSOptions> plays;

    public SimpleStrategy(){
        plays = new ArrayList<>(Arrays.asList(RPSOptions.values()));
        currentPlay = plays.size();
    }

    @Override
    public RPSOptions getComputerPlay(RPSOptions play) {
        if(currentPlay+1>=plays.size()){
            currentPlay = 0;
            return plays.get(currentPlay);
        }
        else {
            return plays.get(++currentPlay);
        }
    }

    @Override
    public RPSOptions getCurrentPlay() {
        return plays.get(currentPlay);
    }
    @Override
    public void resetStrategy(RPSOptions play){
        for(RPSOptions playInstance :plays){
            if (playInstance == play){
                currentPlay=plays.indexOf(playInstance);
            }
        }
    }

}
