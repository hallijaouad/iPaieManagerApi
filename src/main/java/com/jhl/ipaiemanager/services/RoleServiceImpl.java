package com.jhl.ipaiemanager.services;

import com.jhl.ipaiemanager.models.Role;
import java.util.Collection;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.apache.commons.collections4.IteratorUtils;
import com.jhl.ipaiemanager.dao.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
    private RoleRepository roleRepository;

    @Override
    public Collection<Role> getAllRoles() { //Avant JAVA8
    	return null;
        //return IteratorUtils.toList(roleRepository.findAll().iterator());
    }
    
    @Override
    public Stream<Role> getAllRolesStream() {//JAVA8
        return roleRepository.getAllRolesStream();
    }
    
    @Override
    public Role findByRoleRefext(String refext) {
        return roleRepository.findByRefext(refext);
    }
    
}