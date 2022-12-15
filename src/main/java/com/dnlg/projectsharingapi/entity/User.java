package com.dnlg.projectsharingapi.entity;

import java.util.List;

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
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(nullable = false, unique = false)
    private String name;

    @NotBlank(message = "Last Name cannot be blank")
    @NonNull
    @Column(nullable = false, unique = false)
    private String last_name;
    
    @NotBlank(message = "Email cannot be blank")
    @NonNull
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @NonNull
    @Column(nullable = false)
    private String password;

    @Column(nullable= true)
    private String profile_picture;

    @Column(nullable = true)
    private String linkedIn_url;

    @Column(nullable = true)
    private String github_url;

    @Column(nullable = true)
    private String profile;

    @Column(nullable = true)
    private String occupation;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Folder> folders;
    
    
}
