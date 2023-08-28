package com.devmountain.sudokuCapstone.controllers;

import com.devmountain.sudokuCapstone.dtos.PuzzleDto;
import com.devmountain.sudokuCapstone.services.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/puzzles")
public class PuzzleController {
    @Autowired
    private PuzzleService puzzleService;

    @GetMapping("/puzzle/{puzzleId}")
    public Optional<PuzzleDto> getPuzzleById(@PathVariable Long puzzleId) {
        return puzzleService.getPuzzleById(puzzleId);
    }


    @PostMapping("/add")
    public void addPuzzle(@RequestBody PuzzleDto puzzleDto) {
        puzzleService.addPuzzle(puzzleDto);
    }

}
