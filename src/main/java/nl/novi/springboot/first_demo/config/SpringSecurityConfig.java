package nl.novi.springboot.first_demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            //HTTP Basic authentication
            .httpBasic()
            .and()
            .authorizeRequests()
//            .antMatchers("/**").permitAll()
                .antMatchers(HttpMethod.GET, "/v1/admin/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/v1/cursussen/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/v1/students/**").hasRole("USER")
//                .antMatchers(HttpMethod.GET, "/users/**").hasRole("USER") // per user authorization in UserService
//                .antMatchers(HttpMethod.GET,"/authenticated/**").authenticated()
                .anyRequest().authenticated()
//            .anyRequest().permitAll()
            .and()
            .csrf().disable()
            .formLogin().disable();
    }

}