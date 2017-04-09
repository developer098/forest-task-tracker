package aim.foresttracker.config.epam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(value = "aim.foresttracker.site.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired @Qualifier("LoginSuccessHandler")
    AuthenticationSuccessHandler loginSuccessHandler;
    @Autowired @Qualifier("LoginFailureHandler")
    AuthenticationFailureHandler loginFailureHandler;
    @Autowired @Qualifier("RestAuthenticationEntryPoint")
    AuthenticationEntryPoint authenticationEntryPoint;
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                    .authorizeRequests().anyRequest().authenticated()
                // your access settings
                .and().formLogin()
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler);
        // other settings
    }
}
