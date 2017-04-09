package aim.foresttracker.site.security.epam;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

@Component("LoginFailureHandler")
public class LoginFailureHandler implements AuthenticationFailureHandler {
    private String baseUrl = ""; // baseUrl - prepare it from the request

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response);
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        String url = baseUrl + "/myUrl";
        responseWrapper.setHeader("location", url);
    }
}
