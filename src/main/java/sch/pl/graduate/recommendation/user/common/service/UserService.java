package sch.pl.graduate.recommendation.user.common.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import sch.pl.graduate.recommendation.user.common.model.User;

/**
 * Created by taesu on 2017-10-14.
 */
public interface UserService extends UserDetailsService{
    Integer addUser(User user);
}
