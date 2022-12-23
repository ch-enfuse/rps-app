package io.enfuse.rpsgame.rps.service;

import io.enfuse.rpsgame.GameScoreResponse;
import io.enfuse.rpsgame.domain.GameResponse;
import io.enfuse.rpsgame.domain.ScoreRecord;
import io.enfuse.rpsgame.rps.repository.GameScoreRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GameServiceTest {
    @Mock
    GameScoreRepository gameScoreRepository;

    static GameService gameService;

    @BeforeAll
    public static void setup(){
        gameService = new GameService();
    }

//    @Test
//    public void getScore_shoudlGetScore(){
//        String testPlayer = "testPlayer";
//        ScoreRecord scoreRecord = new ScoreRecord(testPlayer, 0,0,0);
//        when(gameScoreRepository.findById(testPlayer)).thenReturn(Optional.of(scoreRecord));
//        GameScoreResponse actual = gameService.getScore(testPlayer);
//        assertThat(actual.getFirstPlayerWins()).isEqualTo(0);
//        assertThat(actual.getTies()).isEqualTo(0);
//        assertThat(actual.getSecondPlayerWins()).isEqualTo(0);
//
//    }
}
