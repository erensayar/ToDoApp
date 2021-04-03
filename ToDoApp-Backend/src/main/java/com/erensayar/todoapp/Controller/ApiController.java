package com.erensayar.todoapp.Controller;

import com.erensayar.todoapp.Entity.Note;
import com.erensayar.todoapp.Entity.User;
import com.erensayar.todoapp.Service.INoteService;
import com.erensayar.todoapp.Service.IUserService;
import com.erensayar.todoapp.ViewModel.Views;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author erensayar
 */
@RestController
@RequestMapping("/api")
@Api(value = "ToDo App Rest API Documentation")
public class ApiController {

    //<============================================>
    private IUserService userService;
    private INoteService noteService;

    @Autowired
    public ApiController(IUserService userService, INoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    // GET ALL
    //<============================================>
    @GetMapping(value = "/getAllUser")
    @JsonView(Views.Base.class)
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @GetMapping(value = "/getAllNote")
    public List<Note> getAllNote() {
        return noteService.getAll();
    }

    @GetMapping(value = "/getAllNoteJustNoteNameAndId")
    @JsonView(Views.NoteBase.class)
    public List<Note> getAllNoteJustNoteNameAndId() {
        return noteService.getAll();
    }

    // GET BY ID
    //<============================================>
    @GetMapping(value = "/getUser/{id}")
    @JsonView(Views.Note.class)
    public Optional<User> getUserById(@PathVariable("id") Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping(value = "/getNote/{id}")
    public Optional<Note> getNoteById(@PathVariable("id") Integer noteId) {
        return noteService.getNoteById(noteId);
    }

    // ADD
    //<============================================>
    @PostMapping(value = "/addUser")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("USER CREATED");
    }

    @PostMapping(value = "/addNote")
    public ResponseEntity<?> addNote(@RequestBody Note note) {
        noteService.addNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body("NOTE CREATED");
    }

    // UPDATE BY ID
    //<============================================>
    @PutMapping(value = "/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("USER UPDATED");
    }

    @PutMapping(value = "/updateNote")
    public ResponseEntity<?> updateNote(@RequestBody Note note) {
        noteService.updateNote(note);
        return ResponseEntity.status(HttpStatus.OK).body("NOTE UPDATED");
    }

    // DELETE BY ID
    //<============================================>
    @DeleteMapping(value = "/deleteUser/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body("USER DELETED");
    }

    @DeleteMapping(value = "/deleteNote/{id}")
    public ResponseEntity<?> deleteNoteById(@PathVariable("id") Integer userId) {
        noteService.deleteNoteById(userId);
        return ResponseEntity.status(HttpStatus.OK).body("NOTE DELETED");
    }

}
