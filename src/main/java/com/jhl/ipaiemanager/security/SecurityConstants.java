package com.jhl.ipaiemanager.security;
/**
 * 
 * @author jhl
 *
 */
public class SecurityConstants{
	public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 10*24*36000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/users";  
    public static final String SIGN_OUT_URL = "/api/logout";  
}