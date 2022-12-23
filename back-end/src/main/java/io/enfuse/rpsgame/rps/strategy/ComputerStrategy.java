package io.enfuse.rpsgame.rps.strategy;

import io.enfuse.rpsgame.domain.RPSOptions;

public interface ComputerStrategy {
    public RPSOptions getComputerPlay(RPSOptions play);

    public RPSOptions getCurrentPlay();

    public void resetStrategy(RPSOptions option);
}
