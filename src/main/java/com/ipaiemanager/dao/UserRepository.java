package com.ipaiemanager.dao;
import com.ipaiemanager.models.User;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
	List<User> findByNom(String nom);
	User findByPkUser(Long id);
	
}
