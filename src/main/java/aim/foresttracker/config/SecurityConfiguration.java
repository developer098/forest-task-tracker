package aim.foresttracker.config;

import aim.foresttracker.site.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.inject.Inject;

/**
 *
 */
//@Configuration
//@EnableWebSecurity
//@ComponentScan(value = "aim.foresttracker.site.security")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Inject
    private ForestUserDetailsService userDetailsService;
    @Inject
    private HttpAuthenticationEntryPoint authenticationEntryPoint;
    @Inject
    private AuthSuccessHandler authSuccessHandler;
    @Inject
    private AuthFailureHandler authFailureHandler;
    @Inject
    private HttpLogoutSuccessHandler logoutSuccessHandler;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); //TODO: зачем?
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean(); //TODO: зачем?
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(new ShaPasswordEncoder());

        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager(); //TODO: зачем?
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() //TODO: зачем?
                .authenticationProvider(authenticationProvider())
                    .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                    .formLogin()
                        .permitAll()
                    .loginProcessingUrl("user/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .successHandler(authSuccessHandler)
                        .failureHandler(authFailureHandler)
                .and()
                    .logout()
                    .permitAll()
                    .logoutRequestMatcher(new AntPathRequestMatcher("user/login", "DELETE"))
                    .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                    .sessionManagement()
                    .maximumSessions(1);

        http.authorizeRequests().anyRequest().authenticated();
    }



//    @Override
//    protected void configure(AuthenticationManagerBuilder builder)
//            throws Exception {
//        builder
//                .inMemoryAuthentication()
//                .withUser("lesnik")
//                .password("123")
//                .authorities("USER")
//                .and()
//                .withUser("admin")
//                .password("admin")
//                .authorities("USER", "ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/", "/home.html").permitAll()
//                .anyRequest().authenticated()
//            .and()
//            .formLogin()
//                .loginPage("/login.html")
//                .permitAll()
//            .and()
//            .logout()
//                .permitAll()
//            .and()
//                .csrf().disable();
//    }
}
