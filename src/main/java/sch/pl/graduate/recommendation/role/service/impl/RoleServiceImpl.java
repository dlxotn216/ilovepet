package sch.pl.graduate.recommendation.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.role.mapper.RoleMapper;
import sch.pl.graduate.recommendation.role.model.Role;
import sch.pl.graduate.recommendation.role.service.RoleService;

import java.util.List;

/**
 * Created by taesu on 2017-10-14.
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public Role getRole(Role role) {
        return roleMapper.getRole(role);
    }

    @Override
    public Role getRoleByRoleKey(Long roleKey) {
        return roleMapper.getRoleByRoleKey(roleKey);
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleMapper.getRoleByRoleName(roleName);
    }

    @Override
    public List<GrantedAuthority> getUserRolesByUserId(String userId) {
        return roleMapper.getUserRolesByUserId(userId);
    }
}
