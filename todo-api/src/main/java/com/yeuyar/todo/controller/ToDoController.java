package com.yeuyar.todo.controller;


import com.yeuyar.todo.dto.CreateToDoRequest;
import com.yeuyar.todo.dto.ToDoDto;
import com.yeuyar.todo.dto.UpdateToDoRequest;
import com.yeuyar.todo.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/todo")
public class ToDoController{

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    // Get Mappings
    @GetMapping("/")
    public ResponseEntity<List<ToDoDto>> getAllToDoItems() {
        return ResponseEntity.ok(toDoService.getAllToDoItemsDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoDto> getToDoById(@PathVariable Long id) {
        return ResponseEntity.ok(toDoService.getToDoById(id));
    }

    // Post Mappings
    @PostMapping("/")
    public ResponseEntity<ToDoDto> addToDo(@RequestBody CreateToDoRequest createToDoRequest) {
        return ResponseEntity.ok(toDoService.createToDoItem(createToDoRequest));
    }

    //Put Mappings
    @PutMapping("/{id}")
    public ResponseEntity<ToDoDto> updateToDo(@PathVariable Long id, @RequestBody UpdateToDoRequest updateToDoRequest) {
        return ResponseEntity.ok(toDoService.updateToDoById(id, updateToDoRequest));
    }

    // Delete Mappings
    @DeleteMapping("/{id}")
    public HttpStatus deleteToDo(@PathVariable Long id) {
        return HttpStatus.OK;
    }
}
