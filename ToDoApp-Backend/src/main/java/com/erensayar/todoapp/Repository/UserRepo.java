package com.erensayar.todoapp.Repository;

import com.erensayar.todoapp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author erensayar
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
