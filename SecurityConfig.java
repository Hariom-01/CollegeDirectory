package com.aryajohary.collegedirectory.security;

import com.aryajohary.collegedirectory.schemas.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationProvider authenticationProvider) throws Exception {
        http.authenticationProvider(authenticationProvider);
        http.authorizeHttpRequests(
                        configurer -> configurer
                                .requestMatchers("/studentProfiles/**").hasAnyAuthority(String.valueOf(Role.Student), String.valueOf(Role.Administrator))
                                .requestMatchers("/facultyprofiles/**").hasAnyAuthority(String.valueOf(Role.Faculty_Member), String.valueOf(Role.Administrator))
                                .requestMatchers("/administratorProfiles/**").hasAuthority(String.valueOf(Role.Administrator))
                                .requestMatchers("/courses/**").permitAll()
                                .requestMatchers("/users/**").hasAuthority(String.valueOf(Role.Administrator))
                                .requestMatchers("/departments/**").permitAll()
                                .anyRequest().authenticated()
                );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(CustomUserDetailsService customUserDetailsService){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        System.out.println("Authentication provider being called");
        return daoAuthenticationProvider;
    }

}
