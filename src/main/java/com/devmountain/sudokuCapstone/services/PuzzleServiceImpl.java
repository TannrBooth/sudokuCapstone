package com.devmountain.sudokuCapstone.services;

import com.devmountain.sudokuCapstone.dtos.PuzzleDto;
import com.devmountain.sudokuCapstone.entities.Puzzle;
import com.devmountain.sudokuCapstone.repositories.HistoryRepository;
import com.devmountain.sudokuCapstone.repositories.PuzzleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PuzzleServiceImpl implements PuzzleService {

    @Autowired
    private PuzzleRepository puzzleRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    @Transactional
    public Optional<PuzzleDto> getPuzzleById(Long puzzleId) {
        Optional<Puzzle> puzzleOptional = puzzleRepository.findById(puzzleId);
        if (puzzleOptional.isPresent()) {
            return Optional.of(new PuzzleDto(puzzleOptional.get()));
        }
        return Optional.empty();

    }

    @Override
    @Transactional
    public void addPuzzle(PuzzleDto puzzleDto) {
        Puzzle puzzle = new Puzzle(puzzleDto);
        puzzleRepository.saveAndFlush(puzzle);
    }

}
