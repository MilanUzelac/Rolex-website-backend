package userservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import userservice.Model.User;
import userservice.Repository.UserRepository;

import java.util.Arrays;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(s);
        return new org.springframework.security.core.userdetails.User(user.getUserName(),"",true,true,true,true, Arrays.asList(new SimpleGrantedAuthority("USER")));
    }

}
