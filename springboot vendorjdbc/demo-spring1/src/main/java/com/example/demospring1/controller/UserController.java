package com.example.demospring1.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospring1.dto.GenericResponse;
import com.example.demospring1.dto.User;
import com.example.demospring1.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "/create")
	private GenericResponse<User> createUser(@RequestBody User user) throws Exception {
		userService.save(user);
		GenericResponse<User> response = new GenericResponse<User>();
		response.setData(null);
		response.setDatalist(null);
		response.setStatus("SUCCESS");
		response.setMessage("Saved Sucessfully");
		return response;

	}

	@GetMapping(value = "/get")
	private GenericResponse<User> getAll() throws SQLException, ClassNotFoundException {
		List<User> users = userService.getAll();
		GenericResponse<User> response = new GenericResponse<>();
		response.setData(null);
		response.setDatalist(users);
		response.setStatus("SUCCESS");
		response.setMessage("Saved Sucessfully");
		return response;

	}

	@GetMapping(value = "/get/{vendorid}")
	private GenericResponse<User> getbyid(@PathVariable Integer vendorid) throws Exception {
		List<User> users = userService.getbyid(vendorid);
		GenericResponse<User> response = new GenericResponse<User>();
		response.setData(null);
		response.setDatalist(users);
		response.setStatus("SUCCESS");
		response.setMessage("Saved Sucessfully");
		return response;

	}

	@DeleteMapping(value = "/delete/{vendorid}")
	private GenericResponse<User> delete(@PathVariable Integer vendorid) throws Exception {
		 userService.delete(vendorid);
		GenericResponse<User> response = new GenericResponse<User>();
		response.setData(null);
		response.setDatalist(null);
		response.setStatus("SUCCESS");
		response.setMessage("Delete Sucessfully");
		return response;

	}

	@PutMapping(value = "/update")
	private GenericResponse<User> update(@RequestBody User user) throws Exception {
		userService.update(user);
		GenericResponse<User> response = new GenericResponse<User>();
		response.setData(null);
		response.setDatalist(null);
		response.setStatus("SUCCESS");
		response.setMessage("Updated Sucessfully");
		return response;

	}

}
