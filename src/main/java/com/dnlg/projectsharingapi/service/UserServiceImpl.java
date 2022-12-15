package com.dnlg.projectsharingapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dnlg.projectsharingapi.entity.User;
import com.dnlg.projectsharingapi.exception.UserNotFoundException;
import com.dnlg.projectsharingapi.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    
    UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();  
        } else {
            throw new UserNotFoundException(id);
        }
    }

    public User saveUser(Long id) {
        User user = userRepository.findById(id).get();
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

}
