package com.erensayar.todoapp.Repository;

import com.erensayar.todoapp.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author erensayar
 */
@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {

}
