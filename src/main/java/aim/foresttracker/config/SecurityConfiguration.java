package aim.foresttracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder builder)
            throws Exception {
        builder
                .inMemoryAuthentication()
                .withUser("lesnik")
                .password("123")
                .authorities("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .authorities("USER", "ADMIN");
    }

//        @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic().and()
//                .authorizeRequests()
//                .anyRequest().authenticated();
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home.html").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login.html")
                .permitAll()
            .and()
            .logout()
                .permitAll()
            .and()
                .csrf().disable();
    }
}
