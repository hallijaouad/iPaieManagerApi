package com.jhl.ipaiemanager.services;
import java.util.Collection;
import java.util.stream.Stream;

import com.jhl.ipaiemanager.models.Role;

public interface RoleService {
	
	Role findByRoleRefext(String refext);
    
    Collection<Role> getAllRoles();
    
    Stream<Role> getAllRolesStream();
}