package com.erensayar.todoapp.Component;

import com.erensayar.todoapp.Entity.Note;
import com.erensayar.todoapp.Entity.User;
import com.erensayar.todoapp.Service.Implementation.NoteService;
import com.erensayar.todoapp.Service.Implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author erensayar
 */
@Component
public class CmdLineRunner implements CommandLineRunner {

    //<============================================>
    private UserService userService;
    private NoteService noteService;
    @Autowired
    public CmdLineRunner(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }
    //<============================================>

    @Override
    public void run(String... args) throws Exception {

        // Users created on DB, when application starting
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setUsername("user" + i);
            user.setPassword("P4ssword");
            userService.addUser(user);
        }

        // User Created on DB, when application starting
        User user1 = new User();
        user1.setUsername("eren");
        user1.setPassword("P4ssword");
        userService.addUser(user1);

        // Random NotesName
        List<String> noteNames = new ArrayList<>();
        noteNames.add("Shopping Date");
        noteNames.add("Invoice Date");
        noteNames.add("Spring Boot To Do List");
        noteNames.add("React To Do List");
        noteNames.add("My Meetup Date");
        noteNames.add("Sport To Do List");
        noteNames.add("Home To Do Works");
        noteNames.add("Homeworks");
        noteNames.add("Exams");
        noteNames.add("To Do List 1");
        noteNames.add("To Do List 4");
        noteNames.add("My Dates For Business");
        noteNames.add("My Dates For Hospitals");
        noteNames.add("Shopping Date");
        noteNames.add("Invoice Date");
        noteNames.add("Spring Boot To Do List");
        noteNames.add("React To Do List");
        noteNames.add("My Meetup Date");
        noteNames.add("Sport To Do List");
        noteNames.add("Home To Do Works");
        noteNames.add("Homeworks");
        noteNames.add("Exams");
        noteNames.add("To Do List 1");
        noteNames.add("To Do List 4");
        noteNames.add("My Dates For Business");
        noteNames.add("My Dates For Hospitals");

        // Notes created on DB, when application starting
        for (int i = 1; i <= 25; i++) {
            Note note = new Note();
            note.setNoteName(noteNames.get(i));
            note.setComment("Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, tempore in excepturi inventore reprehenderit mollitia modi nesciunt voluptatem saepe harum voluptatibus repudiandae illum recusandae ab nobis minus molestias accusantium? Atque vel quod veniam esse sed rem! Dicta minima laudantium nisi similique inventore culpa mollitia ad, eligendi quis repellendus reprehenderit incidunt totam, assumenda, est labore. Amet, cum! Consequatur dolorum porro culpa! Dolorum ut rem totam reprehenderit dolore tempore, quia itaque delectus quos voluptates id eaque iusto aliquam quaerat ea corporis. Numquam saepe optio dolore iure, dicta, fugiat, esse fuga minima repellendus tempora aperiam assumenda. Cum asperiores architecto rem aperiam odio officiis?");
            LocalDateTime targetDate = LocalDateTime.of(2021, 04, 21, 15, 20);
            note.setTargetDate(targetDate);
            noteService.addNote(note);
        }

    }
}
