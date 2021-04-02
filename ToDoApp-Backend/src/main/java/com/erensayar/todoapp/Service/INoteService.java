package com.erensayar.todoapp.Service;

import com.erensayar.todoapp.Entity.Note;

import java.util.List;
import java.util.Optional;

/**
 * @author erensayar
 */
public interface INoteService {

    List<Note> getAll();

    Optional<Note> getNoteById(Integer id);

    Note addNote(Note note);

    void deleteNoteById(Integer id);

    void updateNote(Note updatedNote);

}
