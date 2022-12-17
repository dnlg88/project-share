package com.dnlg.projectsharingapi.entity;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Username cannot be blank")
    @NonNull
    @Column(name = "username", unique = true)
    private String username;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Last Name cannot be blank")
    @NonNull
    @Column(name = "last_name")
    private String lastName;
    
    @NotBlank(message = "Email cannot be blank")
    @NonNull
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @NonNull
    @Column(nullable = false) 
    private String password;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "linked_in_url", unique = true)
    private String linkedInUrl;

    @Column(name = "github_url", unique = true)
    private String githubUrl;

    @Column(name = "profile")
    private String profile;

    @Column(name = "occupation")
    private String occupation;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Folder> folders;
    
    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

}
