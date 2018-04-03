package edu.northeastern.is4300.pettasktracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity(name = "tasks")
public class Task implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String type;
    
    @NotBlank
    private String repeat;
    
    @NotBlank
    @Column(name = "time")
    private java.sql.Timestamp taskTime;
    
    @NotBlank
    @Column(name = "created")
    private java.sql.Timestamp taskCreated;
    
    @NotBlank
    @Column(name = "is_completed") 
    private int isCompleted;
    
    @NotBlank
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;
    
    @NotBlank
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Pet pet;
    
}

