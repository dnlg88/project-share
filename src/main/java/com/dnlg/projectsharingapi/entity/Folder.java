package com.dnlg.projectsharingapi.entity;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Folder {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name")
    private String name;

    @CreationTimestamp
    @Column(name="created_at", nullable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;
    
}
