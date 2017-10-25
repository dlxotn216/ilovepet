package sch.pl.graduate.recommendation.user.common.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.common.model.UserLoginHistory;
import sch.pl.graduate.recommendation.user.common.service.UserService;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.TimeZone;

/**
 * Created by taesu on 2017-10-14.
 */
@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user;
        Collection<? extends GrantedAuthority> authorities;

        try {
            user = userService.loadUserByUsername(username);
            logger.info("username : " + username + " / password : " + password);
            logger.info("username : " + user.getUsername() + " / password : " + user.getPassword());
            if (!passwordEncoder.matches(password, user.getPassword())) {
                addFailLoginHistory(user, "비밀번호가 일치하지 않습니다.");
                throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
            }
            authorities = user.getAuthorities();
            addSuccessLoginHistory(user);

        } catch (UsernameNotFoundException e) {
            user = new User();
            user.setUserId(username);
            addFailLoginHistory(user, e.toString());
            logger.info(e.toString());
            throw new UsernameNotFoundException(e.getMessage());
        } catch (BadCredentialsException e) {
            logger.info(e.toString());
            throw new BadCredentialsException(e.getMessage());
        } catch (Exception e) {
            user = new User();
            user.setUserId(username);
            addFailLoginHistory(user, e.toString());
            logger.info(e.toString());
            throw new RuntimeException(e.getMessage());
        }
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    private void addFailLoginHistory(User user, String failReason){
        final Long userKey = user.getUserKey();
        final String ip="127.0.0.1";        //TODO 실제 IP 얻어오는 로직 적용
        final Boolean isSuccess = false;
        final String userId = user.getUserId();
        Long currentMillis = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
        final Timestamp tryAt = new Timestamp(currentMillis);

        UserLoginHistory userLoginHistory = new UserLoginHistory(userKey, tryAt, ip, userId, isSuccess, failReason);
        userService.addUserLoginHistory(userLoginHistory);
    }

    private void addSuccessLoginHistory(User user){
        final Long userKey = user.getUserKey();
        final String ip="127.0.0.1";        //TODO 실제 IP 얻어오는 로직 적용
        final Boolean isSuccess = true;
        final String userId = user.getUserId();
        Long currentMillis = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
        final Timestamp tryAt = new Timestamp(currentMillis);

        UserLoginHistory userLoginHistory = new UserLoginHistory(userKey, tryAt, ip, userId, isSuccess, "성공");
        userService.addUserLoginHistory(userLoginHistory);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}


