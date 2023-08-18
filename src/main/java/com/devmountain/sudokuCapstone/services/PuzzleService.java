package com.devmountain.sudokuCapstone.services;

import com.devmountain.sudokuCapstone.dtos.PuzzleDto;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface PuzzleService {
    @Transactional
    Optional<PuzzleDto> getPuzzleById(Long puzzleId);

    @Transactional
    void addPuzzle(PuzzleDto puzzleDto);
}
