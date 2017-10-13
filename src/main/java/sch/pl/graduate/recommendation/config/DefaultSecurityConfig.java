/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Configuration
public class DefaultSecurityConfig  extends WebSecurityConfigurerAdapter{

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/about", "/signup", "/consigner/signup", "/caretaker/signup").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/admins/**").hasAnyRole("ADMIN")
                .antMatchers("/consigner/**").hasAnyRole("CONSIGNER")
                .antMatchers("/consigners/**").hasAnyRole("CONSIGNER")
                .antMatchers("/caretaker/**").hasAnyRole("CARETAKER")
                .antMatchers("/caretakers/**").hasAnyRole("CARETAKER")
                .antMatchers("/pet/**").hasAnyRole("ADMIN", "CONSIGNER", "CARETAKER")
                .antMatchers("/pets/**").hasAnyRole("ADMIN", "CONSIGNER", "CARETAKER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
    // create two users, admin and user
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("consigner").password("password").roles("CONSIGNER")
                .and()
                .withUser("caretaker").password("password").roles("CARETAKER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    }

}
