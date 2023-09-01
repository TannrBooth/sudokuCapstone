package com.devmountain.sudokuCapstone.entities;

import com.devmountain.sudokuCapstone.dtos.PuzzleDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Puzzles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Puzzle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private ArrayList<Integer> solution;

    @Column
    private ArrayList<Integer> value;

    @Column
    private String difficulty;

    @OneToMany
//    @JsonManagedReference
    private Set<History> historySet = new HashSet<>();

    public Puzzle(PuzzleDto puzzleDto) {
        if (puzzleDto.getId() != null) {
            this.id = puzzleDto.getId();
        }
    }
}
