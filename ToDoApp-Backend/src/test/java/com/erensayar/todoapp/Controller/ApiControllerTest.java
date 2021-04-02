package com.erensayar.todoapp.Controller;

import com.erensayar.todoapp.Service.Implementation.NoteService;
import com.erensayar.todoapp.Service.Implementation.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author erensayar
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ApiController.class)
class ApiControllerTest {
/*
    // Dependencies
    //<============================================>
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @MockBean
    private NoteService noteService;
*/

//  // testGetAllUser
//  //<============================================>
//  @Test
//  void whenGetAllUser_thenReturns200() throws Exception {
//      // given
//      User user = (User) User.builder().username("Test-name").build();
//      List<User> userList = new ArrayList<>();
//      userList.add(user);
//      Mockito.when(userService.getAll()).thenReturn(); // TODO: !

//      // when


//      // then
//  }

//  @Test
//  void whenGetAllUser_thenReturns404() throws Exception {
//      // given
//      // when
//      // then
//  }

    /*
    //<============================================>
    @Test
    void testGetAllNote() {
    }

    //<============================================>
    @Test
    void testGetNoteById() {
    }

    //<============================================>
    @Test
    void whenCall() {
    }

    //<============================================>
    @Test
    void testAddUser() {
    }

    //<============================================>
    @Test
    void testAddNote() {
    }

    //<============================================>
    @Test
    void testUpdateUser() {
    }

    //<============================================>
    @Test
    void testUpdateNote() {
    }

    //<============================================>
    @Test
    void testDeleteUserById() {
    }

    //<============================================>
    @Test
    void testDeleteNoteById() {
    }
    //<============================================>


    @Test
    void testGetUserByUsername() {
    }
     */
}