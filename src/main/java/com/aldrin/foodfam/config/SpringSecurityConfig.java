package com.aldrin.foodfam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig implements WebMvcConfigurer {



    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

 

    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/registration/**",
                        "/login/**", 
                        "/",
                        "/webjars/**",
                        "/js/**",
                        "/css/**",
                        "/images/**").permitAll();
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").successHandler(successHandler)
//                .and().csrf().disable()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/")
//                .and().oauth2Login().loginPage("/login").successHandler(successHandler);
        return http.build();

    }

  

}
