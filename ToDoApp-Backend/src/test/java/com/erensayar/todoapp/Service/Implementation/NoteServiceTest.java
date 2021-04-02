package com.erensayar.todoapp.Service.Implementation;

import com.erensayar.todoapp.Entity.Note;
import com.erensayar.todoapp.Repository.NoteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

/**
 * @author erensayar
 */
@ExtendWith(MockitoExtension.class)
class NoteServiceTest {
    // Note Service Tests Not Completed But Controller Tests Completed

    //<============================================>
    @InjectMocks
    private NoteService noteService;

    // Note Service Dependency Injection With Mockito
    @Mock
    private NoteRepo noteRepo;
    //<============================================>

    @Test
    void testAddNote() {
        // Create Test Note
        Note testNote = new Note();
        testNote.setId(1000);
        testNote.setNoteName("Test-Note");
        testNote.setComment("Test-Note-Comment");
        LocalDateTime creatingDate = LocalDateTime.of(2021, 04, 21, 15, 20);
        testNote.setCreatingDate(creatingDate);
        LocalDateTime targetDate = LocalDateTime.of(2021, 06, 30, 16, 30);
        testNote.setTargetDate(targetDate);

        Note testNoteMock = Mockito.mock(Note.class);
        Mockito.when(noteRepo.save(ArgumentMatchers.any(Note.class))).thenReturn(testNoteMock);

        Note result = noteService.addNote(testNote);

        // Check My Obj And Saved Object
        Assertions.assertEquals(result.getId(), testNote.getId());
        Assertions.assertEquals(result.getNoteName(), testNote.getNoteName());
        Assertions.assertEquals(result.getComment(), testNote.getComment());
        Assertions.assertEquals(result.getCreatingDate(), testNote.getCreatingDate());
        Assertions.assertEquals(result.getTargetDate(), testNote.getTargetDate());
    }

    /*
    @Test
    void testGetAll() {
    }

    @Test
    void testGetNoteById() {
    }

    @Test
    void testDeleteNoteById() {
    }

    @Test
    void testUpdateNote() {
    }

    @Test
    void testCountNote() {
    }
    */
}