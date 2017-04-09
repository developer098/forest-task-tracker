package aim.foresttracker.site.security.epam;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

@Component("LoginSuccessHandler")
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private String baseUrl = ""; // baseUrl - prepare it from the request

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response);
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        String url = baseUrl + "/myUrl";
        responseWrapper.setHeader("location", url);
    }
}
