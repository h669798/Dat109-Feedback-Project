package org.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @SuppressWarnings({ "removal", "deprecation" })
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/login", "/css/**", "/js/**", "/images/**").permitAll()  // Allow access to login and static resources
                .requestMatchers("/dashboard").permitAll()  // Allow access to dashboard
                .anyRequest().authenticated()  // All other requests require authentication
            .and()
            .formLogin()
                .loginPage("/login")  // Custom login page
                .defaultSuccessUrl("/dashboard", true)  // Redirect to dashboard on successful login
                .permitAll()
            .and()
            .logout()
                .permitAll();  // Allow everyone to logout

        return http.build();
    }
}
