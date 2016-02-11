package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.TodoList;

public interface TodoListService {

	TodoList findById(int id);
	
	void saveTodo(TodoList todoList);
	
	void updateTodo(TodoList todoList);
	
	void deleteTodoById(Integer id);

	List<TodoList> findAllTodos();

	List<TodoList> findByActiveTodos();

	List<TodoList> findByInActiveTodos();

	TodoList findTodoById(Integer id);


}
