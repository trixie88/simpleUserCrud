package com.trix.simpleCrud.service;

import java.util.List;

import com.trix.simpleCrud.entity.User;

public interface UserService {

	public List<User> getUsers();

	public void saveUser(User user);

	public User findById(int id);

	public void deleteUser(User user);
}
