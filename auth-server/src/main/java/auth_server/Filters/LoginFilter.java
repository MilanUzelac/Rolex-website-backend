package auth_server.Filters;

import auth_server.Model.UserCredentials;
import auth_server.Services.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;


public class LoginFilter extends AbstractAuthenticationProcessingFilter {

    public LoginFilter(String url, AuthenticationManager authManager){
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException{
        System.out.println(req.getInputStream());
        UserCredentials userCredentials = new ObjectMapper().readValue(req.getInputStream(),UserCredentials.class);
        System.out.println(userCredentials.getUserName());
        System.out.println(userCredentials.getPassword());
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(userCredentials.getUserName(),userCredentials.getPassword(), Collections.emptyList()));
    }

    @Override
    public void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,Authentication auth){
        System.out.println(auth.getAuthorities());
        AuthenticationService.addJWTToken(res,auth.getName(),auth.getAuthorities().toString());
    }
}
