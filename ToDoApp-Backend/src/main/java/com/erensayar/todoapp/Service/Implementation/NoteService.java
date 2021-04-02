package com.erensayar.todoapp.Service.Implementation;

import com.erensayar.todoapp.Entity.Note;
import com.erensayar.todoapp.Repository.NoteRepo;
import com.erensayar.todoapp.Service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author erensayar
 */
@Service
public class NoteService implements INoteService {

    //<============================================>
    private NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }
    //<============================================>

    @Override
    public List<Note> getAll() {
        return noteRepo.findAll();
    }

    @Override
    public Optional<Note> getNoteById(Integer id) {
        return noteRepo.findById(id);
    }

    @Override
    public Note addNote(Note note) {
        noteRepo.save(note);
        return note; // Return For Test
    }

    @Override
    public void deleteNoteById(Integer id) {
        noteRepo.deleteById(id);
    }

    @Override
    public void updateNote(Note updatedNote) {
        Note note = noteRepo.getOne(updatedNote.getId());
        note.setNoteName(updatedNote.getNoteName());
        note.setComment(updatedNote.getComment());
        note.setTargetDate(updatedNote.getTargetDate());
        noteRepo.save(note);
    }

    public long countNote() {
        return noteRepo.count();
    }
}
