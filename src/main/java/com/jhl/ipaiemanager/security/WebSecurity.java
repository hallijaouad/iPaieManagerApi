package com.jhl.ipaiemanager.security;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import com.jhl.ipaiemanager.security.UserDetailsServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.context.annotation.Bean;

import static com.jhl.ipaiemanager.security.SecurityConstants.SIGN_UP_URL;


@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private UserDetailsServiceImpl userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//URI d'auth
    	JWTAuthenticationFilter authenticationFilter = new JWTAuthenticationFilter(authenticationManager());
    	authenticationFilter.setFilterProcessesUrl("/api/auth");  
    	
    	http.cors()
    	.and()
    	.csrf().disable()
    	.authorizeRequests()
    	// autorisation des files static 
        .antMatchers("/index.html", "/","/favicon.ico","/js/*.js","/css/*.css","/*.js.map").permitAll()
        // Autorisation end point
        .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
        // All end point autorisé avec authentification
        .anyRequest()
        .authenticated()
        .and()           
        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
        .addFilter(authenticationFilter)
        // this disables session creation on Spring Security
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();    
	    CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    source.registerCorsConfiguration("/**", config);
	    return source;
    }
}