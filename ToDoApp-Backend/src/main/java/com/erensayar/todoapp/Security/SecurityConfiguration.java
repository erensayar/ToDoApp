package com.erensayar.todoapp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author erensayar
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //<============================================>
    UserAuthService userAuthService;
    @Autowired
    public SecurityConfiguration(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //<============================================>



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().authenticationEntryPoint(new AuthEntryPoint()); // For Browser Pop-up
        http.headers().frameOptions().disable(); // For h2 DB Can Visible From Broser

        http
                .authorizeRequests().antMatchers(HttpMethod.POST, "/api/auth").authenticated()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/auth").authenticated()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.PUT, "/api/auth").authenticated()
                .and()
                .authorizeRequests().anyRequest().permitAll();

        // Session hep acik kalmamasi saglaniyor. Her requestte credentials istenmis olur.
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userAuthService).passwordEncoder(passwordEncoder());
    }



}