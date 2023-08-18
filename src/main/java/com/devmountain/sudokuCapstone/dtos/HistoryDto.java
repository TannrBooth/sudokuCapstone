package com.devmountain.sudokuCapstone.dtos;

import com.devmountain.sudokuCapstone.entities.History;
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

    public HistoryDto(History history) {
        if(history.getId() != null) {
            this.id = history.getId();
        }
        if(history.getWin() != null) {
            this.win = history.getWin();
        }
        if(history.getCheck_answers() != null) {
            this.checkAnswers = history.getCheck_answers();
        }
    }
}
