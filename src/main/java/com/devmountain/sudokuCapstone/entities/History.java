package com.devmountain.sudokuCapstone.entities;

import com.devmountain.sudokuCapstone.dtos.HistoryDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="History")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Boolean win;

    @Column
    private Integer check_answers;

    @ManyToOne
    @JsonBackReference
    private User user;

    @ManyToOne
    @JsonBackReference
    private Puzzle puzzle;

    public History(HistoryDto historyDto) {
        if(historyDto.getId() != null) {
            this.id = historyDto.getId();
        }
    }

}
