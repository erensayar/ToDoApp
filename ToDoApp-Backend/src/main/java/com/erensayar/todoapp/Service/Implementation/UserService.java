package com.erensayar.todoapp.Service.Implementation;

import com.erensayar.todoapp.Entity.User;
import com.erensayar.todoapp.Repository.UserRepo;
import com.erensayar.todoapp.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author erensayar
 */
@Service
public class UserService implements IUserService {

    //<============================================>
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
    //<============================================>

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> getByUsername(String name) {
        return userRepo.findByUsername(name);
    }

    @Override
    public User addUser(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return user; // Return For Test
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public void updateUser(User user) throws EmptyResultDataAccessException {
        User updatedUser = userRepo.getOne(user.getId());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(this.passwordEncoder.encode(user.getPassword()));
        updatedUser.setNote(user.getNote());
        userRepo.save(updatedUser);
    }
}
