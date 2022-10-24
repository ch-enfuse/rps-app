package io.enfuse.rpsgame.rps.engine;

import io.enfuse.rpsgame.domain.GameRequest;
import io.enfuse.rpsgame.domain.GameResponse;
import io.enfuse.rpsgame.domain.RPSOptions;

public interface GameEngine {
    public GameResponse generateResult(RPSOptions playerHand, RPSOptions opponentHand);
}
