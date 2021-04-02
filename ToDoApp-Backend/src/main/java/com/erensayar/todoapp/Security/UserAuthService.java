package com.erensayar.todoapp.Security;

import com.erensayar.todoapp.Entity.User;
import com.erensayar.todoapp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author erensayar
 */
@Service
public class UserAuthService implements UserDetailsService {

    //<============================================>
    UserRepo userRepo;

    @Autowired
    public UserAuthService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    //<============================================>


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInDB = userRepo.findByUsername(username).get();
        if(userInDB == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return userInDB;
    }

}