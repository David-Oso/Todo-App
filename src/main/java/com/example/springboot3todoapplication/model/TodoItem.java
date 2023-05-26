package com.example.springboot3todoapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
@Table(name = "todo-items")
public class TodoItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private Boolean isComplete;
    private Instant createdAt;
    private Instant updatedAt;


    @Override
    public String toString(){
        String create = DateTimeFormatter.ofPattern("EEE, dd/MM/yy, hh:mm:ss a").format(getCreatedAt());
        String update = DateTimeFormatter.ofPattern("EEE, dd/MM/yy, hh:mm:ss a").format(getUpdatedAt());

        return String.format("TodoItem{id=%d, description='%s', isComplete='%s', createdAt='%s', updatedAt='%s'}",
                id, description, isComplete, create, update);
    }
}