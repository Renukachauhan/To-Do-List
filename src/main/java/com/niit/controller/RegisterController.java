package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.model.Register;
import com.niit.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@RequestMapping(value = "/")
	public String register(Model model) {
		model.addAttribute("user", new Register());// to save the object,will
													// help in edit nd delete
		model.addAttribute("usr", registerService.getAllUser());

		return "register";
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") Register register) {
		if (register.getId() == 0) {
			//new person, add it
			registerService.addUser(register);

		} else {
			//existing person update
			registerService.editUser(register);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{id}") // for deleting
	public String delete(@PathVariable("id") int id) {
		registerService.deleteUser(id);

		return "redirect:/";
	}

	@RequestMapping(value = "/edit/{id}") //
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", registerService.getUserById(id));
		model.addAttribute("usr", registerService.getAllUser());

		return "register";
	}
}
