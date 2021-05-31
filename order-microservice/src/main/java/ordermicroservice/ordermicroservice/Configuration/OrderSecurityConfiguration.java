package ordermicroservice.ordermicroservice.Configuration;


import ordermicroservice.ordermicroservice.Filters.OrderAdminAuthenticationFilter;
import ordermicroservice.ordermicroservice.Filters.OrderUserAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class OrderSecurityConfiguration {

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
                    .antMatcher("/user/**").addFilterBefore(new OrderUserAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

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
                    .antMatcher("/admin/**").addFilterBefore(new OrderAdminAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        }
    }


    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors()
                .and()
                .antMatcher("/api/order/**")
                .addFilterBefore(new OrderAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }*/
}
