package com.dnlg.projectsharingapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.dnlg.projectsharingapi.entity.Folder;

public interface FolderRepository extends CrudRepository <Folder, Long> {
    Folder findByUserId(Long userId);
}
