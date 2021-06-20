package tacos.security;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    public AppAuthenticationSuccessHandler() {
        super();
        setUseReferer(true);
    }
}
