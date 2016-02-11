package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.TodoList;

public interface TodoDao {

	TodoList findById(int id);

	void saveTodo(TodoList todoList);
	
	void deleteTodoById(Integer id);
	
	List<TodoList> findAllTodos();

	List<TodoList> findByActiveTodos();

	List<TodoList> findByInActiveTodos();

	TodoList findTodoById(Integer id);

}
