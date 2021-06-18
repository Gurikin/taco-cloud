package tacos.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    public AppAuthenticationSuccessHandler() {
        super();
        setUseReferer(true);
    }
}
