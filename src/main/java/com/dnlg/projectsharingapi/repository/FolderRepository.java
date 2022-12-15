package com.dnlg.projectsharingapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dnlg.projectsharingapi.entity.Folder;

public interface FolderRepository extends CrudRepository <Folder, Long> {
    Optional<Folder> findByUserId(Long userId);
}
