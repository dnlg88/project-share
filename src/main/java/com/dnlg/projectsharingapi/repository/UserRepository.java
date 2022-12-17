package com.dnlg.projectsharingapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dnlg.projectsharingapi.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findUserbyId(Long id);
    Optional<User> findUserbyUsername(String username);
}
