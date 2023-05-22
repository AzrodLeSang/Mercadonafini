package com.example.mercadonafini.Service;

import com.example.mercadonafini.model.UserModel;
import com.example.mercadonafini.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    public UserModel authenticate(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }
}
