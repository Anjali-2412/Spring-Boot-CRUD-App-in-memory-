package com.example.demo.service;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<Integer, User> userMap = new HashMap<>();

    public User createUser(User user){
        if(userMap.containsKey(user.getId())){
            throw new UserAlreadyExistsException("User with ID "+user.getId()+ " already exists");
        }
        validateUserFeilds(user);
        userMap.put(user.getId(),user);
        return user;

    }

    public User getUser(int id){
        if(!userMap.containsKey(id)){
            throw new UserNotFoundException("User with ID "+id+" not found.");

        }
        return userMap.get(id);
    }

    public User updateUser(int id,User user){
        if(!userMap.containsKey(id)){
            throw new UserNotFoundException("User with ID "+id+" not found.");
        }
        validateUserFeilds(user);
        user.setId(id);
        userMap.put(id,user);
        return user;
    }

    public void deleteUser(int id){
        if(!userMap.containsKey(id)){
            throw new UserNotFoundException("User with ID "+id+" not found.");
        }
        userMap.remove(id);
    }

    private void validateUserFeilds(User user){
        if(user.getName() == null || user.getName().isEmpty()){
            throw new IllegalArgumentException("Name can not be null or empty");
        }
        if(user.getEmail() ==null || user.getEmail().isEmpty()){
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }
    }


}
