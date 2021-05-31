package userservice.Services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

public class UserAuthenticationService {

    static final String SIGNINGKEY = "signignKey";
    static final String BEARER_PREFIX = "Bearer";

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        try{
            if (token != null) {
                String user = Jwts.parser().setSigningKey(SIGNINGKEY).parseClaimsJws(token.replace(BEARER_PREFIX, "")).getBody().getSubject();
                Claims claims = Jwts.parser().setSigningKey(SIGNINGKEY).parseClaimsJws(token.replace(BEARER_PREFIX, "")).getBody();
                System.out.println(claims);
                Object role = claims.get("role");
                System.out.println(role);
                System.out.println("Korisnik -> " + user);
                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
                } else {
                    throw new RuntimeException("Authentication failed");
                }
            }
        }catch (SignatureException e){
            System.out.println("Request Forbidden");
        }
        return null;
    }

}
