package com.yeuyar.todo.dto;


import com.yeuyar.todo.model.ToDo;
import org.springframework.stereotype.Component;

@Component
public class ToDoDtoConverter {

    public ToDoDto convert(ToDo toDo) {
        return new ToDoDto(toDo.getId(), toDo.getTitle(), toDo.getBody(), toDo.getCreatedOn(), toDo.getDone());
    }
}
