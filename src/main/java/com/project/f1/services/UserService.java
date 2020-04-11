package com.project.f1.services;

import com.project.f1.domain.Constructor;
import com.project.f1.domain.User;
import com.project.f1.exceptions.UsernameExistsException;
import com.project.f1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public User saveUser(User user){
        try{
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setUsername(user.getUsername());

            return userRepository.save(user);
        }
        catch (Exception e){
            throw new UsernameExistsException("Username "+ user.getUsername()+" already exists");
        }

    }
    public User updateUser(User user){
            return userRepository.save(user);
            
    }
    public User findByName(String name){
        return userRepository.findByUsername(name);
    }
    public List<?> getAllByIdAndDriver(Long id){
        return userRepository.getDriverSet(id);
    }
    public Constructor getConstructorById(Long id){return  userRepository.getConstructorByUserId(id);}
}
