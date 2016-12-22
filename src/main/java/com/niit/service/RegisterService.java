package com.niit.service;

import java.util.List;

import org.apache.catalina.User;

import com.niit.model.Register;

public interface RegisterService {

	public void addUser(Register register);
	public void deleteUser(int  id);
	public void editUser(Register register );
	public Register getUserById(int id);
	public List<Register> getAllUser();
}
