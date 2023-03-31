package com.myproject.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.backend.model.TaskNote;

@Repository
public interface TaskNoteRepository extends JpaRepository<TaskNote, Long>{

}
