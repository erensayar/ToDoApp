package com.erensayar.todoapp.Entity;

import com.erensayar.todoapp.ViewModel.Views;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author erensayar
 */
@Data
@Entity
@ApiModel(value = "Note Model")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.NoteBase.class)
    private Integer id;

    @Column(length = 35)
    @JsonView(Views.NoteBase.class)
    private String noteName;

    @Column(length = 10000)
    @JsonView(Views.Note.class)
    private String comment;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    @JsonView(Views.Note.class)
    private LocalDateTime creatingDate = LocalDateTime.now();       //private Date creatingDate = new Date();


    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    @JsonView(Views.Note.class)
    private LocalDateTime targetDate;

}
