package com.bakarot.demoapicurd.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class StudentSecurityConfigure {

    @Bean
    fun userDetailsManagers(): InMemoryUserDetailsManager {
        val employee = User.builder()
            .username("employee")
            .password("{noop}employee")
            .roles("EMPLOYEE")
            .build()
        val manager = User.builder()
            .username("manager")
            .password("{noop}manager")
            .roles("MANAGER")
            .build()
        val admin = User.builder()
            .username("admin")
            .password("{noop}admin")
            .roles("ADMIN")
            .build()
        return InMemoryUserDetailsManager(employee, manager, admin)
    }

    @Bean
    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        return httpSecurity
            .authorizeHttpRequests { authorizeRequests ->
                authorizeRequests
                    .requestMatchers(HttpMethod.GET, "/api/students/**").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                    .requestMatchers(HttpMethod.POST, "/api/students/**").hasAnyRole("MANAGER", "ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/api/students/**").hasAnyRole("MANAGER", "ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/students/**").hasAnyRole("ADMIN")
            }
            .httpBasic(Customizer.withDefaults())
            .csrf { it.disable() }
            .build()
    }
}