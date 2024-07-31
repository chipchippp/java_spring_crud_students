package com.spring.crud_students.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {
//    @Bean
//    @Autowired
//    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }
    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select id, password, active from accounts where id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select id, role from roles where id=?");
        return userDetailsManager;
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{noop}123")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}123")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails operator = User.builder()
//                .username("operator")
//                .password("{noop}123")
//                .roles("OPERATOR")
//                .build();
//
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(user);
//        manager.createUser(admin);
//        manager.createUser(operator);
//        return manager;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config -> config
                .requestMatchers(HttpMethod.GET, "/api/v1/").hasAnyRole("USER", "MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/v1/classroom/**").hasAnyRole("USER", "MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/v1/**").hasAnyRole("MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/v1/").hasAnyRole("MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/classroom/**").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
//     csrf -> cross site request forgery
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        userDetailsManager.setUsersByUsernameQuery("select user_id, password, is_active from members where user_id = ?");
//        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id = ?");
//        return userDetailsManager;
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(config ->
//                {
//                    config.requestMatchers("/")
//                            .authenticated()
//                            .anyRequest()
//                            .permitAll();
//                }).formLogin(config -> config.loginPage("/loginPage").permitAll());
//        return http.build();
//    }


}
