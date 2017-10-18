package sch.pl.graduate.recommendation.user.common.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;

import java.util.List;

/**
 * Created by taesu on 2017-10-14.
 */
public interface UserService {
    Integer addUser(User user);

    User getUser(User user);

    User getUserByUserKey(Long userKey);

    User getUserByUserId(String userId);

    List<User> getUsers(UserCriteria userCriteria);

    Integer getUsersTotalCount(UserCriteria userCriteria);

    Integer updateUser(User user);

    Integer deleteUser(User user);

    User loadUserByUsername(String username);

    User getUserFromCurrentSession();
}
