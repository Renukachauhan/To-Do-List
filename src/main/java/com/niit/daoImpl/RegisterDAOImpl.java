package com.niit.daoImpl;

import java.util.List;

import org.apache.catalina.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.RegisterDAO;
import com.niit.model.Register;
@Repository
public class RegisterDAOImpl implements RegisterDAO {

	@Autowired
	private SessionFactory sf;
	
	public void addUser(Register register) {
		sf.getCurrentSession().save(register);
	}

	public List<Register> getAllUser() {
List<Register> reg= (List<Register>)sf.getCurrentSession().createQuery("from Register").list();
//for(Register r:reg)
	//System.out.println(r.getAddress());

return reg;
	}

	public void deleteUser(int id) {
Register r= (Register)sf.getCurrentSession().load(Register.class, id);//to load complete row
sf.getCurrentSession().delete(r);
	}

	public void editUser(Register register) {
sf.getCurrentSession().update(register);		
	}

	public Register getUserById(int id) {
		return (Register) sf.getCurrentSession().get(Register.class, id);
	}

}
