package com.yeuyar.todo.service;


import com.yeuyar.todo.dto.CreateToDoRequest;
import com.yeuyar.todo.dto.ToDoDto;
import com.yeuyar.todo.dto.ToDoDtoConverter;
import com.yeuyar.todo.dto.UpdateToDoRequest;
import com.yeuyar.todo.exception.ToDoItemNotFoundException;
import com.yeuyar.todo.model.ToDo;
import com.yeuyar.todo.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final ToDoDtoConverter toDoDtoConverter;

    public ToDoService(ToDoRepository toDoRepository, ToDoDtoConverter toDoDtoConverter) {
        this.toDoRepository = toDoRepository;
        this.toDoDtoConverter = toDoDtoConverter;
    }

    public List<ToDoDto> getAllToDoItemsDto() {
        List<ToDo> todoItems = toDoRepository.findAll();
        return todoItems.stream().map(toDoDtoConverter::convert).collect(Collectors.toList());
    }

    public ToDoDto createToDoItem(CreateToDoRequest createToDoRequest) {
        ToDo todo = new ToDo();
        todo.setTitle(createToDoRequest.getTitle());
        todo.setBody(createToDoRequest.getBody());
        todo.setCreatedOn(LocalDateTime.now());
        todo.setDone(createToDoRequest.getDone());

        toDoRepository.save(todo);
        return toDoDtoConverter.convert(todo);
    }

    public ToDoDto getToDoById(long id) {
        return toDoRepository
                .findById(id)
                .map(toDoDtoConverter::convert)
                .orElseThrow(() -> new ToDoItemNotFoundException("The todo item that you are trying to get is not found."));
    }

    public ToDoDto updateToDoById(Long id, UpdateToDoRequest updateToDoRequest) {
        Optional<ToDo> todoFound = toDoRepository.findById(id);

        if(todoFound.isPresent()) {
            ToDo update = todoFound.get();
            update.setBody(updateToDoRequest.getBody());
            update.setTitle(updateToDoRequest.getTitle());
            update.setDone(updateToDoRequest.getDone());
            return todoFound.map(toDoDtoConverter::convert).orElse(new ToDoDto());
        }
        return null;
    }

    public void deleteToDo(Long id) {
        toDoRepository.deleteById(id);
    }

}
