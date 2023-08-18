package com.devmountain.sudokuCapstone.controllers;

import com.devmountain.sudokuCapstone.dtos.PuzzleDto;
import com.devmountain.sudokuCapstone.services.PuzzleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/puzzles")
public class PuzzleController {
    private PuzzleService puzzleService;

    @GetMapping("/puzzle/{userId}")
    public Optional<PuzzleDto> getPuzzleById(@PathVariable Long puzzleId) {
        return puzzleService.getPuzzleById(puzzleId);
    }



}
