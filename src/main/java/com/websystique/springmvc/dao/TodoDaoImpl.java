package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.TodoList;

@Repository("todoDao")
public class TodoDaoImpl extends AbstractDao<Integer, TodoList> implements TodoDao {

	public TodoList findById(int id) {
		return getByKey(id);
	}

	public void saveTodo(TodoList todoList) {
		persist(todoList);
	}

	public void deleteTodoById(Integer id) {
		Query query = getSession().createSQLQuery("delete from TodoList where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<TodoList> findAllTodos() {
		Criteria criteria = createEntityCriteria();
		return (List<TodoList>) criteria.list();
	}

	public List<TodoList> findByActiveTodos() {
				Query query = getSession()
				.createSQLQuery("select * from TodoList where status = 1")
				.addEntity(TodoList.class);
		return (List<TodoList>) query.list();
	}

	public List<TodoList> findByInActiveTodos() {
		Query query = getSession()
				.createSQLQuery("select * from TodoList where status = 0")
				.addEntity(TodoList.class);
		return (List<TodoList>) query.list();
	}

	public TodoList findTodoById(Integer id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (TodoList) criteria.uniqueResult();
	}
}
