package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.TodoDao;
import com.websystique.springmvc.model.TodoList;

@Service("employeeService")
@Transactional
public class TodoListServiceImpl implements TodoListService {

	@Autowired
	private TodoDao dao;
	
	public TodoList findById(int id) {
		return dao.findById(id);
	}

	public void saveTodo(TodoList todoList) {
		dao.saveTodo(todoList);
	}


	public void updateTodo(TodoList todoList) {
		TodoList entity = dao.findById(todoList.getId());
		if(entity!=null){
			entity.setNote(todoList.getNote());
			entity.setDeadLine(todoList.getDeadLine());
			entity.setStatus(todoList.getStatus());
		}
	}

	public void deleteTodoById(Integer id) {
		dao.deleteTodoById(id);
	}
	
	public List<TodoList> findAllTodos() {
		return dao.findAllTodos();
	}

	public List<TodoList> findByActiveTodos() {
		return dao.findByActiveTodos();
	}

	public List<TodoList> findByInActiveTodos() {
		return dao.findByInActiveTodos();
	}

	public TodoList findTodoById(Integer id) {
		return dao.findTodoById(id);
	}


}
