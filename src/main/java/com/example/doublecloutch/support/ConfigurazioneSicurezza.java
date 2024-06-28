package com.example.doublecloutch.support;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
    @Configuration
    @EnableWebSecurity
    public class ConfigurazioneSicurezza extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .anyRequest().permitAll() // Consenti l'accesso a tutte le risorse senza autenticazione
                    .and()
                    .csrf().disable(); // Disabilita CSRF per semplificare il test
        }
    }



