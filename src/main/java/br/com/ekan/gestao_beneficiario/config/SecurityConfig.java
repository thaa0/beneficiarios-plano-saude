package br.com.ekan.gestao_beneficiario.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
			
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and()
				.authorizeHttpRequests((requests) -> requests
				.anyRequest().authenticated())
	            .formLogin(withDefaults())
				.httpBasic(withDefaults());
	    return http.build();
	    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
	    UserDetails user = User.builder()
	        .username("user")
	        .password(passwordEncoder.encode("password"))
	        .roles("USER")
	        .build();
	    UserDetails user2 = User.builder()
		        .username("user2")
		        .password(passwordEncoder.encode("password"))
		        .roles("ADMIN")
		        .build();
	    return new InMemoryUserDetailsManager(user, user2);
	}
}