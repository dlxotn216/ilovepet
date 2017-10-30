/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import sch.pl.graduate.recommendation.user.common.service.UserService;
import sch.pl.graduate.recommendation.user.common.service.impl.CustomAuthenticationProvider;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Configuration
public class DefaultSecurityConfig  extends WebSecurityConfigurerAdapter{

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/files", "/users", "/users/**/caretakers", "/signup", "/consigner/signup", "/caretaker/signup").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/admins/generate").permitAll()
                .antMatchers("/codes/**").hasAnyRole("ADMIN")
                .antMatchers("/code/**").hasAnyRole("ADMIN")
                .antMatchers("/admins/**").hasAnyRole("ADMIN")
                .antMatchers("/consigner/**").hasAnyRole("CONSIGNER")
                .antMatchers("/consigners/**").hasAnyRole("CONSIGNER", "ADMIN")
                .antMatchers("/caretaker/**").hasAnyRole("CARETAKER")
                .antMatchers("/caretakers/**").hasAnyRole("CARETAKER", "ADMIN")
                .antMatchers("/pet/**").hasAnyRole("ADMIN", "CONSIGNER", "CARETAKER")
                .antMatchers("/pets/**").hasAnyRole("ADMIN", "CONSIGNER", "CARETAKER")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "CONSIGNER", "CARETAKER")
                .antMatchers("/myprofile/caretaker").hasAnyRole( "CARETAKER")
                .antMatchers("/myprofile/**").hasAnyRole("ADMIN", "CONSIGNER", "CARETAKER")
                .antMatchers("/notice/add").hasAnyRole("ADMIN")
                .antMatchers("/notice/**/update").hasAnyRole("ADMIN")
                .antMatchers("/notice/**").hasAnyRole("ADMIN", "CONSIGNER", "CARETAKER")
                .antMatchers("/notice/**/detail").hasAnyRole("ADMIN", "CONSIGNER", "CARETAKER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("userId")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();
//                .and()
//                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
    // create two users, admin and user
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService);
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
