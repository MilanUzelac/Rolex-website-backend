package auth_server.Services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;


public class AuthenticationService {

    static final long EXPIRATIONTIME = 864_000_00;
    static final String SIGNINGKEY = "signignKey";
    static final String BEARER_PREFIX = "Bearer";

     static public void addJWTToken(HttpServletResponse response, String username, String role) {
        System.out.println("AddJWTToken method -> roleString -> " + role);
        String JwtToken = Jwts.builder().setSubject(username).claim("role",role).setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME)).signWith(SignatureAlgorithm.HS512, SIGNINGKEY).compact();
        response.addHeader("Authorization", BEARER_PREFIX + " " + JwtToken);
        String roleTrim = "";
        if(role.equals("[ADMIN]")){
            roleTrim="ADMIN";
        }else if(role.equals("[USER]")) {
            roleTrim = "USER";
        }
        response.addHeader("role",roleTrim);
        response.addHeader("Access-Control-Expose-Headers", "Authorization");


    }

    static public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        try{
            if (token != null) {
                String user = Jwts.parser().setSigningKey(SIGNINGKEY).parseClaimsJws(token.replace(BEARER_PREFIX, "")).getBody().getSubject();
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
