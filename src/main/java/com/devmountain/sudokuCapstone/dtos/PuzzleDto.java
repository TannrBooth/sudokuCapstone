package com.devmountain.sudokuCapstone.dtos;

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
    private ArrayList<Integer> start;
    private Set<HistoryDto> historyDtoSet;
}
