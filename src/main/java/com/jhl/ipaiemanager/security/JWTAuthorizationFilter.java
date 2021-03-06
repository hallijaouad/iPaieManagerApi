package com.jhl.ipaiemanager.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


import static com.jhl.ipaiemanager.security.SecurityConstants.HEADER_STRING;
import static com.jhl.ipaiemanager.security.SecurityConstants.SECRET;
import static com.jhl.ipaiemanager.security.SecurityConstants.TOKEN_PREFIX;


/**
 * 
 * @author jhl
 *
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter{
	
	public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }
	
	 @Override
	    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		 System.out.println("HALLI" + req.getMethod());
		   if ("OPTIONS".equals(req.getMethod())) {
	            res.setStatus(HttpServletResponse.SC_OK);
	            return;
	       }		 
	        String header = req.getHeader(HEADER_STRING);	        
	        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
	            chain.doFilter(req, res);
	            return;
	        }
	        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        chain.doFilter(req, res);
	    }

	    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
	        String token = request.getHeader(HEADER_STRING);
	        if (token != null) {
	            // parse the token.
	            String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
	                    .build()
	                    .verify(token.replace(TOKEN_PREFIX, ""))
	                    .getSubject();

	            if (user != null) {
	                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
	            }
	            return null;
	        }
	        return null;
	    }
}