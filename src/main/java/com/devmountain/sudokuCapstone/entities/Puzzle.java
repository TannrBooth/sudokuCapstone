package com.devmountain.sudokuCapstone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "Puzzles")
public class Puzzle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private ArrayList<Integer> solution;

    @Column
    private ArrayList<Integer> start;

    @ManyToOne
    @JsonBackReference
    private History history;
}
