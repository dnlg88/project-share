package com.dnlg.projectsharingapi.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title cannot be blank")
    @NonNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank(message = "Description cannot be blank")
    @NonNull
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "project_url")
    private String projectUrl;

    @Column(name = "github_url")
    private String githubUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectImage> projectImages;
    
    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Comment> comments;
    
    @OneToMany
    @JoinColumn(name = "languages", referencedColumnName = "id")
    private List<Language> languages;

}
