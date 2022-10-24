package io.enfuse.rpsgame.rps.repository;

import io.enfuse.rpsgame.domain.ScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameScoreRepository extends JpaRepository<ScoreRecord, String> {
}
