package com.dnlg.projectsharingapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dnlg.projectsharingapi.entity.User;

@Service
public interface UserService {
    User getUser(Long id);
    User saveUser(User user);
    User updateUser(Long id);
    void deleteUser(Long id);
    List<User> getUsers();
}
