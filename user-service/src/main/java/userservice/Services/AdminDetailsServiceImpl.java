package userservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import userservice.Model.UserAdmin;
import userservice.Repository.UserAdminRepository;
import java.util.Arrays;

public class AdminDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserAdminRepository userAdminRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserAdmin user = userAdminRepository.findByUserName(s);
        System.out.println("userADMIN -> " + user.getUserName());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), "", true, true, true, true, Arrays.asList(new SimpleGrantedAuthority("ADMIN")));
    }
}