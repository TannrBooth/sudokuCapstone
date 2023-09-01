package com.devmountain.sudokuCapstone.services;

import com.devmountain.sudokuCapstone.dtos.HistoryDto;
import com.devmountain.sudokuCapstone.entities.History;
import com.devmountain.sudokuCapstone.entities.Puzzle;
import com.devmountain.sudokuCapstone.entities.User;
import com.devmountain.sudokuCapstone.repositories.HistoryRepository;
import com.devmountain.sudokuCapstone.repositories.PuzzleRepository;
import com.devmountain.sudokuCapstone.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PuzzleRepository puzzleRepository;

    @Override
    @Transactional
    public List<HistoryDto> getAllHistoryByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()) {
            List<History> historyList = historyRepository.findAllByUserEquals(userOptional.get());
            return historyList.stream().map(history -> new HistoryDto(history)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public List<HistoryDto> getAllHistoryByPuzzleId(Long puzzleId) {
        Optional<Puzzle> puzzleOptional = puzzleRepository.findById(puzzleId);
        if(puzzleOptional.isPresent()) {
            List<History> historyList = historyRepository.findAllByPuzzleEquals(puzzleOptional.get());
            return historyList.stream().map(history -> new HistoryDto(history)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void addHistory(Long userId, Long puzzleId, Boolean correct) {
        History history = new History();
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Puzzle> puzzleOptional = puzzleRepository.findById(puzzleId);

        // Needs to be an if statement that says "if check is correct check, change boolean to true", always increase check by 1
        if(correct) {
            history.setWin(true);
        } else {
            history.setWin(false);
        }

        history.setCheck_answers(1);

        userOptional.ifPresent(history::setUser);
        puzzleOptional.ifPresent(history::setPuzzle);
        historyRepository.saveAndFlush(history);
    }

}
