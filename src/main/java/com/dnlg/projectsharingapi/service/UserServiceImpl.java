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
    public User getUser(Long id, String username) {
        Optional<User> user = userRepository.findUserByIdOrUsername(id, username);
        return unwrapUser(user, id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        User unwrappedUser = unwrapUser(user, id);
        return userRepository.save(unwrappedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    static User unwrapUser(Optional<User> user, Long id){
        if (user.isPresent()) return user.get();
        else throw new UserNotFoundException(id);
    }

}
