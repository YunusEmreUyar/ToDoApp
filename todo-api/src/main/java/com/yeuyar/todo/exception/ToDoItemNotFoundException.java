package com.yeuyar.todo.exception;

public class ToDoItemNotFoundException extends RuntimeException{

    public ToDoItemNotFoundException(String msg) {
        super(msg);
    }
}
