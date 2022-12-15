package com.dnlg.projectsharingapi.service;

import java.util.List;

import com.dnlg.projectsharingapi.entity.User;

public interface UserService {
    User getUser(Long id);
    User saveUser(Long id);
    void deleteUser(Long id);
    List<User> getUsers();
}
