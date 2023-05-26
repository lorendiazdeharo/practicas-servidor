package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	/*
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests()
				.requestMatchers("/", "/clientes", "/fragments/**").permitAll()
				.requestMatchers("/clientes/**").authenticated()
			.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
			.and()
				.logout()
					.permitAll()
					.logoutSuccessUrl("/");

		return http.build();
	}
	*/
	
	/*
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 =
			 User.withDefaultPasswordEncoder()
					.username("user")
					.password("password")
					.roles("USER")
				.build();
		
		UserDetails user2 =
				 User.withDefaultPasswordEncoder()
						.username("admin")
						.password("12345678")
						.roles("ADMIN","USER")
					.build();		

		return new InMemoryUserDetailsManager(user1, user2);
	}*/	
	
    @Autowired
    private UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests()
				.requestMatchers("/", "/clientes", "/fragments/**","/register", "/users/save/**").permitAll()
				.requestMatchers("/clientes/add/**",
						"/clientes/delete/**",
						"/clientes/update/**",
						"/clientes/save/**").hasRole("ADMIN")
				.requestMatchers("/clientes/{idCliente}/direcciones").hasAnyRole("ADMIN","USER")
				.requestMatchers("/clientes/{idCliente}/direcciones/add/**",
						"/clientes/{idCliente}/direcciones/delete/**",
						"/clientes/{idCliente}/direcciones/update/**",
						"/clientes/{idCliente}/direcciones/save/**").hasRole("ADMIN")
				.requestMatchers("/clientes/{idCliente}/cuentas").hasAnyRole("ADMIN","USER")
				.requestMatchers("/clientes/{idCliente}/cuentas/add/**",
						"/clientes/{idCliente}/cuentas/delete/**",
						"/clientes/{idCliente}/cuentas/update/**",
						"/clientes/{idCliente}/cuentas/save/**",
						"/clientes/{idCliente}/cuentas/**").hasRole("ADMIN")					
				.anyRequest().authenticated()
			.and()
				.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/clientes")
					.failureUrl("/login?error")					
					.permitAll()
			.and()
				.logout()
					.permitAll()
					.logoutSuccessUrl("/")
			.and()
				.exceptionHandling().accessDeniedPage("/errors/403");
		return http.build();
	}	

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
}
