package com.jhl.ipaiemanager.security;

import com.jhl.ipaiemanager.models.Utilisateur;
import com.jhl.ipaiemanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	Utilisateur appUser = userService.getUserByEmail(email);
        if(appUser==null) throw new UsernameNotFoundException("invalid user");       
        return new User(appUser.getEmail(), appUser.getPassword(), emptyList());
    }
}
