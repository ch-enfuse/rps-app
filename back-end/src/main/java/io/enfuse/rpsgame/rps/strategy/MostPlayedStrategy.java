package io.enfuse.rpsgame.rps.strategy;

import io.enfuse.rpsgame.domain.RPSOptions;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("MOST_PLAYED_STRATEGY")
public class MostPlayedStrategy implements ComputerStrategy {

    private RPSOptions currentPlay;
    private Map<RPSOptions,Integer> playsHistory;

    public MostPlayedStrategy(){
        playsHistory = new HashMap<RPSOptions,Integer>();
        for(RPSOptions option : RPSOptions.values()){
            playsHistory.put(option,0);
        }
    }
    @Override
    public RPSOptions getComputerPlay(RPSOptions play) {
        playsHistory.put(play, playsHistory.get(play)+1);
        Integer highestPlayedNumber = 0;
        for(Map.Entry<RPSOptions,Integer> e : playsHistory.entrySet()){
            if(e.getValue()>highestPlayedNumber){
                currentPlay = e.getKey();
                highestPlayedNumber = e.getValue();
            }
        }
        return currentPlay;
    }

    @Override
    public RPSOptions getCurrentPlay() {
        return currentPlay;
    }

    @Override
    public void resetStrategy(RPSOptions option) {
        for(Map.Entry<RPSOptions,Integer> entry: playsHistory.entrySet()){
            if (entry.getKey()==option){
                entry.setValue(1);
                currentPlay = entry.getKey();
            }
            else {
                entry.setValue(0);
            }
        }
        currentPlay = option;
    }
}
