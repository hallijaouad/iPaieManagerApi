package com.jhl.ipaiemanager.security;

import com.auth0.jwt.JWT;

import com.jhl.ipaiemanager.models.Utilisateur;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.jhl.ipaiemanager.security.SecurityConstants.EXPIRATION_TIME;
import static com.jhl.ipaiemanager.security.SecurityConstants.HEADER_STRING;
import static com.jhl.ipaiemanager.security.SecurityConstants.SECRET;
import static com.jhl.ipaiemanager.security.SecurityConstants.TOKEN_PREFIX;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private AuthenticationFailureHandler failureHandler;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
        	Utilisateur creds = new ObjectMapper()
                    .readValue(req.getInputStream(), Utilisateur.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
    	
    	
    	 User user=(User)auth.getPrincipal();
         List<String> roles=new ArrayList<>();
         auth.getAuthorities().forEach(a->{
             roles.add(a.getAuthority());
         });
         
         String token= JWT.create()
                 .withIssuer(req.getRequestURI())
                 .withSubject(user.getUsername())
                 .withClaim("user", "HALLI JAOUAD")
                 .withArrayClaim("roles",roles.toArray(new String[roles.size()]))
                 .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                 .sign(HMAC512(SECRET.getBytes()));  
        /**
        ArrayList<String> tokenObjet =new ArrayList<String>();
        tokenObjet.add(token);        
        PrintWriter out = res.getWriter();
        ObjectMapper objectMapper= new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(tokenObjet);
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(jsonString);
        out.flush();*/
        
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        String tokenJson = "{\"token_access\":\"" + token + "\"}";
        res.getWriter().write(tokenJson);
          
        
    }
    
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
        //SecurityContextHolder.clearContext();
        //failureHandler.onAuthenticationFailure(request, response, failed);
    	 String invalid_auth = "Email ou mot de passe est invlaide";
    	 String tokenJson = "{\"invalid_auth\":\"" + invalid_auth + "\"}";
    	 response.getWriter().write(tokenJson);
    }
    
    
}