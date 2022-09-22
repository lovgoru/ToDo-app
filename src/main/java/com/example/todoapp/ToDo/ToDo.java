package com.example.todoapp.ToDo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class ToDo {

    @Id
    @SequenceGenerator(name = "todo_sequence", sequenceName = "todo_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_sequence")
    private Long id;


    private Long userId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String description;

    public ToDo() {
    }

    public ToDo(Long id, Long userId, LocalDate date, String description) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.description = description;
    }

    public ToDo(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
