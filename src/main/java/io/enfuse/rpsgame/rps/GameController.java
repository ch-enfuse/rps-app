package io.enfuse.rpsgame.rps;

import io.enfuse.rpsgame.domain.GameRecord;
import io.enfuse.rpsgame.domain.GameRequest;
import io.enfuse.rpsgame.domain.GameResponse;
import io.enfuse.rpsgame.domain.RPSOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;

    @PostMapping("/play")
    public GameResponse play (@RequestBody GameRequest gameRequest){
        return gameService.play(gameRequest);
    }

    @GetMapping("/play/{id}")
    public GameResponse play (@PathVariable Integer id){
        GameRecord gameRecord = gameRepository.findById(id).get();
        return new GameResponse(RPSOptions.PAPER, RPSOptions.ROCK, gameRecord.getGameResult());
    }
}
