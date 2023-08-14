package com.devmountain.sudokuCapstone.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDto implements Serializable {
    private Long id;
    private Boolean win;
    private Integer checkAnswers;
    private String userDto;
    private String PuzzleDto;

}
