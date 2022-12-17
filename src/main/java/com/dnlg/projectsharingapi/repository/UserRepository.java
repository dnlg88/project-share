package com.dnlg.projectsharingapi.repository;


import org.springframework.data.repository.CrudRepository;

import com.dnlg.projectsharingapi.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
}
