package com.yeuyar.todo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ToDoDto implements Serializable {

    private Long id;
    private String title;
    private String body;
    private LocalDateTime createdOn;
    private Boolean isDone;

    public ToDoDto() {

    }

    public ToDoDto(Long id, String title, String body, LocalDateTime createdOn, Boolean isDone) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdOn = createdOn;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
