package com.devmountain.sudokuCapstone.controllers;

import com.devmountain.sudokuCapstone.dtos.HistoryDto;
import com.devmountain.sudokuCapstone.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping("/user/{userId}")
    public List<HistoryDto> GetAllHistoryByUser(@PathVariable Long userId) {
        System.out.println("Command worked");
        return historyService.getAllHistoryByUserId(userId);
    }

    @GetMapping("/puzzle/{puzzleId}")
    public List<HistoryDto> GetAllHistoryByPuzzle(@PathVariable Long puzzleId) {
        return historyService.getAllHistoryByPuzzleId(puzzleId);
    }

    @PostMapping("/user/{userId}/puzzle/{puzzleId}/correct/{correct}")
    public void PostHistoryByUserAndPuzzle(@PathVariable Long userId, @PathVariable Long puzzleId, @PathVariable Boolean correct) {
        historyService.addHistory(userId, puzzleId, correct);
    }

}
