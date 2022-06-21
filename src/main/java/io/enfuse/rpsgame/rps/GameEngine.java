package io.enfuse.rpsgame.rps;

import io.enfuse.rpsgame.domain.GameRequest;
import io.enfuse.rpsgame.domain.GameResponse;

public interface GameEngine {
    public GameResponse generateResult(GameRequest request);
}
