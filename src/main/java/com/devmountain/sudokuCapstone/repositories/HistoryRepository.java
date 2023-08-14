package com.devmountain.sudokuCapstone.repositories;

import com.devmountain.sudokuCapstone.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
}
