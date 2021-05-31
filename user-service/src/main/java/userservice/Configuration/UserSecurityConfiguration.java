package userservice.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import userservice.Filters.AdminAuthenticationFilter;
import userservice.Filters.UserAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class UserSecurityConfiguration {

    @Order(1)
    @Configuration
    public static class UserSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().cors().and()
                    .authorizeRequests()
                    .antMatchers("/public/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .antMatcher("/user/**").addFilterBefore(new UserAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        }
    }

    @Order(2)
    @Configuration
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().cors().and()
                    .authorizeRequests()
                    .antMatchers("/public/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .antMatcher("/admin/**").addFilterBefore(new AdminAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        }
    }






    /*

     http.csrf().disable().cors().and()
                .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .antMatcher("/user/**").addFilterBefore(new UserAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class)
            .antMatcher("/admin/**").addFilterBefore(new AdminAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class);
    */




    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors()
                .and()
                .antMatcher("/users/**")
                .addFilterBefore(new UserAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }*/

   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors()
                .and()
                .antMatcher("/users/**")
                .addFilterBefore(new UserAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }*/
}
