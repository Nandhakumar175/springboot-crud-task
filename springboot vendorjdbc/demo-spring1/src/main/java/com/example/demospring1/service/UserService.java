package com.example.demospring1.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospring1.dto.User;
import com.example.demospring1.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) throws Exception  {
		userRepository.save(user);
		
	
		
	}
	public List<User> getAll() throws SQLException, ClassNotFoundException {
		
		return userRepository.getAll();
	}
	public List<User> getbyid(Integer vendorid) throws ClassNotFoundException, SQLException {
		
		return userRepository.getById(vendorid);
		// TODO Auto-generated method stub
		
	}
	public void delete(Integer vendorid) throws Exception  {
		userRepository.delete(vendorid);
	}
	public void update(User user) throws Exception  {
		userRepository.update(user);
		
	}


	
	

}
