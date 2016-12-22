package com.niit.serviceImpl;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.RegisterDAO;
import com.niit.model.Register;
import com.niit.service.RegisterService;
@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO rd;
	
	public void addUser(Register register) {
		rd.addUser(register);
	}

	public void deleteUser(int id) {
rd.deleteUser(id);		
	}

	public void editUser(Register register) {
rd.editUser(register);		
	}

	public Register getUserById(int id) {
return rd.getUserById(id);
	}

	public List<Register> getAllUser() {
	return	rd.getAllUser();
	}

}
