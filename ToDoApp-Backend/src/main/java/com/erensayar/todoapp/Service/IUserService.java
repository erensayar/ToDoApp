package com.erensayar.todoapp.Service;

import com.erensayar.todoapp.Entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author erensayar
 */
public interface IUserService {

    List<User> getAll();

    Optional<User> getUserById(Integer id);

    Optional<User> getByUsername(String username);

    User addUser(User user);

    void deleteUserById(Integer id);

    void updateUser(User updatedUser);

}
