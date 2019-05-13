package com.trix.simpleCrud.dao;

import java.util.List;

import com.trix.simpleCrud.entity.User;

public interface UserDAO {

	public List<User> getUsers();

	public void saveUser(User user);

	public User findById(int id);

	public void deleteUser(User user);
}
