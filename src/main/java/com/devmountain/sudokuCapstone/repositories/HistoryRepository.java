package com.devmountain.sudokuCapstone.repositories;

import com.devmountain.sudokuCapstone.entities.History;
import com.devmountain.sudokuCapstone.entities.Puzzle;
import com.devmountain.sudokuCapstone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findAllByUserEquals(User user);

    List<History> findAllByPuzzleEquals(Puzzle puzzle);
}
