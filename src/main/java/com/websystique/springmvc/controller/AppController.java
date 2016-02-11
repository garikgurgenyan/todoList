package com.websystique.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.TodoList;
import com.websystique.springmvc.service.TodoListService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	TodoListService service;
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		List<TodoList> todoLists = service.findAllTodos();
		model.addAttribute("todoList", todoLists);
		return "alltodos";
	}

	@RequestMapping(value = { "/activeList" }, method = RequestMethod.GET)
	public String listAcvtiveEmployees(ModelMap model) {

		List<TodoList> todoLists = service.findByActiveTodos();
		model.addAttribute("todoList", todoLists);
		return "alltodos";
	}

	@RequestMapping(value = {"/inactiveList" }, method = RequestMethod.GET)
	public String listInAcvtiveEmployees(ModelMap model) {

		List<TodoList> todoLists = service.findByInActiveTodos();
		model.addAttribute("todoList", todoLists);
		return "alltodos";
	}



	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		TodoList todoList = new TodoList();
		model.addAttribute("todoList", todoList);
		model.addAttribute("edit", false);
		return "registration";
	}


	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid TodoList todoList, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}



		service.saveTodo(todoList);

		model.addAttribute("success", "Заметка  " + todoList.getNote()	+ " успешно добавлена.");
		return "success";
	}



	@RequestMapping(value = { "/edit-{id}-todo" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable Integer id, ModelMap model) {
		TodoList todoList = service.findTodoById(id);
		model.addAttribute("todoList", todoList);
		model.addAttribute("edit", true);
		return "registration";
	}
	

	@RequestMapping(value = { "/edit-{id}-todo" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid TodoList todoList, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "registration";
		}

		service.updateTodo(todoList);

		model.addAttribute("success", "Заметка  " + todoList.getNote()	+ " успешно добавлена.");
		return "success";
	}

	

	@RequestMapping(value = { "/delete-{id}-todo" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable Integer id) {
		service.deleteTodoById(id);
		return "redirect:/list";
	}

}
