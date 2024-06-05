package com.example.jdbc_security_project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class Security_Configuration extends WebSecurityConfigurerAdapter {
    @Bean
    protected UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
       /* jdbcUserDetailsManager.createUser(User.builder().username("admin").password("$2a$12$HAzOB.XDMQxE6wSU/g/Mdex0l9IT7tshGCURIvczqvCRLJVoFrkni")
                .authorities("write").build());
        jdbcUserDetailsManager.createUser(User.builder().username("user").password("$2a$12$263EeACe2JuCOhXoxuJSVuIVVhHT.Qr9mc8YLTxCjgBkd1UQ.2u0u")
                .authorities("read").build());*/
        return jdbcUserDetailsManager;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/api/signin/**").permitAll()
                .antMatchers("/api/delete/**").hasAuthority("write")
                .antMatchers("/api/getId/**").hasAuthority("write").and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
