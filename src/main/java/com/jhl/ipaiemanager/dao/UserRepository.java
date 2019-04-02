package com.jhl.ipaiemanager.dao;
import com.jhl.ipaiemanager.models.User;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
	List<User> findByNom(String nom);
	User findByPkUser(Long id);
	
}
