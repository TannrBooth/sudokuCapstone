package com.devmountain.sudokuCapstone.repositories;


import com.devmountain.sudokuCapstone.entities.Puzzle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuzzleRepository extends JpaRepository<Puzzle, Long> {
}
