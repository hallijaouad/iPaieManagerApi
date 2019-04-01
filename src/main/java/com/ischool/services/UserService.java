package com.ischool.services;
import java.util.List;


import com.ischool.models.User;

public interface UserService {
	List<User> findAll();
	List<User> findByNom(String nom);
	User create (User user);
	User update (User user);
	User findById(Long id);
	User delete(Long id);
}
