package com.devmountain.sudokuCapstone.services;

import com.devmountain.sudokuCapstone.dtos.HistoryDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface HistoryService {
    @Transactional
    List<HistoryDto> getAllHistoryByUserId(Long userId);

    List<HistoryDto> getAllHistoryByPuzzleId(Long puzzleId);
}
