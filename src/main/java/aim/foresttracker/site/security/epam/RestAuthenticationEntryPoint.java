package aim.foresttracker.site.security.epam;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("RestAuthenticationEntryPoint")
public class RestAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    public RestAuthenticationEntryPoint() {
        this("/pages/login.html");
    }

    public RestAuthenticationEntryPoint(String loginUrl) {
        super(loginUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException
    ) throws IOException, ServletException {
        if (/*ajax call*/true) {
            String contentText = "{\"success\":false,\"systemError\":\"expired\"}";
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            super.commence(request, response, authException);
        }
    }
}