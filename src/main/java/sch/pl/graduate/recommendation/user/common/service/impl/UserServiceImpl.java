package sch.pl.graduate.recommendation.user.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.role.service.RoleService;
import sch.pl.graduate.recommendation.user.common.mapper.UserMapper;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.common.service.UserService;

import java.util.List;

/**
 * Created by taesu on 2017-10-14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userMapper.getUserByUserId(userId);
        if (user == null) {
            throw new UsernameNotFoundException(userId + "는 존재하지 않는 계정입니다");
        }
        user.setAuthorities(getUserAuthorities(userId));
        return user;
    }

    private List<GrantedAuthority> getUserAuthorities(String userId) {
        return roleService.getUserRolesByUserId(userId);
    }
}
