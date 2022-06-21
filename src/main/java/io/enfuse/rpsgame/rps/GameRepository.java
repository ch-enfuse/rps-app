package io.enfuse.rpsgame.rps;

import io.enfuse.rpsgame.domain.GameRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameRecord, Integer>{


}
