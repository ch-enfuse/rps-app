package io.enfuse.rpsgame.rps.service;

import io.enfuse.rpsgame.GameScoreResponse;
import io.enfuse.rpsgame.domain.*;
import io.enfuse.rpsgame.rps.engine.GameEngine;
import io.enfuse.rpsgame.rps.repository.GameRepository;
import io.enfuse.rpsgame.rps.repository.GameScoreRepository;
import io.enfuse.rpsgame.rps.strategy.ComputerStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameEngine gameEngine;
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameScoreRepository gameScoreRepository;
    @Autowired
    @Qualifier("MOST_PLAYED_STRATEGY")
    ComputerStrategy computerStrategy;
    public GameService() {
    }

    public GameResponse play(GameRequest request) {
        RPSOptions playerPlay = request.getPlayerOption();

        RPSOptions computerPlay = computerStrategy.getComputerPlay(playerPlay);
        GameResponse gameResponse = gameEngine.generateResult(playerPlay, computerPlay);

        saveScores(request.getPlayerName(), gameResponse.getGameResult());
        gameRepository.save(new GameRecord(gameResponse));

        return gameResponse;
    }

    private void saveScores(String playerName, GameResult result){
        ScoreRecord gameScore = gameScoreRepository.findById(playerName).orElse(null);
        if(gameScore!=null) {
            if (result == GameResult.TIE) {
                gameScore.setTies(gameScore.getTies() + 1);
            } else if (result == GameResult.FIRST_PLAYER_LOSS) {
                gameScore.setSecondPlayeWin(gameScore.getSecondPlayeWin() + 1);
            } else {
                gameScore.setFirstPlayerWin(gameScore.getFirstPlayerWin() + 1);
            }
        }else{
            if (result == GameResult.TIE) {
                gameScoreRepository.save(new ScoreRecord(playerName,1,0,0));
            } else if (result == GameResult.FIRST_PLAYER_LOSS) {
                gameScoreRepository.save(new ScoreRecord(playerName,0,0,1));
            } else {
                gameScoreRepository.save(new ScoreRecord(playerName, 0, 1, 0));
            }
        }
    }

    public GameScoreResponse getScore(String player){
        ScoreRecord scoreRecord = gameScoreRepository.findById(player).orElse(null);
        if (scoreRecord != null){
            return new GameScoreResponse(scoreRecord.getTies(),
                                scoreRecord.getFirstPlayerWin(),
                                scoreRecord.getSecondPlayeWin());
        }
        else
            return new GameScoreResponse();
    }

}
