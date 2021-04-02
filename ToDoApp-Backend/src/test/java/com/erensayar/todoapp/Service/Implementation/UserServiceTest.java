package com.erensayar.todoapp.Service.Implementation;

import com.erensayar.todoapp.Entity.Note;
import com.erensayar.todoapp.Entity.User;
import com.erensayar.todoapp.Repository.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author erensayar
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    // User Service Tests Not Completed But Controller Tests Completed

    //<============================================>
    @InjectMocks
    private UserService userService;

    // User Service Dependencies Injection With Mockito
    @Mock
    private UserRepo userRepo;

    @Mock
    private PasswordEncoder passwordEncoder;
    //<============================================>

    @Test
    void testAddUser() {
        // Create Test Note For Note List
        Note testNote1 = new Note();
        testNote1.setId(1000);
        testNote1.setNoteName("Test-Note");
        testNote1.setComment("Test-Note-Comment");
        LocalDateTime creatingDate = LocalDateTime.of(2021, 04, 21, 15, 20);
        testNote1.setCreatingDate(creatingDate);
        LocalDateTime targetDate = LocalDateTime.of(2021, 06, 30, 16, 30);
        testNote1.setTargetDate(targetDate);

        // Create Test Note List For User Notes
        List<Note> testNoteList = new ArrayList<>();
        testNoteList.add(testNote1);

        // Create Test User
        User testUser = new User();
        testUser.setId(100);
        testUser.setUsername("Test-Name");
        testUser.setPassword("TestP4ssword");
        testUser.setNote(testNoteList);

        User testUserMock = Mockito.mock(User.class);
        Mockito.when(userRepo.save(ArgumentMatchers.any(User.class))).thenReturn(testUserMock);

        User result = userService.addUser(testUser);

        // Check My Obj And Saved Object
        Assertions.assertEquals(result.getId(), testUser.getId());
        Assertions.assertEquals(result.getUsername(), testUser.getUsername());
        Assertions.assertEquals(result.getPassword(), testUser.getPassword());
        Assertions.assertEquals(result.getNote(), testUser.getNote());
    }


    /*
    @Test
    void testGetAll() {
    }

    @Test
    void testGetUserById() {
    }

    @Test
    void testGetByUsername() {
    }

    @Test
    void testDeleteUserById() {
    }

    @Test
    void testUpdateUser() {
    }
    */
}