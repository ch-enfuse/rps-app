package io.enfuse.rpsgame.rps;

import io.enfuse.rpsgame.domain.GameRecord;
import io.enfuse.rpsgame.domain.GameRequest;
import io.enfuse.rpsgame.domain.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private GameEngine gameEngine;

    @Autowired
    private GameRepository gameRepository;
    public GameService() {
    }

    public GameResponse play(GameRequest request) {
        GameResponse gameResponse = gameEngine.generateResult(request);
        gameRepository.save(new GameRecord(gameResponse));
        return gameResponse;
    }
}
