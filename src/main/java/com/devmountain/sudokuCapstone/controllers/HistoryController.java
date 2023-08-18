package com.devmountain.sudokuCapstone.controllers;

import com.devmountain.sudokuCapstone.dtos.HistoryDto;
import com.devmountain.sudokuCapstone.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping("/history/{userId}")
    public List<HistoryDto> GetAllHistoryByUser(@PathVariable Long userId) {
        return historyService.getAllHistoryByUserId(userId);
    }

    @GetMapping("/history/{puzzleId}")
    public List<HistoryDto> GetAllHistoryByPuzzle(@PathVariable Long puzzleId) {
        return historyService.getAllHistoryByPuzzleId(puzzleId);
    }

}
