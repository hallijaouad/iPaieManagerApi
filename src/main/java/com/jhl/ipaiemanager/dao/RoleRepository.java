package com.jhl.ipaiemanager.dao;
import com.jhl.ipaiemanager.models.Role;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long>{
	Role findByRefext(String refext);

    @Query("SELECT refext, libelle FROM roles")    
    Stream<Role> getAllRolesStream();
}
