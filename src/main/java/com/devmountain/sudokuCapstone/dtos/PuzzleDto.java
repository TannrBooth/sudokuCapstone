package com.devmountain.sudokuCapstone.dtos;

import com.devmountain.sudokuCapstone.entities.Puzzle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuzzleDto implements Serializable {
    private Long id;
    private ArrayList<Integer> solution;
    private ArrayList<Integer> value;
    private String difficulty;
    private Set<HistoryDto> historyDtoSet;

    public PuzzleDto(Puzzle puzzle) {
        if(puzzle.getId() != null) {
            this.id = puzzle.getId();
        }
        if(puzzle.getValue() != null) {
            this.value = puzzle.getValue();
        }
        if(puzzle.getSolution() != null) {
            this.solution = puzzle.getSolution();
        }
        if(puzzle.getDifficulty() != null) {
            this.difficulty = puzzle.getDifficulty();
        }
    }
}
