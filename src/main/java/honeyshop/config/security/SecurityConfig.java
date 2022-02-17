package honeyshop.config.security;

import honeyshop.security.filter.CustomAuthenticationFilter;
import honeyshop.security.filter.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/honeyshop/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers(
                        GET, "/honeyshop/shop/**")
                .permitAll();
        http.authorizeRequests().antMatchers(
                        POST, "/honeyshop/user/create", "/honeyshop/login")
                .permitAll();
        http.authorizeRequests().antMatchers(
                        GET, "/honeyshop/user/get/all")
                .hasAnyAuthority("USER", "ADMIN", "MAINADMIN");
        http.authorizeRequests().antMatchers(
                        GET, "/honeyshop/user/get/{username}")
                .hasAnyAuthority("USER", "ADMIN", "MAINADMIN");
        http.authorizeRequests().antMatchers(
                        POST, "/honeyshop/role/create")
                .hasAnyAuthority("MAINADMIN");
        http.authorizeRequests().antMatchers(
                        POST, "/honeyshop/role/add")
                .hasAnyAuthority("MAINADMIN");
        http.authorizeRequests().antMatchers(
                        GET, "/honeyshop/role/get/all")
                .hasAnyAuthority("MAINADMIN");

        http.authorizeRequests().antMatchers(
                        POST, "/honeyshop/sections/**")
                .hasAnyAuthority("USER");
        http.authorizeRequests().antMatchers(
                        PUT, "/honeyshop/sections/**")
                .hasAnyAuthority("USER");
        http.authorizeRequests().antMatchers(
                        DELETE, "/honeyshop/sections/**")
                .hasAnyAuthority("USER", "ADMIN", "MAINADMIN");
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(),
                UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
